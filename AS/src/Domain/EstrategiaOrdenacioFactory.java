package Domain;

public class EstrategiaOrdenacioFactory {
	
	private EstrategiaOrdenacioFactory factory;
	
	
	private EstrategiaOrdenacioFactory()
	{}
	
	public EstrategiaOrdenacioFactory getInstance()
	{
		if(factory==null)
		{
			return new EstrategiaOrdenacioFactory();
			
		}
		
		else return factory;
		
		
	}
	
	public EstrategiaOrdenacio creaEstrategiaOrdenacioPunts()
	{
		
		return new EstrategiaOrdenacioPunts();
		
	}

}
