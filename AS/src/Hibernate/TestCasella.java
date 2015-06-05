package Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import Hibernate.Partida;

public class TestCasella {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Casella.class); 
		config.addAnnotatedClass(Partida.class);
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		session.beginTransaction(); 
		
		//Partida par1 = new Partida(); 
		//par1.setIdPartida(50);
		
		CompoundKey key1 = new CompoundKey(0, 0); 
		CompoundKey key2 = new CompoundKey(0, 1); 
		
		Casella c1 = new Casella();
		Casella c2 = new Casella();
		
		c1.setCompoundkey(key1);
		c1.setNumero(2);
		c2.setCompoundkey(key2);
		c2.setNumero(4);

		//c1.setPartida(par1);
		//c2.setPartida(par1);
		
		session.save(c1); 
		session.save(c2);
		//session.save(par1);
		
		session.getTransaction().commit(); 
	}

}

