package edu.upc.eetac.ea.notas;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ioperation")
public class NotasResources {

	public static List<OperacionesBD> users;
	private static NotasResources instance = null;

	IOperationBD usuarios = OperacionesBD.getInstance();

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String myresource() {
		return " Hola, llega hasta NotasResources";
	}

	@POST
	@Path("/users")
	@Consumes(Mediatype.NOTES_USERS)
	@Produces(Mediatype.NOTES_USERS)
	public String addUsers(Usuario usuario) throws IOException {
		System.out.println(usuario.getLogin());

		usuarios.addUser(usuario);
		
		return "usuario añadido";
	}

	@PUT
	@Path("/update/{userid}")
	@Consumes(Mediatype.NOTES_USERS)
	@Produces(Mediatype.NOTES_USERS)
	public String updateUser(Usuario usuario, @PathParam("userid") int userid) {
		System.out.println(usuario.getLogin() +"," + usuario.getContra());
		usuario.setUserid(userid);
		usuarios.updateUser(usuario);
		
		Usuario usu = usuarios.dameUsuarioById(userid);
		if(usu!=null)
		{
			return "Usuario actualizado";
		}
		else
		{
			return "fallo al actualizar";
		}
		
	}
	
	@GET
	@Path("/getusuario/{userid}")
	@Produces(Mediatype.NOTES_USERS_BD)
	public UserBD dameUsuario(@PathParam("userid") int userid)
	{
		//Usuario usu = usuarios.getUsuario(userid);
		Usuario usu = usuarios.dameUsuarioById(userid);
		
		System.out.println("^^^^^^^^ Usuario:  " + usu.getLogin());
		UserBD u = new UserBD();
		u.setContra(usu.getContra());
		u.setLogin(usu.getLogin());
		u.setUserid(usu.getUserid());
		
		return u;
		
	}

	@POST
	@Path("/{userid}/note")
	@Consumes(Mediatype.NOTAS_NOTA)
	//@Produces(Mediatype.NOTES_USERS)
	public String addNotas(@PathParam("userid") int userid, Nota note) {

		System.out.println("* * ** * * * * * * ** userid: " + userid + "; Nota recibida: " + note.getNota());

		Usuario usu = usuarios.dameUsuarioById(userid);
		
		System.out.println("++ Usuario: " + usu.getLogin());
		
		//note.setUsuario(usu);
		
		//Nota n = usu.notas.
		/*n.setNota(note.getNota());
		n.setUsuario(usu);
		n.setIdNota(0);*/
		
		usuarios.addNotas(note, usu);
		
		//Usuario usu2 = usuarios.dameUsuarioById(userid);
		
		return "nota añadida correctamente";
		
	}
	
	@GET
	@Path("/note")
	@Produces(MediaType.TEXT_PLAIN)
	public String prueba() {
		return "esto lo hace";
	}

	
	// * * * * Obtener usuario a partir de su username
	/*
	@GET
	@Path("/users/get/{username}")
	@Produces(Mediatype.NOTES_USERS)
	public Usuario getuser(@PathParam("username") String username) {
		System.out.println(username);

		//return usuarios.devolver(username);
		return null;

	}*/

	@DELETE
	@Path("/users/{userid}")
	@Consumes(Mediatype.NOTES_USERS)
	public String deleteUser(@PathParam("userid") int userid) {
		System.out.println("Receemos para que se borre");
		//usuarios.eliminarU(usuario);
		Usuario usu = usuarios.dameUsuarioById(userid);
		usuarios.deleteUser(usu);
		
		return "usuario eliminado";

	}
	
	@DELETE
	@Path("/note/{Userid}/{idNota}")
	public void eliminarN(@PathParam("idNota") int nid, @PathParam("Userid") int uid)
	{
		//usuarios.notaDelete(nid, uid);
		//usuarios.d
		
	}
	
	//Obtener lista de usuarios
	@GET
	@Path("/getlistusu")
	//@Produces(Mediatype.NOTES_USERS)
	public List<Usuario> getListUsarios()
	{
		List<Usuario> listu = usuarios.getListUsers();
		return listu;
	}
	
	//Obtener lista de notas
	@GET
	@Path("/getlistnota/{userid}")
	//@Produces(Mediatype.NOTES_USERS)
	public List<Nota> getListNotas(@PathParam("userid") int userid)
	{
		List<Nota> listn = usuarios.getListNotas(userid);
		return listn;
	}
	
	
	@PUT
	@Path("/{userid}/note/{notaid}")
	@Consumes(Mediatype.NOTAS_NOTA)
	public String updateNotas(@PathParam("userid") int userid, @PathParam("notaid") int notaid, Nota n) {

		System.out.println("* * ** * * * * * * ** userid: " + userid + "; noteid: " + notaid);

		Nota n1 = usuarios.getNota(notaid);
		n1.setNota(n.getNota());
			
		usuarios.updateNota(n1, userid);
		
		return null;
	}
	
	@DELETE
	@Path("/{userid}/note/{notaid}")
	public String deleteNotas(@PathParam("userid") int userid, @PathParam("notaid") int notaid) {

		System.out.println("* * ** * * * * * * ** userid: " + userid + ";noteid: " + notaid);

		Nota n = usuarios.getNota(notaid);
			
		usuarios.deleteNota(notaid);
		
		//Usuario usu2 = usuarios.dameUsuarioById(userid);
		
		return null;
	}

}
