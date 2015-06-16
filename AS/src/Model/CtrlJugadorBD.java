package Model;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import Domain.ICtrlJugador;
import Domain.Jugador;

public class CtrlJugadorBD implements ICtrlJugador {

	public void insertaJugador(Jugador jugador){
		ConexionBD.getInstance();
		Session session = ConexionBD.getFactory().getCurrentSession(); 
		session.beginTransaction(); 
		
		session.saveOrUpdate(jugador);
		session.getTransaction().commit(); 
	}
	
	@Override
	public Jugador getJugadorPerNom(String userN) {
		ConexionBD.getInstance();
		Session session = ConexionBD.getFactory().getCurrentSession(); 
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
		ConexionBD.getInstance();
		Session session = ConexionBD.getFactory().getCurrentSession(); 
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
