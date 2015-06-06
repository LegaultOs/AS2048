package Model;

import java.util.ArrayList;

import Domain.ICtrlPartida;
import Domain.Partida;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class CtrlPartidaBD implements ICtrlPartida {


	@Override
	public Partida getPartida(int idPartida) {
		// TODO Auto-generated method stub
		
		Partida partida = new Partida(idPartida); 
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Partida.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		
		session.beginTransaction(); 
		
		partida = (Partida)session.get(Partida.class, idPartida); 
		
		return partida;
	}

	public void insertaPartida(Partida partida){
		
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Partida.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		
		session.beginTransaction(); 
		
		session.saveOrUpdate(partida);
		session.getTransaction().commit(); 
		session.close(); 		
	}
	
	@Override
	public boolean existeix(int idPartida) {
		// TODO Auto-generated method stub
		Partida partida = new Partida(idPartida); 
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Partida.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		
		session.beginTransaction(); 
		
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
