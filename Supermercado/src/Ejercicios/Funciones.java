package Ejercicios;
import java.util.*;
import java.time.*;
public class Funciones {
	public static int esNumeroEntero(String cadena) {
		int num;
        try {
            num = Integer.parseInt(cadena);
            return num;
        }  
        catch (NumberFormatException error) {
            return -1;
        }
     	}
	
	public static Double esNumeroDouble(String cadena) {
		double num;
        try {
            num = Double.parseDouble(cadena);
            return num;
        } 
        catch (NumberFormatException error) {
            return -1.0;
        }
     	}
	
	public static double entradaDouble()
	{
		String result; double opcion = -1.0;
		Scanner entrada = new Scanner (System.in);
		while(opcion == -1.0)
		{
			result = entrada.nextLine();
			opcion = esNumeroDouble(result);
			if(opcion<=0){
				System.out.println("Debe ser un precio valido: ");
			}
	}	
		return opcion;
		}
	
	
	public static int entradaInt()
	{
		String result; int opcion = -1;
		Scanner entrada = new Scanner (System.in);
		while(opcion <= 0)
		{
			result = entrada.nextLine();
			opcion = esNumeroEntero(result);
			if(opcion<=0){
				System.out.println("Debe ser un numero positivo: ");
				
			}
	}	
		return opcion;
		}
	
	public static int entradaOpcion(int max)
	{
		String result; int opcion = -1;
		Scanner entrada = new Scanner (System.in);
		while(opcion == -1)
		{
			result = entrada.nextLine();
			opcion = esNumeroEntero(result);
			if(opcion == -1){
				System.out.println("Debe ser un numero entero: ");
			}
			else {
				if(opcion >max || opcion<0)
				{
					System.out.println("Debe ingresar una opcion dentro del rango especificado");
					opcion = -1;
				}
			}
		}
		return opcion;
	}
	
	
	public static boolean validarFecha(String fecha, LocalDate fechaInicio, LocalDate fechaFin)
	{
		LocalDate result; boolean valido = false;
		try {
	         // Convertir la entrada del usuario a un objeto LocalDate
	          result = LocalDate.parse(fecha);
	          if(fechaInicio != null && fechaFin != null) {
	        	 valido = (result.isAfter(fechaInicio) && result.isBefore(fechaFin)); 
	        	 if(valido == false) System.out.println("La fecha es incorrecta");
	        	 return valido;
	          }
	          if(fechaInicio != null) {
	        	  valido = result.isAfter(fechaInicio);
	        	  if(valido == false) System.out.println("La fecha es incorrecta");
		          return valido;
	          }
	          if(fechaFin != null) {
	        	  valido = result.isBefore(fechaFin);
	        	  if(valido == false) System.out.println("La fecha es incorrecta");
		          return valido;
	          }
	          return true;
	     } catch (Exception e) {
	         System.out.println("Error al procesar la fecha. Asegúrese de ingresarla en el formato correcto (yyyy-MM-dd).");
	         return false;
	     }
	}
	
	
	public static LocalDate entradaFechas(LocalDate fechaInicio, LocalDate fechaFin)
	{
		Scanner entrada = new Scanner (System.in);
		String inputFecha = ""; boolean fechaValid = false;
		System.out.print("Ingrese la fecha (Formato: yyyy-MM-dd): ");
        while(fechaValid == false)
        {
            inputFecha = entrada.nextLine();
            fechaValid = validarFecha(inputFecha, fechaInicio, fechaFin);   
        }
       return LocalDate.parse(inputFecha);       
	}
	
	
	
	
	}
	
