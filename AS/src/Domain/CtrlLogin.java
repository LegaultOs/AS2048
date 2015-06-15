package Domain;

public class CtrlLogin {
	
	
	
	public void Login(String userN, String passwd ) throws Exception
	{	
		
		CtrlDataFactory cdf=CtrlDataFactory.getInstance();
		ICtrlUsuariRegistrat icur = cdf.getCtrlUsuariRegistrat();
		UsuariRegistrat aux = icur.getUsuari(userN);
		
		
		if(aux == null) throw new Exception("usuariNoExisteix");
		
		if(!aux.getPass().equals(passwd))throw new Exception("pwdIncorrecte");
		
	}

}
