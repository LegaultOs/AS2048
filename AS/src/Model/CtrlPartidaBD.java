package Model;

import java.util.ArrayList;

import DomainLayer.Classes.Partida;
import DomainLayer.DataInterface.ICtrlPartida;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class CtrlPartidaBD implements ICtrlPartida {


	@Override
	public Partida getPartida(int idPartida) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
		session.beginTransaction(); 
		
		Partida partida = new Partida(idPartida);
		partida = (Partida)session.get(Partida.class, idPartida); 
		
		return partida;
	}

	public void insertaPartida(Partida partida){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
		session.beginTransaction(); 
		
		session.saveOrUpdate(partida);
		session.getTransaction().commit(); 
	}
	
	@Override
	public boolean existeix(int idPartida) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
		session.beginTransaction(); 
		
		Partida partida = new Partida(idPartida); 
		partida = (Partida)session.get(Partida.class, idPartida); 
		if(partida != null ) return true; 
		else return false;
	}

	@Override
	public ArrayList<Partida> tots() {
		// TODO Auto-generated method stub
		return null;
	}

}
