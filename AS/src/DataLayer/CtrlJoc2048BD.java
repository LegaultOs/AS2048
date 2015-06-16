package DataLayer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import DomainLayer.Classes.Casella;
import DomainLayer.Classes.Joc2048;
import DomainLayer.Classes.UsuariRegistrat;
import DomainLayer.DataInterface.ICtrlJoc2048;

public class CtrlJoc2048BD implements ICtrlJoc2048 {

	@Override
	public Joc2048 get(int id) {
		
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Joc2048.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
		
		session.beginTransaction(); 
		
		return (Joc2048)session.get(Joc2048.class, id); 

	}
	
	public void insertaJoc(Joc2048 joc){
		
		AnnotationConfiguration config = new AnnotationConfiguration(); 
		config.addAnnotatedClass(Joc2048.class); 
		config.configure("hibernate.cfg.xml"); 
		
		new SchemaExport(config).create(true, true);
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
		session.beginTransaction(); 
		
		joc.setId(1);
		
		session.saveOrUpdate(joc);
		session.getTransaction().commit(); 
	}

}
