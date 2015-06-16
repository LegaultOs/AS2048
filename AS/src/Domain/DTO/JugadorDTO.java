package Domain.DTO;
//Clase hecha para rellenar la tabla de ranquing.
public class JugadorDTO {


	private String username;
	private int punt;

	public JugadorDTO()
	{}

	public void setUsername(String user)
	{
		this.username=user;
	}

	public void setPunt(int p)
	{
		this.punt=p;

	}
	
	public String getUsername()
	{
		return username;
	}
	
	public int getPunt()
	{
		return punt;
	}



}