package edu.upc.eetac.ea.notas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NOTAS_ID")
	int idNota;

	@ManyToOne
	//@JoinColumn(name = "Userid")
	@JoinColumn( insertable=true, updatable=true)
	//@OnDelete(action=OnDeleteAction.CASCADE)
	Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "note")
	String nota = null;

	public int getIdNota() {
		return idNota;
	}

	public void setIdNota(int idNota) {
		this.idNota = idNota;

	}

	public String getNota() {
		return nota;
	}

	public void setNota(String note) {
		nota = note;
	}

}
