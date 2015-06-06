package Model;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import Domain.ICtrlJugador;
import Domain.Jugador;
import Domain.Partida;

public class CtrlJugadorBD implements ICtrlJugador {

	public void insertaJugador(Jugador jugador){
		
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Jugador.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		
		session.beginTransaction(); 
		
		session.saveOrUpdate(jugador);
		session.getTransaction().commit(); 
		session.close(); 	
	}
	
	@Override
	public Jugador getJugadorPerNom(String userN) {
		// TODO Auto-generated method stub
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Jugador.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jugador getJugadorPerEmail(String email) {
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Jugador.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		
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
