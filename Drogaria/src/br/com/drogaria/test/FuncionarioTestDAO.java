package br.com.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;

public class FuncionarioTestDAO {
	
	@Test
	@Ignore
	public void salvar(){
		Funcionario funcionario = new Funcionario();
		
		funcionario.setCpf("37683476803");
		funcionario.setFuncao("Desenvolvedor");
		funcionario.setNome("Rodrigo Contarini");
		funcionario.setSenha("ro300191");
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.salvar(funcionario);
		
		Funcionario f2 = new Funcionario();
		
		f2.setCpf("12345678910");
		f2.setFuncao("Aprendiz");
		f2.setNome("Davi Contarini");
		f2.setSenha("contarini");
		
		FuncionarioDAO funcionarioDAO2 = new FuncionarioDAO();
		funcionarioDAO2.salvar(f2);
	}
	
	@Test
	@Ignore
	public void listar(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> funcionarios = funcionarioDAO.listar();
		
		for(Funcionario funcionario : funcionarios){
			System.out.println(funcionario);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		Funcionario f1 = funcionarioDAO.buscarPorCodigo(3L);
		
		System.out.println(f1);
			
	}
	
	@Test
	@Ignore
	public void excluir(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(3L);
		funcionarioDAO.excluir(funcionario);
	}
	
	@Test
	public void editar(){
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		Funcionario funcionario = funcionarioDAO.buscarPorCodigo(1L);
		
		funcionario.setCpf("12345678910");
		funcionario.setFuncao("Desenvolvedor Mobile");
		funcionario.setNome("Davi Contarini");
		funcionario.setSenha("Contarini");
		
		funcionarioDAO.editar(funcionario);
		
	}

}
