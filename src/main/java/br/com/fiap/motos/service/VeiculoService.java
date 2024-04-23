package br.com.fiap.motos.service;

        import br.com.fiap.motos.dto.request.VeiculoRequest;
        import br.com.fiap.motos.dto.response.VeiculoResponse;
        import br.com.fiap.motos.entity.Veiculo;
        import br.com.fiap.motos.repository.VeiculoRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Example;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class VeiculoService implements ServiceDTO<Veiculo, VeiculoRequest, VeiculoResponse> {

    @Autowired
    private VeiculoRepository repo;

    @Autowired
    private TipoVeiculoService tipoService;

    @Autowired
    private FabricanteService fabricanteService;


    @Override
    public Veiculo toEntity(VeiculoRequest r) {
        var tipo = tipoService.findById( r.tipo().id() );
        var fabricante = fabricanteService.findById( r.fabricante().id() );
        return Veiculo.builder()
                .tipo( tipo )
                .fabricante( fabricante )
                .preco( r.preco() )
                .modelo( r.modelo() )
                .anoDeFabricacao( r.anoDeFabricante() )
                .cor( r.cor() )
                .palavraDeEfeito( r.palavraDeEfeito() )
                .cilindradas( r.cilindradas() )
                .nome( r.nome() )
                .build();
    }

    @Override
    public VeiculoResponse toResponse(Veiculo e) {

        var fabricante = fabricanteService.toResponse(e.getFabricante());
        var tipo = tipoService.toResponse(e.getTipo());
        return VeiculoResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .modelo(e.getModelo())
                .anoDeFabricante(e.getAnoDeFabricacao())
                .preco(e.getPreco())
                .palavraDeEfeito(e.getPalavraDeEfeito())
                .fabricante(fabricante)
                .tipo(tipo)
                .cilindradas(e.getCilindradas())
                .build();
    }

    @Override
    public List<Veiculo> findAll(Example<Veiculo> example) {
        return repo.findAll( example );
    }

    @Override
    public Veiculo findById(Long id) {
        return repo.findById( id ).orElse( null );
    }

    @Override
    public Veiculo save(Veiculo e) {
        return repo.save( e );
    }
}