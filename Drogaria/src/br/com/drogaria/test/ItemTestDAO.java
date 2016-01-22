package br.com.drogaria.test;
import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.dao.ItemDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.dao.VendaDAO;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.domain.Item;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.domain.Venda;

public class ItemTestDAO {
	
	@Test
	@Ignore
	public void salvar(){
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(2L);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(3L);
		
		Item item = new Item();
		item.setProduto(produto);
		item.setVenda(venda);
		item.setValorParcial(new BigDecimal(65.77));
		item.setQuantidade(45);
		
		ItemDAO itemDAO = new ItemDAO();
		itemDAO.salvar(item);
		
	}
	
	@Test
	@Ignore
	public void listar(){
		ItemDAO itemDAO = new ItemDAO();
		List<Item> itens = itemDAO.listar();
		
		for(Item item : itens){
			System.out.println(item);
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo(){
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(1L);
		
		System.out.println(item);
	}
	
	@Test
	@Ignore
	public void excluir(){
		
		ItemDAO itemDAO = new ItemDAO();
		Item item = itemDAO.buscarPorCodigo(1L);
		
		itemDAO.excluir(item);
	}
	
	@Test
	public void editar(){
		
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscarPorCodigo(2L);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscarPorCodigo(2L);
		
		ItemDAO itemDAO = new ItemDAO();
		Item item = new Item();
		item = itemDAO.buscarPorCodigo(3L);
		
		
		item.setProduto(produto);
		item.setQuantidade(22);
		item.setValorParcial(new BigDecimal(33.12));
		item.setVenda(venda);
		
		
		itemDAO.editar(item);
	}

}
