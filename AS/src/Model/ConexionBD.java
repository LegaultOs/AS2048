package Model;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import DomainLayer.Classes.Casella;
import DomainLayer.Classes.Jugador;
import DomainLayer.Classes.Partida;
import DomainLayer.Classes.UsuariRegistrat;

public class ConexionBD {
	
	private static ConexionBD instance;
	private static AnnotationConfiguration config;
	private static SessionFactory factory;
	
	private ConexionBD() {
		config = new AnnotationConfiguration();
		
		config.addAnnotatedClass(UsuariRegistrat.class);
		config.addAnnotatedClass(Jugador.class);
		config.addAnnotatedClass(Casella.class);
		config.addAnnotatedClass(Partida.class);		
		
		config.configure("hibernate.cfg.xml");
		factory = config.buildSessionFactory();
		new SchemaExport(config).create(true, true);
    }

	public static ConexionBD getInstance() {
        if (instance == null) {
            synchronized (ConexionBD.class) {
                if (instance == null) {
                    instance = new ConexionBD();
                }
            }
        }
        return instance;
    }
	
	public static SessionFactory getFactory() {
		return factory;
	}

}
