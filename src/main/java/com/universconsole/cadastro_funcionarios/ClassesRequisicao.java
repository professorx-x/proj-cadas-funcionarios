package com.universconsole.cadastro_funcionarios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

@RestController
public class ClassesRequisicao 
{
	@Autowired
	Repositorio repo;
	
	@PostMapping("pesquisa_cargo")
	public String pesquisa_cargo(@RequestParam String resposta)
	{
		Iterable<Funcionarios> funci = repo.findAll();
		
		String tabela = "";
		
		for(Funcionarios f: funci)
		{
			if(resposta.toLowerCase().indexOf(f.getCargo().toLowerCase()) > -1)
			{
				tabela = tabela + "<tr><td style='border: groove 0.5px'>" + f.getNome() + "</td><td style='border: groove 0.5px'>" + f.getId() + "</td></tr>";
			}
		}
		
		return "<h4> Cargos de " + resposta + " <h4> <table><tr ><th style='border: groove 0.5px'> Nome Completo </th><th style='border: groove 0.5px'> ID </th>" + tabela + "</table>"; 
	}
	
	@PostMapping("atualizando_cadastro_nome")
	public String atualizando_cadastro_nome(@RequestParam String nome)
	{
		Iterable<Funcionarios> funci = repo.findAll();
		
		String tabela = "";
		int numStringNome = nome.length();
		
		for(Funcionarios f: funci)
		{
			if( (nome.toLowerCase().indexOf(f.getNome().toLowerCase()) > -1) && (numStringNome == f.getNome().length()) )
			{
				tabela = f.getId() + "-"  + f.getNome() + "-"  + f.getCargo()	 + "-"  +  f.getDataNascimento() + "-"  + f.getSexo() + "-"  + f.getDataCadastro();
			}
		}
		
		return tabela;
	}
	
	@PostMapping("pesquisa_id")
	public String pesquisa_id(@RequestParam int resposta)
	{
		Optional<Funcionarios> funci = repo.findById(resposta);
		
		//return " " + funci;
		
		if(!funci.isEmpty())
		{
			Funcionarios f = funci.get();
			
			String sexo = "";
			if(f.getSexo().indexOf("m") > -1)
			{
				sexo = "Masculino";
			}
			else
			{
				sexo = "Feminino";
			}
			
			return "<table style='margin-top: 25px;'> <tr> <th style='border: groove 0.5px'> ID </th> <td style='border: groove 0.5px'> " + f.getId() + "</td> </tr> <tr> <th style='border: groove 0.5px'> Nome </th> <td style='border: groove 0.5px'> " + f.getNome() + "</td> </tr> <tr> <th style='border: groove 0.5px'> Sexo </th> <td style='border: groove 0.5px'> " + sexo + "</td> </tr> <tr> <th style='border: groove 0.5px'> Data de Nascimento </th> <td style='border: groove 0.5px'> " + f.getDataNascimento() + "</td> </tr> <tr> <th style='border: groove 0.5px'> Data de Cadastro </th> <td style='border: groove 0.5px'> " + f.getDataCadastro() + "</td> </tr> <table>";
		}
		else
		{
			return "<h4> ID não existe </h4>";
		}
	}
	
	@PostMapping("atualizando_cadastro_id")
	public String atualizando_cadastro_id(@RequestParam int id)
	{
		Iterable<Funcionarios> funci = repo.findAll();
		
		String tabela = "";
		//int numStringId = nome.length();
		
		for(Funcionarios f: funci)
		{
			if( id == f.getId() )
			{
				String sexo = "";
				tabela = f.getId() + "-"  + f.getNome() + "-"  + f.getCargo()	 + "-"  +  f.getDataNascimento() + "-"  + f.getSexo() + "-"  + f.getDataCadastro();
			}
		}
		
		return tabela;
	}
	
}
