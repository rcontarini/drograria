package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Item;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.FacesUtil;

@ManagedBean(name = "vendaBean")
@ViewScoped
public class VendaBean implements Serializable {
	private List<Produto> listaProdutos;
	private List<Produto> listaProdutosFiltrados;
	
	private List<Item> listaItens;
	
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	
	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	
	public List<Produto> getListaProdutosFiltrados() {
		return listaProdutosFiltrados;
	}
	
	public void setListaProdutosFiltrados(List<Produto> listaProdutosFiltrados) {
		this.listaProdutosFiltrados = listaProdutosFiltrados;
	}
	
	public List<Item> getListaItens() {
		if(listaItens == null){
			listaItens = new ArrayList<>();
		}
		return listaItens;
	}
	
	public void setListaItens(List<Item> listaItens) {
		this.listaItens = listaItens;
	}
	
	public void carregar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			listaProdutos = produtoDAO.listar();
			
		} catch (RuntimeException e) {
			FacesUtil.addMsgError("Erro ao listar todos produtos");
		}
	}
	
	public void adicionar(Produto produto){
		System.out.println(produto);
	
		
		Item item = new Item();
		item.setProduto(produto);
		item.setQuantidade(1);
		item.setValorParcial(produto.getPreco());
		
		
		
		listaItens.add(item);
	}

}
