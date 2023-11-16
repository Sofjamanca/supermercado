package Ejercicios;
import Ejercicios.Funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Personal {
	public static List<Personal> listaPersonal = new ArrayList<>();
	public static HashMap<Integer, String> diccionarioPersonal = new HashMap<>();
	private String nombre;
	private String apellido;
	private String legajo;
	private int dni;
	
	
	public Personal(String nombre, String apellido, String legajo, int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.legajo = legajo;
		this.dni = dni;
		
		listaPersonal.add(this);
		diccionarioPersonal.put(dni, legajo);
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getLegajo() {
		return legajo;
	}


	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public static void crearObjetos()
	{
		Personal persona; boolean validLegajo = false, validDni = false;
		int dni = 0; String nombre, apellido, legajo = "", contenido = "";
		Scanner entrada = new Scanner (System.in);
		System.out.println("Ingrese el dni: ");
		while(validDni==false) {
			dni = Funciones.entradaInt();
			legajo = obtenerLegajoPorDNI(dni);
			if(legajo==null) {
				validDni = true;
			} else {
				System.out.println("El DNI ya existe");
			}
			
		}
		System.out.println("Ingrese el nombre: ");
		nombre = entrada.nextLine();
		System.out.println("Ingrese el apellido: ");
		apellido = entrada.nextLine();
		System.out.println("Ingrese el legajo: ");
		while(validLegajo==false) {
			legajo= entrada.nextLine();
			persona = obtenerDatosPorLegajo(legajo);
			if(persona==null) {
				validLegajo = true;
			} else {
				System.out.println("El legajo ya existe");
			}
		}
		
		Personal nuevoPersonal = new Personal(nombre, apellido, legajo, dni);
        contenido = (nombre + "," + apellido + "," + legajo + "," + dni + "\n");
        Archivos.escribirArchivo("Personal.txt", contenido);
	}
	
	public static String obtenerLegajoPorDNI(int dni) {
		try{
			return diccionarioPersonal.get(dni);
		}
		catch(Exception e) {
			return null;
		}
        }
   
      public static Personal obtenerDatosPorLegajo(String legajo) {
          Personal encontrado = null;  
    	  for (Personal personal : listaPersonal) {
              if(encontrado != null)
            	  continue;
    		  if (personal.getLegajo().equals(legajo)) {
                	encontrado = personal;
                }
            }
    	  return encontrado;           
        }
      
      public void mostrar()
      {
    	  System.out.println("Nombre: " + nombre);
    	  System.out.println("Apellido: " + apellido);
    	  System.out.println("Legajo: " + legajo);
    	  System.out.println("DNI: " + dni);   	  
      }
	 
      public static void crearDesdeArchivos()
  	{
  		File miArchivo = new File ("Personal.txt");		
  		try {
  			BufferedReader lectura = new BufferedReader(new FileReader(miArchivo));
  			String contenido = lectura.readLine();
  			while(contenido != null || contenido == "")
  			{
  				String[] strArr = contenido.split(",");
  				try {
  					Personal personal = new Personal(strArr[0], strArr[1], strArr[2], Integer.parseInt(strArr[3]));
  				} catch (Exception e) {
  					
  				}
  				contenido = lectura.readLine();
  			}
  			lectura.close();			
  		}
  		catch (FileNotFoundException error)
  		{
  			System.out.println(error.getMessage());
  		}
  		catch (IOException error)
  		{
  			System.out.println(error.getMessage());
  		}		
  	}
      
  	public static void mostrarPersonal()
  	{
  		for(Personal elemento : listaPersonal)
  		{
  			elemento.mostrar();
  			System.out.println("--------------------------------------");
  		}
  	}
}
