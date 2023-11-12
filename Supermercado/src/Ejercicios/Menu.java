package Ejercicios;
import Ejercicios.Funciones;
import java.util.*;
public class Menu {

	public static void main(String[] args) {
		
		int opcion; boolean exit = false;
		System.out.println("<== Sea bienvenido al menu de su SUPERMERCADO ==>");
		while(exit == false) {
		System.out.println("1. Seccion: LACTEO");
        System.out.println("2. Seccion: REGALERIA");
        System.out.println("3. Seccion: PERSONAL");
        System.out.println("4. Salir");
        System.out.println("Ingrese un numero entero: ");
        opcion = Funciones.entradaOpcion(4);
        switch(opcion)
        {
        	case 1:
        		opcionesLacteo();
        		break;
        	case 2:
        		opcionesRegaleria();
        		break;
        	case 3:
        		opcionesPersonal();
        		break;
        	case 4: 
        		exit = true;
        		break;
        }
        
		}
		}
	
	public static void opcionesLacteo()
	{
		int opcion; boolean exit = false;
		while(exit == false) {
		System.out.println("<== LACTEO ==>");
		System.out.println("1. Buscar en lista: ");
        System.out.println("2. Agregar");
        System.out.println("3. Ver reposición");
        System.out.println("4. Salir");
        opcion = Funciones.entradaOpcion(4);
        switch(opcion)
        {
        case 1:
        	Producto.buscarProducto(Categorias.LACTEOS);
        	break;
        case 2:
        	Lacteo.crear();
        	break;
        case 3:
        	Lacteo.reponerProductoEnGondola();
        	break;
        case 4:
        	exit = true;
        	break;     	
        } 
		}
		}
		
		
		
		public static void opcionesRegaleria()
		{
			int opcion; boolean exit = false;
			while(exit == false) {
			System.out.println("<== REGALERIA ==>");
			System.out.println("1. Buscar en lista: ");
	        System.out.println("2. Agregar");
	        System.out.println("3. Ver reposición");
	        System.out.println("4. Salir");
	        opcion = Funciones.entradaOpcion(4);
	        switch(opcion)
	        {
	        case 1:
	        	Producto.buscarProducto(Categorias.REGALERIA);
	        	break;
	        case 2:
	        	Regaleria.crear();
	        	break;
	        case 3:
	        	Regaleria.reponerNovedadEnGondola();
	        	break;
	        case 4:
	        	exit = true;
	        	break;     	
	        }
			}}
			
			public static void opcionesPersonal()
			{
				int opcion, dni; boolean exit = false; String legajo;
				Personal personal = null; 
				Scanner entrada = new Scanner (System.in);
				while(exit == false) {
				System.out.println("<== PERSONAL ==>");
				System.out.println("1. Buscar personal: ");
		        System.out.println("2. Agregar: ");
		        System.out.println("3. Buscar legajo por DNI: ");
		        System.out.println("4. Salir");
		        opcion = Funciones.entradaOpcion(4);
		        switch(opcion)
		        {
		        case 1:
		        	System.out.println("Escriba el legajo que desea buscar: ");
		        	legajo = entrada.nextLine();
		        	personal = Personal.obtenerDatosPorLegajo(legajo);
		        	if(personal == null)
		        	{
		        		System.out.println("Personal no encontrado");
		        		break;
		        	}
		        	personal.mostrar();
		        	break;
		        case 2:
		        	Personal.crearObjetos();
		        	break;
		        case 3:
		        	System.out.println("Escriba el dni que desea buscar: ");
		        	dni = Funciones.entradaInt();
		        	legajo = Personal.obtenerLegajoPorDNI(dni);
		        	if(legajo == null){
		        		System.out.println("DNI no encontrado");
		        	}
		        	System.out.println("Su legajo es: " + legajo);
		        	break;
		        case 4:
		        	exit = true;
		        	break;     	
		        }
				}
		
	}

}



