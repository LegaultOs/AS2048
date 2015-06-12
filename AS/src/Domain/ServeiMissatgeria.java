package Domain;

import java.rmi.RemoteException;


import org.apache.axis2.AxisFault;

import src.MissatgeriaStub;
import src.MissatgeriaStub.EnviaMissatge;
import src.MissatgeriaStub.EnviaMissatgeResponse;




public class ServeiMissatgeria {
	
	public static void main(String[] args) {
		
		
		enviarMissatge("HOLAAA OSCAAAR","oscaracso90@gmail.com");
		
		//main para pruebas
	}

	
	public static void enviarMissatge(String missatge,String email)//irá sin static , pero se queda así para pruebas
													//esto va, lo que pasa es que necesitamos un server de correo o buscar la manera de usar uno externo como el de gmail.
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
