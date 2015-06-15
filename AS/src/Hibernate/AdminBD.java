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
	
	public UsuariRegistrat insertaUsuaris() {
		// TODO Auto-generated method stub
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(UsuariRegistrat.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		session.beginTransaction(); 
		
		UsuariRegistrat ur = new UsuariRegistrat(); 
		ur = new UsuariRegistrat();
		ur.setNom("wangyang");
		ur.setCognom("ye");
		ur.setPass("1994");
		ur.setUsername("ywy");
		session.save(ur); 
	
		Jugador j = new Jugador("Olga", "Carbo", "OlgaC", "hola", "gmail");
		session.save(j);
	
		/*j = new Jugador();
		j = (Jugador) session.createQuery("from Jugador where username = '"+"OlgaC"+"'").uniqueResult();*/
		ur = new UsuariRegistrat();
		ur = (UsuariRegistrat) session.createQuery("from UsuariRegistrat where username = '"+"OlgaC"+"'").uniqueResult();
		
		session.getTransaction().commit(); 
		return ur;
		
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
