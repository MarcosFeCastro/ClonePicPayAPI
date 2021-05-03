package br.com.ex.picpayclone.resource;

import br.com.ex.picpayclone.dto.TransacaoDTO;
import br.com.ex.picpayclone.service.ITransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/transacoes")
public class TransacaoResource extends ResourceBase<TransacaoDTO> {

    @Autowired
    private ITransacaoService transacaoService;

    @PostMapping
    @CacheEvict(cacheNames = "Transacoes", allEntries = true)
    public ResponseEntity<TransacaoDTO> salvar(@RequestBody @Valid TransacaoDTO transacaoDTO, UriComponentsBuilder uriBuilder) {
        TransacaoDTO transacaoRetornoDTO = transacaoService.processar(transacaoDTO);
        return responderItemCriadoComURI(transacaoRetornoDTO, uriBuilder, "/transasoes/{codigo}", transacaoRetornoDTO.getCodigo());
    }

    @GetMapping
    @Cacheable(cacheNames = "Transacoes", key = "#root.method.name")
    public ResponseEntity<Page<TransacaoDTO>> listar(@PageableDefault(page = 0, size = 20) Pageable paginacao, @RequestParam String login) {
        Page<TransacaoDTO> transacoes = transacaoService.listar(paginacao, login);
        return responderListaDeItensPaginada(transacoes);
    }

}
