package Domain;

public class CtrlLogin {
	
	
	
	public Jugador autentica(String userN, String passwd ) throws Exception
	{	
		
		CtrlDataFactory cdf=CtrlDataFactory.getInstance();
		ICtrlUsuariRegistrat icur = cdf.getCtrlUsuariRegistrat();
		UsuariRegistrat aux1 = icur.getUsuari(userN);
		
		
		if(aux1 == null) throw new Exception("usuariNoExisteix");
		ICtrlJugador icj = cdf.getCtrlJugador();
		Jugador aux = icj.getJugadorPerNom(userN);
		if(aux == null) throw new Exception("usuariNoJugador");
		if(!aux.getPass().equals(passwd))throw new Exception("pwdIncorrecte");
		
		return aux;
	}

}
