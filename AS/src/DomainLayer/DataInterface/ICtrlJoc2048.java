package DomainLayer.DataInterface;

import DomainLayer.Classes.Joc2048;

public interface ICtrlJoc2048 {

	public Joc2048 get(int id);
	
	public void insertaJoc (Joc2048 joc);
}
