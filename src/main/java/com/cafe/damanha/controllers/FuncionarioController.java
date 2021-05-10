package com.cafe.damanha.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafe.damanha.models.Funcionario;
import com.cafe.damanha.repository.FuncionarioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/cafe")
public class FuncionarioController {

	@Autowired
	FuncionarioRepository funcRepository;

	@GetMapping("/funcionarios")
	public List<Funcionario> listaFuncionarios() {

		return funcRepository.listFuncionarios();
	}

	@GetMapping("/funcionarios/{cpf}")
	public List<Funcionario> listaUmFuncionario(@PathVariable(value = "cpf") String cpf) {

		return funcRepository.listFuncionarios(cpf);
	}

	@PostMapping("/funcionario")
	public Funcionario persistFuncionario(@RequestBody @Valid Funcionario funcionario) {

		String novoNome = funcionario.getNome();
		String novoCPF = funcionario.getCpf();
		String novoITEM = funcionario.getItemcafe();

		List<Funcionario> listF = funcRepository.listFuncionarios();

		for (Funcionario lf : listF) {

			if (!novoNome.equals(lf.getNome()) && novoCPF.equals(lf.getCpf())) {

				return null;

			} else if (novoITEM.equals(lf.getItemcafe())) {

				return null;
			}

		}

		return funcRepository.save(funcionario);
	}

	@DeleteMapping("/funcionario")
	public void deleteCafe(@RequestBody @Valid Funcionario funcionario) {

		funcRepository.delete(funcionario);
	}

	@PutMapping("/funcionario")
	public Funcionario atualizarFuncionario(@RequestBody @Valid Funcionario funcionario) {

		String novoNome = funcionario.getNome();
		String novoCPF = funcionario.getCpf();
		String novoITEM = funcionario.getItemcafe();
		if (novoNome == null && novoCPF == null && novoITEM == null) {
			return null;
		}

		return funcRepository.save(funcionario);
	}

}
