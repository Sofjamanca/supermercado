package Ejercicios;
import Ejercicios.Funciones;
import java.util.*;
public class Menu {

	public static void main(String[] args) {
		Archivos.crearArchivo("Lacteo.txt"); Lacteo.crearDesdeArchivos();
		Archivos.crearArchivo("Regaleria.txt"); Regaleria.crearDesdeArchivos();
		Archivos.crearArchivo("Personal.txt"); Personal.crearDesdeArchivos();
		int opcion; boolean exit = false;
		System.out.println("<== Sea bienvenido al menu de su SUPERMERCADO ==>");
		while(exit == false) {
		System.out.println("1. Seccion: LACTEO");
        System.out.println("2. Seccion: REGALERIA");
        System.out.println("3. Seccion: PERSONAL");
        System.out.println("4. Seccion: ver todos los productos");
        System.out.println("5. Seccion: ver todos los personales");
        System.out.println("6. Salir");
        System.out.println("Ingrese un numero entero: ");
        opcion = Funciones.entradaOpcion(6);
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
        		Producto.mostrarProductos();
        		break;
        	case 5:
        		Personal.mostrarPersonal();
        		break;
        	case 6: 
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
        System.out.println("2. Agregar: ");
        System.out.println("3. Ver reposicion: ");
        System.out.println("4. Modificar stock: ");
        System.out.println("5. Salir");
        opcion = Funciones.entradaOpcion(5);
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
        	Scanner entrada = new Scanner (System.in);
        	int opcionBuscar, cambio, cantidad; Producto producto = null;
        	while(producto == null)
        	{
        		System.out.println("Ingrese el codigo que desea buscar: ");
            	opcionBuscar = Funciones.entradaOpcion(Producto.maxCodBarra());
            	producto = Producto.buscar(opcionBuscar, Categorias.LACTEOS);
            	if(producto == null) System.out.println("El producto no existe: ");
        	}
        	System.out.println("Si desea incrementar presione 1: "
        			+ "Para decrementar presione 2: ");
        	cambio = Funciones.entradaOpcion(2);
        	System.out.println("Indique la cantidad: ");
        	cantidad = Funciones.entradaInt();
        	producto.modificarStock(cantidad, cambio);       
        case 5:
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
	        System.out.println("3. Ver reposicion");
	        System.out.println("4. Modificar stock");
	        System.out.println("5. Salir");
	        opcion = Funciones.entradaOpcion(5);
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
	        	Scanner entrada = new Scanner (System.in);
	        	int opcionBuscar, cambio, cantidad; Producto producto = null;
	        	while(producto == null)
	        	{
	        		System.out.println("Ingrese el codigo que desea buscar: ");
	            	opcionBuscar = Funciones.entradaOpcion(Producto.maxCodBarra());
	            	producto = Producto.buscar(opcionBuscar, Categorias.REGALERIA);
	            	if(producto == null) System.out.println("El producto no existe: ");
	        	}
	        	System.out.println("Si desea incrementar presione 1: "
	        			+ "Para decrementar presione 2: ");
	        	cambio = Funciones.entradaOpcion(2);
	        	System.out.println("Indique la cantidad: ");
	        	cantidad = Funciones.entradaInt();
	        	producto.modificarStock(cantidad, cambio);     
	        case 5:
	        	exit = true;
	        	break;     	
	        }
		}
	}
			
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



