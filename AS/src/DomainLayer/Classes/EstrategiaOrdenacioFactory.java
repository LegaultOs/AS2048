package DomainLayer.Classes;

public class EstrategiaOrdenacioFactory {
	
	private static EstrategiaOrdenacioFactory instance;
	private EstrategiaOrdenacioPunts eop;
	private EstrategiaOrdenacioMitjaPunts eomp;
	
	
	private EstrategiaOrdenacioFactory()
	{
		eop = null;
		eomp = null;
	}
	
	public static EstrategiaOrdenacioFactory getInstance()
	{
		if(instance==null)
		{
			instance= new EstrategiaOrdenacioFactory();
		}
		return instance;
	}
	
	public EstrategiaOrdenacio creaEstrategiaOrdenacioPunts()
	{
		if (eop == null) eop = new EstrategiaOrdenacioPunts();
		return eop;
		
	}

}
