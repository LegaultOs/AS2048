package DomainLayer.DataInterface;

import java.util.ArrayList;

import DomainLayer.Classes.UsuariRegistrat;

public interface ICtrlUsuariRegistrat {

	public UsuariRegistrat getUsuari(String userN) throws Exception;
	
	public void insertaUsuari(UsuariRegistrat usuari);
	
	public boolean existeix(String userN);
	
	public ArrayList<UsuariRegistrat> tots();

}
