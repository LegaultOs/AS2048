package Model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import Domain.Casella;
import Domain.ICtrlJoc2048;
import Domain.Joc2048;
import Domain.UsuariRegistrat;

public class CtrlJoc2048BD implements ICtrlJoc2048 {

	@Override
	public Joc2048 get(int id) {
		
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Joc2048.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		
		session.beginTransaction(); 
		
		Joc2048 joc = new Joc2048(); 
		joc = (Joc2048)session.get(Joc2048.class, id); 

		return joc;
	}
	
	public void insertaJoc(Joc2048 joc){
		
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Joc2048.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		SessionFactory factory = config.buildSessionFactory(); 
		Session session = factory.getCurrentSession(); 
		
		session.beginTransaction(); 
		
		session.saveOrUpdate(joc);
		session.getTransaction().commit(); 
		session.close(); 		
	}

}
