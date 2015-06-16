package DomainLayer.ServiceLocator;

import java.rmi.RemoteException;


import org.apache.axis2.AxisFault;

import src.MissatgeriaStub;
import src.MissatgeriaStub.EnviaMissatge;
import src.MissatgeriaStub.EnviaMissatgeResponse;




public class ServeiMissatgeria {
	
	/*public static void main(String[] args) {
		String missatge= "Test";
		String email= "maildeprueba";
		
		enviarMissatge(missatge,email);
		
		//main para pruebas
	}*/

	
	public static void enviarMissatge(String missatge,String email)
	{
		try {
			MissatgeriaStub stub = new MissatgeriaStub();
			EnviaMissatge em = new EnviaMissatge();
			em.setMissatge(missatge);
			em.setEmail(email);
			EnviaMissatgeResponse res = stub.enviaMissatge(em);
			System.out.println(res.get_return());

		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
