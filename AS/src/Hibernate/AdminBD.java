package Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import DomainLayer.Classes.Jugador;
import DomainLayer.Classes.Partida;
import DomainLayer.Classes.UsuariRegistrat;
import DomainLayer.DataInterface.CtrlDataFactory;

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
		if(ur == null) System.out.println("usernameNoExisteix");
		if (!ur.getPass().equals("hola"))  System.out.println("pwdIncorrecte");
		if (!ur.etsJugador()) System.out.println("usuariNoJugador");
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
	
	public void insertaJugador() {
		UsuariRegistrat ur = new UsuariRegistrat("wangyang", "Ye", "ywy", "1234");
		CtrlDataFactory.getInstance().getCtrlUsuariRegistrat().insertaUsuari(ur);
		Jugador j = new Jugador("Olga", "Carbo", "olgaC", "hola", "gmail");
		Jugador j2 = new Jugador("max", "max", "max", "max", "max");
		Jugador j3 = new Jugador("min", "min", "min", "min", "min");
		j.setMillorPuntuacio(100);
		j2.setMillorPuntuacio(2000);
		j3.setMillorPuntuacio(0);
		CtrlDataFactory.getInstance().getCtrlJugador().insertaJugador(j);
		CtrlDataFactory.getInstance().getCtrlJugador().insertaJugador(j2);
		CtrlDataFactory.getInstance().getCtrlJugador().insertaJugador(j3);
	}

}
