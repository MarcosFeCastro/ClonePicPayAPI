package br.com.ex.picpayclone.uitl;

import br.com.ex.picpayclone.model.Usuario;
import br.com.ex.picpayclone.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class DummyData {

    @Autowired
    UsuarioRepository usuarioRepository;

    // @PostConstruct
    public void createUsers() {

        Usuario u1 = new Usuario();
        u1.setLogin("joao");
        u1.setSenha("123");
        u1.setEmail("joao@test.com");
        u1.setNomeCompleto("João Silva");
        u1.setCpf("123.456.789.10");
        u1.setDataNascimento(LocalDate.of(1999,3,11));
        u1.setNumeroTelefone("91234-5678");
        u1.setSaldo(300.0);
        u1.setAtivo(false);
        u1.setCartoesCredito(null);
        // Usuario user = usuarioRepository.save(u1);
        // System.out.println(user.getId());

        Usuario u2 = new Usuario();
        u2.setLogin("ana");
        u2.setSenha("123");
        u2.setEmail("ana@test.com");
        u2.setNomeCompleto("Ana Maria");
        u2.setCpf("123.456.789.11");
        u2.setDataNascimento(LocalDate.of(1999,10,9));
        u2.setNumeroTelefone("91234-5678");
        u2.setSaldo(300.0);
        u2.setAtivo(true);
        u2.setCartoesCredito(null);
        // Usuario user = usuarioRepository.save(u2);
        // System.out.println(user.getId());

    }

}
