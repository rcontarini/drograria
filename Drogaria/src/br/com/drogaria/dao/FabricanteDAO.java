package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.HibernateUtil;

public class FabricanteDAO {
	
	// metodo responsavel por salvar um fabricante
	public void salvar(Fabricante fabricante){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = session.beginTransaction();
			session.save(fabricante);
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
	
	@SuppressWarnings("unchecked")
	// metodo responsavel por listar um fabricante
	public List<Fabricante> listar(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Fabricante> fabricantes = null;
		
		try {
			Query consulta = session.getNamedQuery("Fabricante.listar");
			fabricantes = consulta.list();
			
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return fabricantes;
	}
	
	// Metodo responsavel por buscar um Fabricante por ID
	public Fabricante buscarPorCodigo(Long codigo){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Fabricante fabricante = null;
		
		try {
			Query consulta = session.getNamedQuery("Fabricante.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			
			fabricante = (Fabricante) consulta.uniqueResult();
			
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return fabricante;
	}
	
	// metodo responsavel por excluir um fabricante
		public void excluir(Fabricante fabricante){
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = null;
			
			try {
				transacao = session.beginTransaction();
				session.delete(fabricante);
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
		
		
		// metodo responsavel por editar um fabricante
		public void editar(Fabricante fabricante){
			
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transacao = null;
			
			try {
				transacao = session.beginTransaction();
				session.update(fabricante);
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
