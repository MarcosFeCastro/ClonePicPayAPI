package br.com.ex.picpayclone.service;

import br.com.ex.picpayclone.dto.UsuarioDTO;
import br.com.ex.picpayclone.model.Transacao;
import br.com.ex.picpayclone.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    Usuario consultarEntidade(String login);

    void validar(Usuario... usuarios);

    void atualizarSaldo(Transacao transacao, Boolean isCartaoCredito);

    UsuarioDTO consultar(String login);

    List<UsuarioDTO> listar(String login);

}
