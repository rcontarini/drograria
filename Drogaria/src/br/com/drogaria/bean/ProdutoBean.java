package br.com.drogaria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.FacesUtil;

@ManagedBean
@ViewScoped
public class ProdutoBean {
	private Produto produtoCadastro;

	private List<Produto> listarProdutos;
	private List<Produto> listarProdutosFiltrados;
	private List<Fabricante> listaFabricantes;

	private String acao;
	private Long codigo;

	public void setListarProdutos(List<Produto> listarProdutos) {
		this.listarProdutos = listarProdutos;
	}

	public List<Produto> getListarProdutos() {
		return listarProdutos;
	}

	public void setListarProdutosFiltrados(List<Produto> listarProdutosFiltrados) {
		this.listarProdutosFiltrados = listarProdutosFiltrados;
	}

	public List<Produto> getListarProdutosFiltrados() {
		return listarProdutosFiltrados;
	}

	public void setProdutoCadastro(Produto produtoCadastro) {
		this.produtoCadastro = produtoCadastro;
	}

	public Produto getProdutoCadastro() {
		if(produtoCadastro == null){
			produtoCadastro = new Produto();
		}
		return produtoCadastro;
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
	
	public List<Fabricante> getListaFabricantes() {
		return listaFabricantes;
	}
	
	public void setListaFabricantes(List<Fabricante> listaFabricantes) {
		this.listaFabricantes = listaFabricantes;
	}

	public void novo() {

		produtoCadastro = new Produto();
	}

	public void salvar() {

		try {

			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.inserir(produtoCadastro);

			produtoCadastro = new Produto();

			FacesUtil.addMsgInfo("Produto Cadastrado com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao salvar o produto" + e.getMessage());
		}
	}

	public void carregar() {

		try {

			ProdutoDAO produtoDAO = new ProdutoDAO();
			listarProdutos = produtoDAO.listar();

		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao listar todos produtos");
		}
	}

	public void carregarCadastro() {

		try {

			if (codigo != null) {
				ProdutoDAO produtoDAO = new ProdutoDAO();
				produtoCadastro = produtoDAO.buscarPorCodigo(codigo);
			} else {
				produtoCadastro = new Produto();
			}
			
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			listaFabricantes = fabricanteDAO.listar();

		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao filtrar os produtos");
		}
	}
	
	public void excluir(){
		
		try {
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produtoCadastro);
			
			FacesUtil.addMsgInfo("Produto excluido com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao excluir o produto");
		}
	}
	
	public void editar(){
		
		try {
			
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.editar(produtoCadastro);
			
			FacesUtil.addMsgInfo("Produto editado com sucesso");
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao editar o produto");
		}
	}

}
