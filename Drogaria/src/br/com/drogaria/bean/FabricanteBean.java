package br.com.drogaria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricanteCadastro;
	private List<Fabricante> listarFabricantes;
	private List<Fabricante> listarFabricantesFiltrados;
	
	private String acao;
	private Long codigo;

	public Fabricante getFabricanteCadastro() {
		if (fabricanteCadastro == null) {
			fabricanteCadastro = new Fabricante();
		}
		return fabricanteCadastro;
	}

	public void setFabricanteCadastro(Fabricante fabricanteCadastro) {
		this.fabricanteCadastro = fabricanteCadastro;
	}

	public void setListarFabricantes(List<Fabricante> listarFabricantes) {
		this.listarFabricantes = listarFabricantes;
	}

	public List<Fabricante> getListarFabricantes() {
		return listarFabricantes;
	}

	public void setListarFabricantesFiltrados(List<Fabricante> listarFabricantesFiltrados) {
		this.listarFabricantesFiltrados = listarFabricantesFiltrados;
	}

	public List<Fabricante> getListarFabricantesFiltrados() {
		return listarFabricantesFiltrados;
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

	// Metodo Responsavel por limpar o cadastro
	public void novo() {

		fabricanteCadastro = new Fabricante();
	}

	// Metodo responsavel por pegar os dados do cliente e salvar no banco de
	// dados
	public void salvar() {

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricanteCadastro);

		fabricanteCadastro = new Fabricante();

		try {
			FacesUtil.addMsgInfo("Fabricante Salvo Com Sucesso!");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao cadastrar um fabricante" + e.getMessage());
		}

	}

	// Metodo responsavel por listar os fabricantes
	public void carregar() {
		try {

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			listarFabricantes = fabricanteDAO.listar();

		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao carregar a lista" + e.getMessage());
		}
	}

	public void carregarCadastro() {
		try {
			
			if (codigo != null) {
				FabricanteDAO fabricanteDAO = new FabricanteDAO();
				fabricanteCadastro = fabricanteDAO.buscarPorCodigo(codigo);
			} else {
				
				fabricanteCadastro = new Fabricante();
			}

		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao tentar carregar o fabricante" + e.getMessage());
		}
	}

	public void excluir() {

		try {

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.excluir(fabricanteCadastro);

			FacesUtil.addMsgInfo("Fabricante excluido com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao excluir o fabricante" + e.getMessage());
		}

	}

	public void editar() {

		try {

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.editar(fabricanteCadastro);

			FacesUtil.addMsgInfo("Fabricanto editado com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao editar o fabricante selecionado" + e.getMessage());
		}

	}
}
