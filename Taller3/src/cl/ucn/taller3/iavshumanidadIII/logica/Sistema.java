package cl.ucn.taller3.iavshumanidadIII.logica;

import java.io.FileNotFoundException;
import java.util.List;

import cl.ucn.taller3.iavshumanidadIII.dominio.AI;
import cl.ucn.taller3.iavshumanidadIII.dominio.Programmer;
import cl.ucn.taller3.iavshumanidadIII.dominio.Soldier;
import cl.ucn.taller3.iavshumanidadIII.dominio.User;

public interface Sistema {

	/*
	 * Login y Lectura de Archivos
	 * Descripcion: Se obtienen datos de los diferentes archivos, y se comprueba si el usuario ingresado existe
	 * Pre: Que existan los archivos Requeridos 
	 * Post: 
	 */
	
	boolean LecturaArchivosYLogin(List<User> users, List<Soldier> soldiers, List<AI> ais, List<Programmer> programmers, String user, String password) throws FileNotFoundException;
}