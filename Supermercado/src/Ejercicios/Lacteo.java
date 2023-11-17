package Ejercicios;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import Ejercicios.Funciones;

public class Lacteo extends Producto implements Fecha {
	
	private static Queue<Lacteo> colaLacteos = new LinkedList<>();
	
	private LocalDate fechaFabricacion;
	private LocalDate fechaVencimiento;
	
	
	public Lacteo(int codigoBarra,  String marca, String descripcion, double precio, int stock,
			LocalDate fechaFabricacion, LocalDate fechaVencimiento) {
		super(codigoBarra, marca, descripcion, precio, stock,"Lacteo.txt");
		this.fechaFabricacion = fechaFabricacion;
		this.fechaVencimiento = fechaVencimiento;
		setNombreCategoria(Categorias.LACTEOS);
		setCodigoCategoria(Categorias.LACTEOS.getNumInterno());
		//agrego al producto a la cola
		colaLacteos.add(this);
	}

	//crear un objeto y lo almaceno en la lista y cola, y agrega a archivo
	 public static void agregarLacteo(int codigoBarra, String marca, String descripcion, double precio, int stock,
			LocalDate fechaFabricacion, LocalDate fechaVencimiento) {
		 	String contenido = "";
	        Lacteo lacteo = new Lacteo(codigoBarra, marca, descripcion, precio, stock, fechaFabricacion, fechaVencimiento);
	        contenido = (codigoBarra + "," + marca + "," + descripcion + "," + precio + ","
	        		+ stock + "," + fechaFabricacion + "," + fechaVencimiento + "\n");
	        Archivos.escribirArchivo("Lacteo.txt", contenido);
	 }
	
	 
	 public static void reponerProductoEnGondola() {
	        Lacteo productoLacteo = colaLacteos.poll();
	        if (productoLacteo != null) {
	            System.out.println("Reponiendo en góndola: " + productoLacteo.getDescripcion());
	        } 
	        else {
	            System.out.println("No hay productos lácteos en la cola para reponer.");
	        }
	    }
	 
	public String getFechaFabricacion() {
		return mostrarFechasFormateadas(fechaFabricacion);
	}
	
	public void setFechaFabricacion(LocalDate fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}
	
	public String getFechaVencimiento() {
		return mostrarFechasFormateadas(fechaVencimiento);
	}
	
	public void setFechaVencimiento(LocalDate fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	public void mostrar()
	{
		System.out.println(valoresImportantes(1));
		System.out.println(valoresImportantes(2));
		System.out.println(valoresImportantes(3));
		System.out.println(valoresImportantes(4));
		System.out.println(valoresImportantes(5));
		System.out.println(valoresImportantes(6));
	}
	

	public String valoresImportantes(int valor)
	{
		String valores = "";
		switch(valor)
		{
		case 1:
			valores = "Descripcion: " + getDescripcion();
			break;
		case 2: 
			valores = "Precio: " + getPrecio();
			break;
		case 3:
			valores = "Fecha de fabricacion: " + getFechaFabricacion();
			break;
		case 4: 
			valores = "Fecha de vencimiento: " + getFechaVencimiento();
			break;
		case 5:
			valores = "Estado: " + diferenciaFechas();
			break;
		case 6:
			valores = "Stock: " + getStock();		
			break;
		default:
			valores= "No se ha seleccionado una opcion correcta";
			break;
		}		
			return valores;
		}

	public String mostrarFechasFormateadas(LocalDate date) {
		String format= "0";
		DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		format = date.format(fechaFormateada);
		return format;
		}
		

	public String diferenciaFechas() {
		LocalDate hoy = LocalDate.now();
		String cadena = "";
		int dias = (int) ChronoUnit.DAYS.between(hoy, fechaVencimiento); 		
		if(dias>10){
			cadena = "Producto VIGENTE";
		}
		else
			if(dias>0 && dias<11){
				cadena = "Producto pronto a vencer";
			}
			else
				if(dias==0){
				cadena = "Producto VENCE HOY";
				}
			else
					if(dias<0)
					{
						cadena = "Producto VENCIDO";
					}
		return cadena;
	}

	
	public static void crear() {
		int codigoBarra, stock;
		String marca,  descripcion;
		double precio; 	LocalDate fechaFabricacion, fechaVencimiento, hoy = LocalDate.now();
		Scanner entrada = new Scanner (System.in);
		System.out.println("Vamos a agregar un producto: ");
		System.out.println("Codigo de Barra: ");
		codigoBarra = Producto.entradaCodBarra(Categorias.LACTEOS);
		System.out.println("Marca: ");
		marca = entrada.nextLine();
		System.out.println("Descripcion: ");
		descripcion = entrada.nextLine();
		System.out.println("Precio: ");
		precio = Funciones.entradaDouble();
		System.out.println("Stock: ");
		stock = Funciones.entradaInt();
		System.out.println("Fecha de Fabricacion: ");
		fechaFabricacion = Funciones.entradaFechas(null, hoy);
		System.out.println("Fecha de Vencimiento: ");
		fechaVencimiento = Funciones.entradaFechas(fechaFabricacion, null);
		try{
			agregarLacteo(codigoBarra, marca, descripcion, precio, stock, fechaFabricacion, fechaVencimiento);
			System.out.println("Lacteo creado con exito ");
		}
		catch(Exception error)
		{
			System.out.println("Fallo la creacion del Lacteo");
		}
	}
	
	public static void crearDesdeArchivos()
	{
		File miArchivo = new File ("Lacteo.txt");		
		try {
			BufferedReader lectura = new BufferedReader(new FileReader(miArchivo));
			String contenido = lectura.readLine();
			while(contenido != null || contenido == "")
			{
				String[] strArr = contenido.split(",");
				try {
					Lacteo lacteo = new Lacteo(Integer.parseInt(strArr[0]), strArr[1], strArr[2], Double.parseDouble(strArr[3]), Integer.parseInt(strArr[4]), LocalDate.parse(strArr[5]), LocalDate.parse(strArr[6]));
				}
				catch(Exception e)
				{
			
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
}
