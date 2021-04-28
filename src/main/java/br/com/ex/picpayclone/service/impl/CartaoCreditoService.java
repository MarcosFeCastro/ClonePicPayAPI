package br.com.ex.picpayclone.service.impl;

import br.com.ex.picpayclone.conversor.CartaoCreditoConversor;
import br.com.ex.picpayclone.dto.CartaoCreditoDTO;
import br.com.ex.picpayclone.model.CartaoCredito;
import br.com.ex.picpayclone.repository.CartaoCreditoRepository;
import br.com.ex.picpayclone.service.ICartaoCreditoService;
import br.com.ex.picpayclone.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoCreditoService implements ICartaoCreditoService {

    @Autowired
    private CartaoCreditoRepository cartaoCreditoRepository;

    @Autowired
    private CartaoCreditoConversor cartaoCreditoConversor;

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    public CartaoCreditoDTO salvar(CartaoCreditoDTO cartaoCreditoDTO) {
        CartaoCreditoDTO cartaoCreditoRetorno = null;
        if (cartaoCreditoDTO.getIsSalva()) {
            CartaoCredito cartaoCredito = cartaoCreditoConversor.converterDtoParaEntidade(cartaoCreditoDTO);
            usuarioService.validar(cartaoCredito.getUsuario());
            CartaoCredito cartaoCreditoSalvo = cartaoCreditoRepository.save(cartaoCredito);
            cartaoCreditoRetorno = cartaoCreditoConversor.converterEntidadeParaDto(cartaoCreditoSalvo);
        }

        return cartaoCreditoRetorno;
    }

}
