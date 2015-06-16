package Model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import DomainLayer.Classes.Jugador;
import DomainLayer.DataInterface.ICtrlJugador;

public class CtrlJugadorBD implements ICtrlJugador {

	public void insertaJugador(Jugador jugador){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
		session.beginTransaction(); 
		
		session.saveOrUpdate(jugador);
		session.getTransaction().commit(); 
	}
	
	@Override
	public Jugador getJugadorPerNom(String userN) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
		session.beginTransaction(); 
		
		Jugador jugador = new Jugador(); 
		
		jugador = (Jugador)session.get(Jugador.class, userN); 
		
		return jugador;
	}

	@Override
	public boolean existeix(String userN) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Jugador> tots() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
		session.beginTransaction(); 
		List <Jugador> jugadors = session.createQuery("from Jugador").list();
		session.getTransaction().commit();
		return (ArrayList<Jugador>) jugadors;
	}

	@Override
	public Jugador getJugadorPerEmail(String email) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
		session.beginTransaction(); 
		
		Jugador jugador = new Jugador(); 
		
		jugador = (Jugador)session.get(Jugador.class, email); 
		
		return jugador;
	}

	@Override
	public boolean existeixEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
