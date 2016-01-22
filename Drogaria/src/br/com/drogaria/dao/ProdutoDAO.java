package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.HibernateIterator;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.util.HibernateUtil;

public class ProdutoDAO {
	
	public void inserir(Produto produto){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = session.beginTransaction();
			session.save(produto);
			transacao.commit();
			
		} catch (RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}
			throw e;

		} finally {
			session.close();
		}
	}
	
	public List<Produto> listar(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Produto> produtos = null;
		
		try {
			
			Query consulta = session.getNamedQuery("Produto.listar");
			produtos = consulta.list();
			
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return produtos;
	}
	
	public Produto buscarPorCodigo(Long codigo){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Produto produtos = null;
		
		try {
			
			Query consulta = session.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			
			produtos = (Produto) consulta.uniqueResult();
			
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		
		return produtos;
	}
	
	public void excluir(Produto produto){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			
			transacao = session.beginTransaction();
			session.delete(produto);
			transacao.commit();
			
		} catch (RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}
			
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void editar(Produto produto){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			
			transacao = session.beginTransaction();
			session.update(produto);
			transacao.commit();
			
		} catch (RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

}
