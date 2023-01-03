package com.talissonmelo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.talissonmelo.modelo.Escola;
import com.talissonmelo.servico.EscolaServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/escolas")
public class EscolaControlador {
	
	@Autowired
	private EscolaServico servico;

	@GetMapping
	public List<Escola> listar() {
		return servico.listar();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Escola persistir(@Valid @RequestBody Escola escola) {
		return servico.salvar(escola);
	}
}
