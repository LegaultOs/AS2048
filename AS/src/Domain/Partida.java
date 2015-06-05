package Domain;

import java.util.ArrayList;
import java.lang.Math;

public class Partida {
	private int idPartida;
	private boolean estaAcabada;
	private boolean estaGuanyada;
	private int puntuacio;
	private Casella[][] casella ;//relacion con la tabla de casella
	
	
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	private boolean checkAcabada() {
		return estaAcabada;
	}
	public void setEstaAcabada(boolean estaAcabada) {
		this.estaAcabada = estaAcabada;
	}
	public boolean isEstaGuanyada() {
		return estaGuanyada;
	}
	public void setEstaGuanyada(boolean estaGuanyada) {
		this.estaGuanyada = estaGuanyada;
	}
	public int getPuntuacio() {
		return puntuacio;
	}
	public void setPuntuacio(int puntuacio) {
		this.puntuacio = puntuacio;
	}
	
	//entiendo yo que el crearPartida es el constructor
	
	public Partida(int id)
	{
		idPartida = id;
		puntuacio =0;
		estaAcabada=false;
		estaGuanyada=false;
		casella  = new Casella[4][4];
		
		
	}
	
	public void inicializar()
	{
		for(int i =1;i<=4;i++)
		{
			for(int j =1;j<=4;j++)
			{
				Casella c = new Casella(i,j);
				casella[i-1][j-1]=c;
				
				
			}
			
			
		}
		
		addRandomNum();
		addRandomNum();
		
		
	}
	
	public ArrayList<CasellaDTO> casellesAmbNumero()
	{
		ArrayList<CasellaDTO> result = new ArrayList<CasellaDTO>();
		
		for(int i=0; i<4;i++)
		{
			for(int j=0; j<4;j++)
			{
				
				CasellaDTO inf = casella[i][j].getInfo();
				
				if(inf.getNumero()!=null)
				{
					
					result.add(inf);
				}
				
			}
			
		}
		
		return result;
	}
	
	private void addRandomNum()
	{
		ArrayList<Casella> casellabuida = new ArrayList<Casella>();
		Casella c,c1;
		int n,randomN;
		
		for(int y=0;y<4;y++)
		{
			for(int x=0;x<4;x++)
			{
				c=casella[y][x];
				n=c.getNumero();
				
				if(n==0)
				{
					casellabuida.add(c);
				}
		
			}
		
		}
		
		if(casellabuida.size()>0)
		{
		
			n= (int) (Math.random()*casellabuida.size());
			c1=casellabuida.get(n);
			
			if((Math.random()*10)/10.f>0.1)randomN=2;
			else randomN=4;
			
			c1.setNumero(randomN);
		
		
		}

		
		
	}
	
	public ArrayList<CasellaDTO> ferMoviment(String tipusMov)
	{
		
		
		return null;
	}
	
	private boolean ferMov(String tipusMov)
	
	{
		
		boolean merge = false;
		boolean para,m=false,espaiblanc;
		int y,y1,x,x1;
		Casella c,c1;
		
		if(tipusMov.equals("esquerra"))
		{
			for(y=0;y<4;y++)
			{

				for(x=0;x<4;x++)
				{
					c = casella[y][x];
					x1=x+1;
					para=false;
					while(x1<4 && para==false)
					{
						c1 = casella[y][x1];
						
						espaiblanc = moureCasella(c,c1,para,m);
						if(espaiblanc==true)
						{
							x--;
						}
						if(merge==false && m==true)
						{
						
							merge=true;
						}
						x1++;
					}
					
				}
			}
		
		}
		else if(tipusMov.equals("dreta"))
		{
			for(y=0;y<4;y++)
			{
				for(x=3;x>=0;x--)
				{
					c = casella[y][x];
					x1=x-1;
					para=false;
					while(x1>=0 && para==false)
					{
						c1 = casella[y][x1];
						
						espaiblanc = moureCasella(c,c1,para,m);
						if(espaiblanc==true)
						{
							x++;
						}
						if(merge==false && m==true)
						{
						
							merge=true;
						}
						x1--;
					}
				
				}
			}
		
		}
		else if(tipusMov.equals("amunt"))
		{
			for(x=0;x<4;x++)
			{
				for(y=0;y<4;y++)
				{
				
					c = casella[y][x];
					y1=y+1;
					para=false;
					while(y1<4 && para==false)
					{
						c1 = casella[y1][x];
						
						espaiblanc = moureCasella(c,c1,para,m);
						if(espaiblanc==true)
						{
							y--;
						}
						if(merge==false && m==true)
						{
						
							merge=true;
						}
						y1++;
					}
				
				}
			}
		
		}
		else if(tipusMov.equals("avall"))
		{
			for(x=0;x<4;x++)
			{
				for(y=3;y>=0;y--)
				{
				
					c = casella[y][x];
					y1=y-1;
					para=false;
					while(y1>=0 && para==false)
					{
						c1 = casella[y1][x];
						
						espaiblanc = moureCasella(c,c1,para,m);
						if(espaiblanc==true)
						{
							y++;
						}
						if(merge==false && m==true)
						{
						
							merge=true;
						}
						y1--;
					}
				
				}
			}
		
		}
		
		return merge;
		
	}
	
	private boolean moureCasella(Casella c, Casella c1, boolean b, boolean m)
	
	{

		int n = c.getNumero();
		int n1 = c1.getNumero();
		boolean espaiblanc=false;
		b=false;
		m=false;

		if(n1>0)
		{
			if(n==0)
			{
				c.setNumero(n1);
				c1.setNumero(0);
				espaiblanc=true;
				m=true;
			
			}
			else if(n==n1)
			{
				c.setNumero(n*2);
				c1.setNumero(0);
				puntuacio+=n*2;
				m=true;
				
				if(n==1024)
				{
					if(estaGuanyada==false)estaGuanyada=true;
				
				}
			
			}

			b=true;



		}


	return espaiblanc;
	}

}
