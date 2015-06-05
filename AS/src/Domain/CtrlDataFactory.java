package Domain;

import Model.CtrlCasellaBD;
import Model.CtrlJoc2048BD;
import Model.CtrlJugadorBD;
import Model.CtrlPartidaBD;
import Model.CtrlUsuariRegistratBD;

public class CtrlDataFactory {
	
	private static CtrlDataFactory instance;
	private ICtrlUsuariRegistrat ctrlur;
	private ICtrlJugador ctrlj;
	private ICtrlJoc2048 ctrlj2048;
	private ICtrlCasella ctrlc;
	private ICtrlPartida ctrlp;
	
	
	private CtrlDataFactory(){}
	
	
	public static CtrlDataFactory getInstance()
	{
		if(instance==null)
		{
			
			instance = new CtrlDataFactory();
		}
		
		return instance;
	}
	
	public ICtrlUsuariRegistrat getCtrlUsuariRegistrat()
	{
		if(ctrlur==null)
		{
			
			ctrlur = new CtrlUsuariRegistratBD();
		}
		
		return ctrlur;
	}
	
	public ICtrlJugador getCtrlJugador()
	{
		if(ctrlj==null)
		{
			
			ctrlj = new CtrlJugadorBD();
		}
		
		return ctrlj;
	}
	
	public ICtrlJoc2048 getCtrlJoc2048()
	{
		if(ctrlj2048==null)
		{
			
			ctrlj2048 = new CtrlJoc2048BD();
		}
		
		return ctrlj2048;
	}
	
	public ICtrlCasella getCtrlCasella()
	{
		if(ctrlc==null)
		{
			
			ctrlc = new CtrlCasellaBD();
		}
		
		return ctrlc;
	}
	
	public ICtrlPartida getCtrlPartida()
	{
		if(ctrlp==null)
		{
			
			ctrlp = new CtrlPartidaBD();
		}
		
		return ctrlp;
	}
	
	
	
	
	
	

}
