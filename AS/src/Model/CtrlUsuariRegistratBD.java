package Model;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import Domain.Casella;
import Domain.ICtrlUsuariRegistrat;
import Domain.UsuariRegistrat;

public class CtrlUsuariRegistratBD implements ICtrlUsuariRegistrat {

	@Override
	public UsuariRegistrat getUsuari(String userN) {
			
			AnnotationConfiguration config = new AnnotationConfiguration(); 
			config.addAnnotatedClass(Casella.class); 
			config.configure("hibernate.cfg.xml"); 
			
			new SchemaExport(config).create(true, true);
			
			SessionFactory factory = config.buildSessionFactory(); 
			Session session = factory.getCurrentSession(); 
			
			session.beginTransaction(); 
			
			UsuariRegistrat usuari = new UsuariRegistrat(); 
			usuari = (UsuariRegistrat)session.get(UsuariRegistrat.class, userN); 
			
			session.getTransaction().commit(); 
			
			return usuari;
		}

	public void insertaUsuari(UsuariRegistrat usuari){
		
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Casella.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		
		session.beginTransaction(); 
		
		session.saveOrUpdate(usuari);
		session.getTransaction().commit(); 
		session.close(); 		
	}
	
	@Override
	public boolean existeix(String userN) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<UsuariRegistrat> tots() {
		// TODO Auto-generated method stub
		return null;
	}

}
