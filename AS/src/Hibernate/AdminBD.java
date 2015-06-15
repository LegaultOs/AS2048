package Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import Domain.Jugador;
import Domain.Partida;
import Domain.UsuariRegistrat;

public class AdminBD {
	
	public AdminBD(){}
	
	public Jugador insertaUsuaris(String n) {
		// TODO Auto-generated method stub
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(UsuariRegistrat.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		session.beginTransaction(); 
		
		/*UsuariRegistrat ur = new UsuariRegistrat(); 
		
		ur.setNom("Olga");
		ur.setCognom("Carbo");
		ur.setPass("hola");
		ur.setUsername("OlgaC");*/
		Jugador ur = new Jugador("gmail", "Olga", "Carbo", "OlgaC", "hola");
		session.save(ur); 
		
		session.getTransaction().commit();
		
		session = factory.getCurrentSession(); 
		session.beginTransaction();
		Jugador u =  (Jugador) session.createQuery("from Jugador where username = '"+n+"'").uniqueResult();
		session.getTransaction().commit();
		return u;
	}
	
	public void insertaPartida(){
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Partida.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		session.beginTransaction(); 
		
		Partida p = new Partida(1); 
		
		p.setEstaAcabada(false);
		p.setEstaGuanyada(false);
		p.setIdPartida(1);
		p.setPuntuacio(100);
		
		session.saveOrUpdate(p);
		
		session.getTransaction().commit();

	}

}
