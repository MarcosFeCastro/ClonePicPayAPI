package br.com.ex.picpayclone.dto;

import br.com.ex.picpayclone.enums.BandeiraCartao;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CartaoCreditoDTO {

    @NotBlank
    private BandeiraCartao bandeira;

    @NotBlank
    private String codigoSeguranca;

    @NotBlank
    private String dataExpiracao;

    @NotBlank
    private String nomeTitular;

    private String numero;

    private String numeroToken;

    @NotNull
    private UsuarioDTO usuario;

    private Boolean isSalva = false;

}
