package br.com.drogaria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FuncionarioBean {
	

	private Funcionario funcionarioCadastro;
	
	private List<Funcionario> listarFuncionarios;
	private List<Funcionario> listarFuncionariosFiltrados;
	
	private String acao;
	private Long codigo;
	
	public Funcionario getFuncionarioCadastro() {
		if(funcionarioCadastro == null){
			funcionarioCadastro = new Funcionario();
		}
		return funcionarioCadastro;
	}
	
	public void setFuncionarioCadastro(Funcionario funcionarioCadastro) {
		this.funcionarioCadastro = funcionarioCadastro;
	}
	
	public void setListarFuncionarios(List<Funcionario> listarFuncionarios) {
		this.listarFuncionarios = listarFuncionarios;
	}
	
	public List<Funcionario> getListarFuncionarios() {
		return listarFuncionarios;
	}
	
	public void setListarFuncionariosFiltrados(List<Funcionario> listarFuncionariosFiltrados) {
		this.listarFuncionariosFiltrados = listarFuncionariosFiltrados;
	}
	
	public List<Funcionario> getListarFuncionariosFiltrados() {
		return listarFuncionariosFiltrados;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public String getAcao() {
		return acao;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void novo(){
		
		funcionarioCadastro = new Funcionario();
	}
	
	public void salvar(){
		try {
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.salvar(funcionarioCadastro);
			
			funcionarioCadastro = new Funcionario();
			
			
			FacesUtil.addMsgInfo("Funcionario Salvo com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao cadastrar funcionario" + e.getMessage());
		}
		
	}
	
	public void carregar(){
		
		try {
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			listarFuncionarios = funcionarioDAO.listar();
			
			
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao listar os funcionarios" + e.getMessage());
		}
	}
	
	public void carregarCadastro(){
		
		try {
			
			if(codigo != null){
				FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
				funcionarioCadastro = funcionarioDAO.buscarPorCodigo(codigo);
			} else {
				
				funcionarioCadastro = new Funcionario();
			}
			
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar carregar o funcionario" + e.getMessage());
		}
	}
	
	public void excluir(){
		
		try {
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.excluir(funcionarioCadastro);
			
			FacesUtil.addMsgInfo("Funcionario excluido com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao excluir o funcionario" + e.getMessage());
		}
	}
	
	public void editar(){
		
		try {
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			funcionarioDAO.editar(funcionarioCadastro);
			
			FacesUtil.addMsgInfo("Funcionario editado com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao editar o funcionario" + e.getMessage());
		}
	}

}
