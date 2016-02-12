package br.com.camtwo.reunioes.controller;

import br.com.camtwo.reunioes.model.basic.Id;
import br.com.camtwo.reunioes.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Vitor Zachi Junior
 * @since 01/02/16
 */
@Controller
@RequestMapping(name = "/")
public class IndexController {

    @Autowired private PessoaRepository pessoaRepository;



    @RequestMapping(value = "teste")
    public String teste(){
        pessoaRepository.findOne(new Id(2l));
        return "dashboard/index";
    }

    @RequestMapping(value = "")
    public String index(){
        return "index";
    }
}
