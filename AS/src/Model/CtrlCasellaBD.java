package Model;

import java.util.ArrayList;

import Domain.Casella;
import Domain.ICtrlCasella;
import Domain.Partida;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CtrlCasellaBD implements ICtrlCasella {

	@Override
	public Casella getCasella(int id, int fila, int col) {
		ConexionBD.getInstance();
		Session session = ConexionBD.getFactory().getCurrentSession(); 
		session.beginTransaction(); 
		
		Casella casella = new Casella(fila,col); 
		
		casella = (Casella)session.get(Casella.class, id); 
		
		session.getTransaction().commit(); 
		
		return casella;
	}

	public void insertaCasella(Casella casella){
		ConexionBD.getInstance();
		Session session = ConexionBD.getFactory().getCurrentSession(); 
		session.beginTransaction(); 
		
		
		session.saveOrUpdate(casella);
		session.getTransaction().commit(); 
	}
	
	@Override
	public boolean existeix(int id, int fila, int col) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Casella> tots() {
		// TODO Auto-generated method stub
		return null;
	}

}
