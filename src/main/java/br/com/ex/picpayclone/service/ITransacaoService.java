package br.com.ex.picpayclone.service;


import br.com.ex.picpayclone.dto.TransacaoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITransacaoService {

    TransacaoDTO processar(TransacaoDTO transacaoDTO);

    Page<TransacaoDTO> listar(Pageable paginacao, String login);

}
