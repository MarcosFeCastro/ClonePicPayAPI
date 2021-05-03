package br.com.ex.picpayclone.service.impl;

import br.com.ex.picpayclone.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${picpayclone.jwt.expiration}")
    private String expiration;

    @Value("${picpayclone.jwt.secret}")
    private String secretKey;

    public String gerarToken(Authentication authenticate) {
        Usuario usuarioLogado = (Usuario) authenticate.getPrincipal();
        Date hoje = new Date();
        Date tempoExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
        return Jwts.builder().setIssuer("API PicPay Clone")
                .setSubject(usuarioLogado.getId().toString())
                .setIssuedAt(tempoExpiracao)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJwt(token).getBody();
        return Long.parseLong(claims.getSubject());
    }

}
