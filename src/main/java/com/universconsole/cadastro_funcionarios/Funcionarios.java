package com.universconsole.cadastro_funcionarios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Funcionarios 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String nome;
	private String cargo;
	
	private String dataNascimento;
	private String sexo;
	private String dataCadastro;
	
	public Funcionarios() 
	{
	
	}
	
	public Funcionarios(int id) 
	{
		this.id = id;
	}

	public Funcionarios(String nome, String cargo, String dataNascimento, String sexo, String dataCadastro) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.dataCadastro = dataCadastro;
	}

	public Funcionarios(int id, String nome, String cargo, String dataNascimento, String sexo, String dataCadastro) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.dataCadastro = dataCadastro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
	
	
}
