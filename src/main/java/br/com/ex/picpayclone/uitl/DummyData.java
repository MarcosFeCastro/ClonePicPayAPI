package br.com.ex.picpayclone.uitl;

import br.com.ex.picpayclone.model.Usuario;
import br.com.ex.picpayclone.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

import static br.com.ex.picpayclone.enums.TipoPermissao.USUARIO;

@Component
public class DummyData {

    @Autowired
    UsuarioRepository usuarioRepository;

    // @PostConstruct
    public void createUsers() {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        Usuario u1 = new Usuario();
        u1.setLogin("joao");
        u1.setSenha(passwordEncoder.encode("12345678"));
        u1.setEmail("joao@test.com");
        u1.setNomeCompleto("João Silva");
        u1.setCpf("123.456.789.10");
        u1.setDataNascimento(LocalDate.of(1999,3,11));
        u1.setNumeroTelefone("91234-5678");
        u1.setSaldo(300.0);
        u1.setAtivo(false);
        u1.setCartoesCredito(null);
        u1.setPermissao(USUARIO);
        Usuario user1 = usuarioRepository.save(u1);
        System.out.println(user1.getId());

        Usuario u2 = new Usuario();
        u2.setLogin("ana");
        u2.setSenha(passwordEncoder.encode("12345678"));
        u2.setEmail("ana@test.com");
        u2.setNomeCompleto("Ana Maria");
        u2.setCpf("123.456.789.11");
        u2.setDataNascimento(LocalDate.of(1999,10,9));
        u2.setNumeroTelefone("91234-5678");
        u2.setSaldo(300.0);
        u2.setAtivo(true);
        u2.setCartoesCredito(null);
        u2.setPermissao(USUARIO);
        Usuario user2 = usuarioRepository.save(u2);
        System.out.println(user2.getId());

    }

}
