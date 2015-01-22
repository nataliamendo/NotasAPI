package edu.upc.eetac.ea.notas;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {

	@Column(name = "Contra")
	String contra = null;
	
	@Column(name = "name")
	String login = null;
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Userid", unique = true)
	int Userid;

	// RELACIONES
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)	
	List<Nota> notas=new ArrayList<Nota>();

	public Usuario() {
		//this.notas= new ArrayList<Notas>();
	}
	
	public int getUserid() {
		return Userid;
	}

	public void setUserid(int userid) {
		Userid = userid;
	}

	public void addNota(Nota note) {
		this.notas.add(note);
	}

	//@OneToMany(mappedBy = "usuario",cascade ={CascadeType.ALL})
	public List<Nota> getNotas() {
	//return null;	
		return this.notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public void eliminarNota(Nota nota) {

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String loguin) {
		this.login = loguin;
	}

	public String getContra() {
		return contra;
	}

	public void setContra(String contra) {
		this.contra = contra;
	}

	// RELACIONES APLICAR
	/*
	 * @OneToMany(cascade =CascadeType.ALL, fetch = FetchType.LAZY) public void
	 * setNotas(List<Notas> ratings) { this.notas = ratings; } public
	 * List<Notas> getNotas() { return notas; }
	 */

}
