package Domain;

public class ServiceLocator {
	
	private static ServiceLocator instance;
	
	
	private ServiceLocator(){}
	
	
	public static ServiceLocator getInstance()
	{
		if(instance==null)
		{
			
			instance = new ServiceLocator();
		}
		
		return instance;
	}
	
	public Object find (String nom)
	{
		//entiendo que tenemos que devolver un objeto y luego castearlo a lo que estuvieramos buscando no?
		
		//TODO
		
		return null;
	}
}
