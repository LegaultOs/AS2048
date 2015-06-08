package Domain;

public class CtrlLogin {
	
	
	
	
	
	
	public Jugador autentica(String userN, String passwd ) throws Exception
	{
		
		
		CtrlDataFactory cdf=CtrlDataFactory.getInstance();
		ICtrlJugador icj = cdf.getCtrlJugador();
		Jugador aux = icj.getJugadorPerNom(userN);
		
		if(aux == null) throw new Exception("jugadorNoExisteix");
		
		if(!aux.getPass().equals(passwd))throw new Exception("passIncorrecte");
		
		return aux;
	}

}
