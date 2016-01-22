package br.com.drogaria.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

public class FabricanteTestDAO {

	@Test
	@Ignore
	// Metodo para testar a insercao
	public void salvar() {

		Fabricante f1 = new Fabricante();
		f1.setDescricao("DESCRICAOF1");

		Fabricante f2 = new Fabricante();
		f2.setDescricao("DESCRICAOF2");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(f1);
		fabricanteDAO.salvar(f2);
	}

	@Test
	@Ignore
	// Metodo para testar a listagem
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar();

		for (Fabricante fabricante : fabricantes) {
			System.out.println(fabricante);
		}

	}

	@Test
	@Ignore
	public void testaPorCodigo() {
		FabricanteDAO dao = new FabricanteDAO();

		Fabricante f1 = dao.buscarPorCodigo(2L);
		Fabricante f2 = dao.buscarPorCodigo(6L);

		System.out.println(f1);
		System.out.println(f2);
	}

	@Test
	@Ignore
	public void testaExclusaoPorCodigo() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();

		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(1L);
		fabricanteDAO.excluir(fabricante);

	}

	@Test
	public void editar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();

		Fabricante fabricante = fabricanteDAO.buscarPorCodigo(2L);
		fabricante.setDescricao("Troca Descricao");
		fabricanteDAO.editar(fabricante);
	}

}
