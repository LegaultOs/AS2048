package Domain;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {

	private static ServiceLocator instance;
	private Map services = new HashMap();
	
	

	private ServiceLocator(){
		
		loadService("ServeiMissatgeria", new ServeiMissatgeria());
		
	}

	public static ServiceLocator getInstance(){
		if (instance == null) {

			instance = new ServiceLocator();
		}

		return instance;
	}
	
	
	public static Object find(String key){
	      return instance.services.get(key);
	  }
	private void loadService (String key, Object service) {
		instance.services.put(key, service);
	  }

	
}
