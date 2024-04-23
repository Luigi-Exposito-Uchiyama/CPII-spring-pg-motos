package br.com.fiap.motos.service;

import br.com.fiap.motos.dto.request.LojaRequest;
import br.com.fiap.motos.dto.response.LojaResponse;
import br.com.fiap.motos.entity.Loja;
import br.com.fiap.motos.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LojaService implements ServiceDTO<Loja, LojaRequest, LojaResponse> {

    @Autowired
    private LojaRepository repo;

    @Override
    public Loja toEntity(LojaRequest r) {
        return Loja.builder()
                .nome(r.nome())
                .build();
    }

    @Override
    public LojaResponse toResponse(Loja e) {

        return LojaResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .build();
    }


    @Override
    public List<Loja> findAll(Example<Loja> example) {
        return repo.findAll(example);
    }

    @Override
    public Loja findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Loja save(Loja e) {
        return repo.save(e);
    }

}