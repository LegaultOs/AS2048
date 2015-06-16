package Model;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import DomainLayer.Classes.UsuariRegistrat;
import DomainLayer.DataInterface.ICtrlUsuariRegistrat;

public class CtrlUsuariRegistratBD implements ICtrlUsuariRegistrat {

	@Override
	public UsuariRegistrat getUsuari(String userN) throws Exception {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
		session.beginTransaction(); 
		
		UsuariRegistrat usuari = new UsuariRegistrat(); 
		usuari = (UsuariRegistrat) session.createQuery("from UsuariRegistrat where username = '"+userN+"'").uniqueResult();
		if(usuari == null) throw new Exception("usernameNoExisteix");
		
		session.getTransaction().commit(); 
		
		return usuari;
	}

	@Override
	public void insertaUsuari(UsuariRegistrat usuari){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession(); 
		session.beginTransaction(); 
		
		session.saveOrUpdate(usuari);
		session.getTransaction().commit(); 
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
