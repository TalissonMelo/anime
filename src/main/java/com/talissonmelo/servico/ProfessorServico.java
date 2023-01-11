package com.talissonmelo.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.talissonmelo.modelo.Escola;
import com.talissonmelo.modelo.Professor;
import com.talissonmelo.repositorio.ProfessorRepositorio;

@Service
public class ProfessorServico {

	@Autowired
	private ProfessorRepositorio repositorio;
	
	@Autowired
	private EscolaServico escolaServico;

	public List<Professor> listar(String nome, Integer numero, String nomeHeroi, Long idEscola) {
		Professor professor = new Professor();
		professor.setNome(nome);
		professor.setNumero(numero);
		professor.setNomeHeroi(nomeHeroi);
		if (idEscola != null) {
			Escola escola = escolaServico.listarPorId(idEscola);
			professor.setEscola(escola);
		}
		Example<Professor> example = Example.of(professor,ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return repositorio.findAll(example);
	}

}