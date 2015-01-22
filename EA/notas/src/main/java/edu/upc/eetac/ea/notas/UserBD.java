package edu.upc.eetac.ea.notas;

import java.util.ArrayList;
import java.util.List;

public class UserBD {
	private String contra = null;
	private String login = null;
	private int Userid;
	
	//List<Nota> notas=new ArrayList<Nota>();
	
	
	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getUserid() {
		return Userid;
	}

	public void setUserid(int userid) {
		Userid = userid;
	}

	/*public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}*/

	

}
