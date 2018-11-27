package com.Biblioteca.App.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Biblioteca.App.Model.Emprestimo;
import com.Biblioteca.App.Repository.EmprestimoRepository;

@Service
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository repository;

	public List<Emprestimo> findAll() {
		return repository.findAll();
	}

	public Emprestimo findOne(int id) {
		return repository.findOne(id);
	}

	public Emprestimo save(Emprestimo post) {
		
		   return repository.saveAndFlush(post);
		
	}

	public void delete(int id) {
		repository.delete(id);
	}
}
