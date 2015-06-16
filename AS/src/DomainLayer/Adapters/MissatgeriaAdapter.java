package DomainLayer.Adapters;

import DomainLayer.ServiceLocator.ServeiMissatgeria;
import DomainLayer.ServiceLocator.ServiceLocator;


public class MissatgeriaAdapter implements IMissatgeriaAdapter {

	@Override
	public void enviarMissatge(String miss,String email) {
		ServiceLocator sl = ServiceLocator.getInstance();
		
		ServeiMissatgeria sm=(ServeiMissatgeria)sl.find("ServeiMissatgeria");
		
		sm.enviarMissatge(miss,email);
		
	}

}
