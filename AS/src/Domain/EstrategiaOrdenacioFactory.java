package Domain;

public class EstrategiaOrdenacioFactory {
	
	private static EstrategiaOrdenacioFactory factory;
	
	
	private EstrategiaOrdenacioFactory()
	{}
	
	public static EstrategiaOrdenacioFactory getInstance()
	{
		if(factory==null)
		{
			factory= new EstrategiaOrdenacioFactory();
			
		}
		
		return factory;
		
		
	}
	
	public EstrategiaOrdenacio creaEstrategiaOrdenacioPunts()
	{
		
		return new EstrategiaOrdenacioPunts();
		
	}

}
