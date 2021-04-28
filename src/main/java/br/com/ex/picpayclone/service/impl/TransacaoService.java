package br.com.ex.picpayclone.service.impl;

import br.com.ex.picpayclone.conversor.TransacaoConversor;
import br.com.ex.picpayclone.dto.TransacaoDTO;
import br.com.ex.picpayclone.model.Transacao;
import br.com.ex.picpayclone.repository.TransacaoRepository;
import br.com.ex.picpayclone.service.ICartaoCreditoService;
import br.com.ex.picpayclone.service.ITransacaoService;
import br.com.ex.picpayclone.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransacaoService implements ITransacaoService {

    @Autowired
    private TransacaoConversor transacaoConversor;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private ICartaoCreditoService cartaoCreditoService;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Override
    public TransacaoDTO processar(TransacaoDTO transacaoDTO) {
        Transacao transacao = salvar(transacaoDTO);
        cartaoCreditoService.salvar(transacaoDTO.getCartaoCredito());
        usuarioService.atualizarSaldo(transacao, transacaoDTO.getIsCartaoCredito());
        return transacaoConversor.converterEntidadeParaDto(transacao);
    }

    @Override
    public Page<TransacaoDTO> listar(Pageable paginacao, String login) {
        Page<Transacao> transacaos = transacaoRepository.findByOrigem_LoginOrDestino_Login(login, login, paginacao);
        return transacaoConversor.converterPageEntidadeParaDto(transacaos);
    }

    private Transacao salvar(TransacaoDTO transacaoDTO) {
        Transacao transacao = transacaoConversor.converterDtoParaEntidade(transacaoDTO);
        usuarioService.validar(transacao.getOrigem(), transacao.getDestino());
        return transacaoRepository.save(transacao);
    }

}
