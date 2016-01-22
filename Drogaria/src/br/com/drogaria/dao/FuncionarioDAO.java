package br.com.drogaria.dao;

import java.util.List;

import javax.persistence.NamedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.util.HibernateUtil;

public class FuncionarioDAO {
	
	// Metodo Responsavel por salvar um funcionario
	public void salvar(Funcionario funcionario){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = session.beginTransaction();
			session.save(funcionario);
			transacao.commit();
			
		} catch (RuntimeException e) {
			
			if(transacao != null){
				transacao.rollback();
			}
		} finally {
			session.close();
		}
		
	}
	
	public List<Funcionario> listar(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Funcionario> funcionarios = null;
		
		try {
			Query consulta = session.getNamedQuery("Funcionario.listar");
			funcionarios = consulta.list();
			
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return funcionarios;
	}
	
	public Funcionario buscarPorCodigo(Long codigo){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Funcionario funcionario = null;
		
		try {
			
			Query consulta = session.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			
			funcionario = (Funcionario) consulta.uniqueResult();
			
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return funcionario;
	}
	
	public void excluir(Funcionario funcionario){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = session.beginTransaction();
			session.delete(funcionario);
			transacao.commit();
			
		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
	}
	
	public void editar(Funcionario funcionario){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;
		
		try {
			transacao = session.beginTransaction();
			session.update(funcionario);
			transacao.commit();
			
		} catch (Exception e) {
			throw e;
		} finally {
			session.close();
		}
	}

}
