package edu.upc.eetac.ea.notas;

import java.io.IOException;
import java.util.List;

public class Main {
	public static void main (String []args) throws IOException{
		
		
		IOperationBD io = OperacionesBD.getInstance();
		
		System.out.println("prueba MAIN");
		/*Usuario usu = new Usuario();
		usu.setContra("1234");
		usu.setLogin("pepe");
		usu.setUserid(0);*/
		
		//Probamos a añadir usuario
		//io.addUser(usu);
		
		//Dame usuario by Userid
		//Usuario usu2 = io.dameUsuarioById(1);
		//System.out.println("Dama el usuario con id1: " + usu2.getLogin());
		
		//Dame usuario by name --> repasar, no funciona
		//Usuario usun = io.dameUsuarioByName("pepe2");
		//System.out.println("pepe2 tiene userid: " + usun.getUserid());
		
		//Actualiza usuario
		//usu.setLogin("nataa");
//		usu.setUserid(5);
//		io.updateUser(usu);
		//Usuario usu3 = io.dameUsuarioById(1);
		//System.out.println("Dama el usuario con id1: " + usu3.getLogin());

		//añadir nota:
//		Nota note = new Nota();
//		note.setIdNota(0);
//		note.setNota("kjkjjk");
//		note.setUsuario(usu);
//		io.addNotas(note, usu);
		//Probamos a eliminar usuario
		//io.deleteUser(usu);
		
		
		//obtener usuario a partir de su username
		//Usuario usu3 = io.dameUsuarioByName("pepe3");
		//System.out.println(usu3.getLogin());
		
		//listamos usuarios:
		
//		List<Usuario> listu = io.getListUsers();
//		System.out.println(" ----- Lista de Usuarios -----");
//		int i = 0;
//		while(i<listu.size())
//		{
//			System.out.println("*" + listu.get(i).getLogin() );
//			i++;
//		}
		
		//** Lista de notas:
		List<Nota> listn = io.getListNotas(4);
		int i = 0;
		while(i<listn.size())
		{

			System.out.println("NOTA: " + listn.get(i).getIdNota());
			System.out.println("NOTA: " + listn.get(i).getNota());
			i++;
		}
	
		
	}
}
