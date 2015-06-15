package Domain;

import java.util.ArrayList;

public interface ICtrlUsuariRegistrat {

	public UsuariRegistrat getUsuari(String userN) throws Exception;
	public boolean existeix(String userN);
	public ArrayList<UsuariRegistrat> tots();

}
