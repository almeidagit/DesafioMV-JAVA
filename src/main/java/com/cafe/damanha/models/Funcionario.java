package com.cafe.damanha.models;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TAB_FUNCIONARIO")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	private String cpf;

	@NotNull
	private String nome;

	@NotNull
	private String itemcafe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemcafe() {
		return itemcafe;
	}

	public void setItemcafe(String itemcafe) {
		this.itemcafe = itemcafe;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
