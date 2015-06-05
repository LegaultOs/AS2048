package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class TestPartida {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Partida.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		
		session.beginTransaction(); 
		
		
		Partida p1 = new Partida(); 
		p1.setIdPartida(50); 
		p1.setEstaAcabada(false);
		p1.setEstaGuanyada(false);
		p1.setPuntuacio(0);
		
		Partida p2 = new Partida(); 
		p1.setIdPartida(52); 
		p1.setEstaAcabada(false);
		p1.setEstaGuanyada(false);
		p1.setPuntuacio(0);
		
		session.save(p1); 

		
		session.getTransaction().commit(); 

	}

}

