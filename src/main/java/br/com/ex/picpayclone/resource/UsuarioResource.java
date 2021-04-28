package br.com.ex.picpayclone.resource;

import br.com.ex.picpayclone.dto.UsuarioDTO;
import br.com.ex.picpayclone.resource.swagger.IUsuarioResource;
import br.com.ex.picpayclone.service.IUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource extends ResourceBase<UsuarioDTO> implements IUsuarioResource {

    private IUsuarioService usuarioService;

    @GetMapping("/{login}")
    public ResponseEntity<UsuarioDTO> consultar(@PathVariable String login) {
        UsuarioDTO usuario = usuarioService.consultar(login);
        return responderSucessoComItem(usuario);
    }

    @GetMapping("/contatos")
    public ResponseEntity<List<UsuarioDTO>> listar(@RequestParam String login) {
        List<UsuarioDTO> usuarios = usuarioService.listar(login);
        return responderListaDeItens(usuarios);
    }

    @GetMapping("/{login}/saldo")
    public ResponseEntity<UsuarioDTO> consultarSaldo(@PathVariable String login) {
        UsuarioDTO usuarioDTO = usuarioService.consultar(login);
        return responderSucessoComItem(usuarioDTO);
    }

}
