package edu.upc.eetac.ea.notas;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.QueryParam;
import javax.ws.rs.PathParam;

public interface IOperationBD {

	// void addUsers(String loguin, String password);

	public String addUser(Usuario usuario) throws IOException;

	public void updateUser(Usuario usuario);

	public String addNotas(Nota note, Usuario usu);

	public void deleteUser(Usuario usuario);

	public Usuario dameUsuarioById(int userid);
	
	public Usuario dameUsuarioByName(String name);
	
	public List<Usuario> getListUsers();

	Nota getNota(int notaid);

	void updateNota(Nota nota, int userid);

	void deleteNota(int notaid);

	List<Nota> getListNotas(int userid);

	//public void addNote(Nota note, Usuario usu);
	
	//public Usuario getuser(@PathParam("username") String username);
	//public Users getuser (Users usuario);
}
