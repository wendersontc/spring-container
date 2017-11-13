package br.com.jp.controller;

import br.com.jp.domain.Pojo;
import br.com.jp.service.PojoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author JP on 10/10/17.
 */
@Api(description = "Controller para acesso aos serviços do Pojo")
@RestController
@RequestMapping(value = "/pojo")
public class PojoController {

    private final PojoService service;

    @Autowired
    public PojoController(PojoService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Pojo> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pojo create(@RequestBody @Valid Pojo pojo) {
        return service.save(pojo);
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public Pojo findById(@PathVariable Long id) {

        return service.findById(id);
    }
}
