package Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import Domain.UsuariRegistrat;

public class AdminBD {
	
	public static void AdminBD(){}
	
	public static void insertaUsuaris() {
		// TODO Auto-generated method stub
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(UsuariRegistrat.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		session.beginTransaction(); 
		
		UsuariRegistrat ur = new UsuariRegistrat(); 
		
		ur.setNom("Oscar");
		ur.setCognom("Carod");
		ur.setPass("hola");
		ur.setUsername("OscarC");
		
		session.save(ur); 
		
		session.getTransaction().commit(); 
	}

}
