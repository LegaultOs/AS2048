//package Domain;
//
//import Model.CtrlUsuariRegistratBD;
//
//public class Factoria {
//
//	
//	private static Factoria instance;
//	private IMissatgeriaAdapter ma;
//	
//	private Factoria(){}
//	
//	
//	public static Factoria getInstance()
//	{
//		if(instance==null)
//		{
//			
//			instance = new Factoria();
//		}
//		
//		return instance;
//	}
//	
//	public IMissatgeriaAdapter getMissatgeria()
//	{
//		if(ma==null)
//		{
//			
//			ma = new MissatgeriaAdapter();
//		}
//		
//		return ma;
//	}
//	
//	
//}
