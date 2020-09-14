package gov.goias.smart.colaborador.resource;

import gov.goias.smart.colaborador.dto.ColaboradorDTO;
import gov.goias.smart.colaborador.entity.Colaborador;
import gov.goias.smart.colaborador.entity.Sexo;
import gov.goias.smart.colaborador.entity.Situacao;
import gov.goias.smart.colaborador.repository.ColaboradorRepository;
import gov.goias.smart.colaborador.service.ColaboradorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.Collection;

@Slf4j
@RestController
@Api(value = "Operações de CRUD em Colaborador")
@RequestMapping(value = "/colaboradores", path = "/colaboradores")
public class ColaboradorResource {

    @Autowired
    private ColaboradorRepository repository;

    @Autowired
    private ColaboradorService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Armazena o colaborador.", notes = "Armazena o colaborador no repositorio de dados.")
    public ColaboradorDTO post(@RequestBody ColaboradorDTO colaboradorDTO) {

        log.trace("POST {colaborador}", colaboradorDTO);

        return service.saveCreate(colaboradorDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Altera o registro do colaborador.", notes = "Altera o registro do colaborador na base de dados.")
    public ColaboradorDTO put(@RequestBody ColaboradorDTO colaboradorDTO) {

        log.trace("PUT {colaborador}", colaboradorDTO);

        return service.saveUpdate(colaboradorDTO);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Apagar o colaborador.", notes = "Apaga o colaborador na base de dados.")
    public void delete(@PathVariable Long id) {

        log.trace("DELETE {id}", id);
        service.deleteById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Listar todos Colaboradores.", notes = "Listar todos Colaboradores.")
    public Collection<Colaborador> list() {

        log.trace("GET findAll");

        return repository.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Retorna o colaborador pelo seu Identificador.", notes = "Obter colaborador por Identificador.")
    public Colaborador findById(@PathVariable Long id) {

        log.trace("GET {id}", id);

        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Colaborador : " + id));
    }

    @GetMapping(path = "/sexos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Listar todos os Sexos de Colaboradores.", notes = "Listar todos Sexos dos Colaboradores.")
    public Collection<Sexo> sexos() {

        log.trace("GET Lista Sexo Colaborador");

        return Arrays.asList(Sexo.values());
    }

    @GetMapping(path = "/situacoes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Listar todos as Situações de Colaboradores.", notes = "Listar todas as Situações dos Colaboradores.")
    public Collection<Situacao> situacoes() {

        log.trace("GET Lista Situação Colaborador");

        return Arrays.asList(Situacao.values());
    }
}