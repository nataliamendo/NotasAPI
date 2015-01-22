package edu.upc.eetac.ea.notas;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.upc.eetac.ea.notas.hibernate.HibernateUtil;

public class OperacionesBD implements IOperationBD {

	private static OperacionesBD instance = null;

	public static OperacionesBD getInstance() {
		if (instance == null)
			instance = new OperacionesBD();

		return instance;

	}
	
	@Override
	public List<Usuario> getListUsers()
	{
		List<Usuario> listusu= null; //new ArrayList<Usuario>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			listusu = session.createQuery("FROM Usuario").list();
            			
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		int i = 0;
		while(i<listusu.size())
		{
			System.out.println("*" + listusu.get(i).getLogin() );
			i++;
		}
		return listusu;
	}
	
	//obtener lista de notas
	@Override
	public List<Nota> getListNotas(int userid)
	{
		List<Nota> listnotas= null; //new ArrayList<Usuario>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			listnotas = session.createQuery("FROM Nota where Usuario_userid = '" +userid+"'").list();
            			
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		int i = 0;
		while(i<listnotas.size())
		{
			System.out.println("*" + listnotas.get(i).getIdNota() );
			i++;
		}
		return listnotas;
	}

	// añadir usuario
	@Override
	public String addUser(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			session.save(usuario);
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		return null;
	}

	/*
	@Override
	public void addNote(Nota nota, Usuario usu) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			//Usuario usu = getUsuarioById(userid);

			//"definimos la navegabilidad en un sentido"
			
			nota.setUsuario(usu);
			session.save(nota);
			
			usu.getNotas().add(nota);
			session.saveOrUpdate(usu);
	
			
//			session.save(usu);
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		//return null;
	}
	*/
	
	// Actualizar usuario:
	@Override
	public void updateUser(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			int userid = usuario.getUserid();
			
			Usuario usu = (Usuario)session.get(Usuario.class, userid);
			

			usu.setLogin(usuario.getLogin());
			usu.setContra(usuario.getContra());
			
			session.update(usu);
			transaction.commit();
		
			//session.close();

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}

	}

	@Override
	public Usuario dameUsuarioById(int userid) {
		Usuario usu = getUsuarioById(userid);
		return usu;
	}

	@Override
	public Usuario dameUsuarioByName(String name) {
		Usuario usu = getUsuarioByName(name);
		return usu;
	}
	
	@Override 
	public void deleteUser(Usuario usuario) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			session.delete(usuario);
			transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}

	}

	@Override
	public String addNotas(Nota note, Usuario usu) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		//Session session2 = HibernateUtil.getSessionFactory().openSession();
		//Transaction transaction2 = null;
		try {
			transaction = session.beginTransaction();
			note.setUsuario(usu);
			session.save(note);
			transaction.commit();
			
			//transaction2 = session2.beginTransaction();
			//usu.getNotas().add(note);
			//usu.notas.add(note);
			//session.saveOrUpdate(usu);
			//Actualizamos usuario:
			//session.update(usu);
			
			//
			//session.save(note);
			//transaction.commit();
			
		} catch (HibernateException e) {
			transaction.rollback();
		//	transaction2.rollback();
			e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return null;
	}
	
	
	//Actualizar Nota
		@Override
		public void updateNota(Nota nota, int userid) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				
				int notaid = nota.getIdNota();
				Usuario usu = getUsuarioById(userid);
				
				System.out.println(" ************* USUARIO: " + usu.getLogin());
				
				Nota n = (Nota)session.get(Nota.class, notaid);
				
				n.setNota(nota.getNota());
				//n.setUsuario(usu);
				//n.setIdNota(notaid);
				//usu.getNotas().add(n);
				
				//session.update(usu);
				transaction.commit();
			
				//session.close();

			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			}
			finally
			{
				session.close();
			}

		}
		
		//eliminar nota
		@Override
		public void deleteNota(int notaid) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			transaction = session.beginTransaction();
			try {

				Nota nota = getNota(notaid);
				Usuario usu = getUsuarioById(nota.getUsuario().getUserid());

				//usu.notas.remove(nota);
				//usu.getNotas().remove(nota);
				session.delete(nota);
				//session.saveOrUpdate(usu);
				transaction.commit();

			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
		//Obetener nota a partir de su notaid
		@Override
		public Nota getNota(int notaid) {

			Nota nota = null;
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;

			try {
				transaction = session.beginTransaction();
				Query query = session.createQuery("from Nota where NOTAS_ID = ' "
						+ notaid + "'");
				System.out.println(query);
				nota = (Nota) query.uniqueResult();
				
				if (nota != null) {
					transaction.commit();
				}
				
				//System.out.println("EEEEEEEEOOOOOOOOOO");
				System.out.println(nota.getNota());

			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
			return nota;
		}

	
	
// * * * Métodos adicionales * * *

	public Usuario getUsuarioById(int idUser) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		Usuario usu = new Usuario();

		try {
			transaction = session.beginTransaction();
			
			Query query = session.createQuery("from Usuario where Userid = ' "+ idUser + "'");
			usu = (Usuario) query.uniqueResult();
			if (usu != null) {
				transaction.commit();
			}

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally 
		{
			session.close();
		}
		return usu;
	}
	

	
	//Obtener lista de notas de usuario
	

	// * * * NO FUNCIONA, da problemas * * * 
	public Usuario getUsuarioByName(String username) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		Usuario usu = new Usuario();
		System.out.println(" * * * * * ** * **** Nombre del Usuario: "+ username);
		
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Usuario where name = ' "
					+ username + "'");
			usu = (Usuario) query.uniqueResult();
			if (usu != null) {
				transaction.commit();
			}
			else
			{
				System.out.println(usu);
			}

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			 session.close();
		}
		return usu;
	}

}