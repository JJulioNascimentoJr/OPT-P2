package com.Biblioteca.App.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Biblioteca.App.Model.Pessoa;
import com.Biblioteca.App.Service.PessoaService;

@Controller
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping("/pessoa/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/pessoa");
		mv.addObject("pessoa", service.findAll());

		return mv;
	}
	
	@GetMapping("/pessoa/add")
	public ModelAndView add(Pessoa pessoa) {

		ModelAndView mv = new ModelAndView("/pessoaAdd");
		mv.addObject("pessoa", pessoa);

		return mv;
	}
	
	@GetMapping("/pessoa/edit/{rg}")
	public ModelAndView edit(@PathVariable("rg") int rg) {

		return add(service.findOne(rg));
	}
	
	@GetMapping("/pessoa/delete/{rg}")
	public ModelAndView delete(@PathVariable("rg") int rg) {

		service.delete(rg);

		return findAll();
	}
	
	@PostMapping("/pessoa/save")
	public ModelAndView save(@Valid Pessoa pessoa, BindingResult result) {

		if (result.hasErrors()) {
			return add(pessoa);
		}

		service.save(pessoa);

		return findAll();
	}
}
