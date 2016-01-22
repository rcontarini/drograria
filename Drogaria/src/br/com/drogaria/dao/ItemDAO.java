package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.Item;
import br.com.drogaria.util.HibernateUtil;

public class ItemDAO {

	public void salvar(Item item) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {

			transacao = session.beginTransaction();
			session.save(item);
			transacao.commit();

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	public List<Item> listar() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Item> item = null;

		try {

			Query consulta = session.getNamedQuery("Item.listar");
			item = consulta.list();

		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}
		return item;

	}

	public Item buscarPorCodigo(Long codigo) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Item item = null;

		try {

			Query consulta = session.getNamedQuery("Item.buscarPorCodigo");
			consulta.setLong("codigo", codigo);

			item = (Item) consulta.uniqueResult();

		} catch (RuntimeException e) {
			throw e;
		} finally {
			session.close();
		}

		return item;
	}

	public void excluir(Item item) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {

			transacao = session.beginTransaction();
			session.delete(item);
			transacao.commit();

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}

			throw e;
		} finally {
			session.close();
		}
	}

	public void editar(Item item) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {

			transacao = session.beginTransaction();
			session.update(item);
			transacao.commit();

		} catch (Exception e) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw e;

		} finally {
			session.close();
		}
	}

}
