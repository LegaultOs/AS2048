package DomainLayer.Controllers;

import DomainLayer.Classes.UsuariRegistrat;
import DomainLayer.DataInterface.CtrlDataFactory;
import DomainLayer.DataInterface.ICtrlUsuariRegistrat;

public class CtrlLogin {
	
	
	
	public void Login(String userN, String passwd ) throws Exception
	{	
		
		CtrlDataFactory cdf=CtrlDataFactory.getInstance();
		ICtrlUsuariRegistrat icur = cdf.getCtrlUsuariRegistrat();
		UsuariRegistrat ur = icur.getUsuari(userN);
		if(!ur.getPass().equals(passwd))throw new Exception("pwdIncorrecte");
		
	}

}
