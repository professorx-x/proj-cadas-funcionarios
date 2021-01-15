package com.universconsole.cadastro_funcionarios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;


//@RestController
@Controller
public class TesteClasseSpring 
{
	
	@Autowired
	private Repositorio repo;
	
	@GetMapping("/")
	public ModelAndView index()
	{
		ModelAndView mev = new ModelAndView("index");
		Iterable<Funcionarios> funci = repo.findAll();
		
		// NUMERO DE FUNCIONARIOS
		
		int num = 0;
		HashSet <String> cargosCadastrados = new HashSet<String>(); 
		
		for(Funcionarios f: funci)
		{
			cargosCadastrados.add(f.getCargo());
			num++;
		}
		
		ArrayList<Integer> numCargos = new ArrayList<Integer>();
		//ArrayList cargosENum = new ArrayList();
		Funcionarios fun = new Funcionarios();
		
		//for(int i2 = 0; i2 < cargosCadastrados.size(); i2++)
		
		String tabela = "";
		//TabelaProf tabProf = new TabelaProf();
				
		for(String prof: cargosCadastrados)
		{
			int num2 = 0;
			for(Funcionarios f: funci)
			{
				if(prof.indexOf(f.getCargo()) > -1)
				{
					num2++;
				}
			}
			
			numCargos.add(num2);
		}
		
		//int num3 = funci.	cargosCadastrados.size();
		
		//mev.addObject("tabelaCargos", tabProf);
		mev.addObject("numCargos", numCargos);
		//mev.addObject("tabelaCargos", tabProf);
		mev.addObject("numero", num);
		mev.addObject("cargos", cargosCadastrados);
		
		return mev;
	}
	
	@GetMapping("/cadastro_funcionario")
	public String cadastro_funcionario()
	{
		return "cadastro_funcionario";
	}
	
	@GetMapping("/atualiza_funcionario")
	public String atualiza_funcionario()
	{
		return "atualiza_funcionario";
	}
	
	@PostMapping("alterando_dados")
	public String auterando_dados(@RequestParam String nome1, @RequestParam String nome, @RequestParam String cargo, @RequestParam String dataNascimento, @RequestParam String sexo)
	{
		Iterable<Funcionarios> funci = repo.findAll();
		Funcionarios funci2 = new Funcionarios();
		
		boolean sucesso = false;
		int pegandoId = 0;
		
		for(Funcionarios f: funci)
		{
			if(nome1.toLowerCase().indexOf(f.getNome().toLowerCase()) > -1)
			{
				f.setNome(nome);
				f.setCargo(cargo);
				f.setDataNascimento(dataNascimento);
				f.setSexo(sexo);
				//f.setDataCadastro(dataCadastro);
				repo.save(f);
				
				sucesso = true;
			}
		}
		
		if(sucesso == true)
		{
			return "messagens/alterar_dados_sucesso";
		}
		else
		{
			return "messagens/alterar_dados_erro";
		}
	}
	
	@GetMapping("/deletar_funcionario")
	public String deletar_funcionario()
	{
		return "deletar_funcionario";
	}	
	
	@PostMapping("deletando_dados")
	public String deletando_dados(@RequestParam String nome1)
	{
		Iterable<Funcionarios> funci = repo.findAll();
		Funcionarios funci2 = new Funcionarios();
		
		boolean sucesso = false;
		int pegandoId = 0;
		
		for(Funcionarios f: funci)
		{
			if(nome1.toLowerCase().indexOf(f.getNome().toLowerCase()) > -1)
			{
				repo.delete(f);
				sucesso = true;
			}
		}
		
		if(sucesso == true)
		{
			return "messagens/deletar_dados_sucesso";
		}
		else
		{
			return "messagens/deletar_dados_erro";
		}
	}
	
	@GetMapping("/testok")
	public String testOk()
	{
		return "Classe do Spring Funcionando";
	}
	
	@PostMapping("/recebendo_dados")
	public String recebendo_dados(@RequestParam String nome, @RequestParam String cargo, @RequestParam String dataNascimento, @RequestParam String sexo)
	{
		Date data = new Date();
		SimpleDateFormat formaData = new SimpleDateFormat("dd/MM/yyyy");
		String dataCadastro = formaData.format(data);
		
		Iterable<Funcionarios> achaNome = repo.findAll();
		boolean sucesso = true; 
		
		for(Funcionarios f: achaNome)
		{
			if(f.getNome().toLowerCase().indexOf(nome.toLowerCase()) > -1)
			{
				sucesso = false;
			}
		}
		
		if(sucesso == true)
		{
			Funcionarios funcionarios = new Funcionarios(nome, cargo, dataNascimento, sexo, dataCadastro);
			repo.save(funcionarios);
			
			if ( (nome != null) || (cargo != null) || (dataNascimento != null) || (sexo != null) || (nome != " ") || (cargo != " ") || (dataNascimento != " ") )  
			{
				return "messagens/recebendo_dados_sucesso";
			}
			else
			{
				return "messagens/recebendo_dados_erro";
			}
		}
		else
		{
			return "messagens/recebendo_dados_erro2";
		}
		
	}
	
	
	Funcionarios funcionarios = new Funcionarios();
	
	@GetMapping("/resposta")
	public ModelAndView resposta()
	{
		ModelAndView modeloEVisao = new ModelAndView("/resposta");
		String nome = "Julia".toLowerCase();
		Iterable<Funcionarios> funci = repo.findAll();
		
		for(Funcionarios fun: funci)
		{
			if( fun.getNome().toLowerCase().indexOf(nome) > -1)
			{
				funcionarios.setId(fun.getId());
				funcionarios.setNome(fun.getNome());
				funcionarios.setCargo(fun.getCargo());
				
				modeloEVisao.addObject("funci", funcionarios);
			}
		}
		
		return modeloEVisao;
	}
	
	@GetMapping("messagens/alterar_dados_sucesso")
	public String alterar_dados_sucesso()
	{
		return "messagens/alterar_dados_sucesso";
	}
	
	@GetMapping("messagens/alterar_dados_erro")
	public String alterar_dados_erro()
	{
		return "messagens/alterar_dados_erro";
	}
	
	@GetMapping("messagens/deletar_dados_sucesso")
	public String deletar_dados_sucesso()
	{
		return "messagens/deletar_dados_sucesso";
	}
	
	@GetMapping("messagens/deletar_dados_erro")
	public String deletar_dados_erro()
	{
		return "messagens/deletar_dados_erro";
	}
	
	@GetMapping("messagens/recebendo_dados_sucesso")
	public String recebendo_dados_sucesso()
	{
		return "messagens/recebendo_dados_sucesso";
	}
	
	@GetMapping("messagens/recebendo_dados_erro")
	public String recebendo_dados_erro()
	{
		return "messagens/recebendo_dados_erro";
	}
}
