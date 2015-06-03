package Domain;

public class EstrategiaOrdenacioFactory {
	
	private EstrategiaOrdenacioFactory factory;
	
	
	private EstrategiaOrdenacioFactory()
	{}
	
	public EstrategiaOrdenacioFactory getInstance()
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
