package Ejercicios;
import java.time.LocalDate;
import java.util.*;

public class Regaleria extends Producto {
		private static Stack<Regaleria> pilaNovedades = new Stack<>();	
	
		private String materialFabricacion;
		
		public Regaleria(int codigoBarra, String marca, String descripcion, double precio, int stock, String materialFabricacion)
		{
			super(codigoBarra, marca, descripcion, precio, stock);
			this.materialFabricacion = materialFabricacion;
			setNombreCategoria(Categorias.REGALERIA);
			setCodigoCategoria(Categorias.REGALERIA.getNumInterno());
			//agrego el producto a la pila
			pilaNovedades.push(this);
		}
		
		// Método para crear un objeto de regalería
	    public static void agregarNovedad(int codigoBarra, String marca, String descripcion, double precio, int stock, String materialFabricacion) {
	        Regaleria novedad = new Regaleria(codigoBarra, marca, descripcion, precio, stock, materialFabricacion);
	    }
	    
	 // Método para reponer la última novedad en la góndola
	    public static void reponerNovedadEnGondola() {
	        if (!pilaNovedades.isEmpty()) {
	            Regaleria novedad = pilaNovedades.pop();
	            System.out.println("Reponiendo en góndola: " + novedad.getDescripcion() + " (Lo último, la novedad)");
	        } else {
	            System.out.println("No hay novedades en la pila para reponer.");
	        }
	    }
		
		public String getmaterialFabricacion()
		{
			return this.materialFabricacion;
		}
		
		public static void crear() {
			int codigoBarra, stock; 
			String marca,  descripcion, materialFabricacion;
			double precio;
			Scanner entrada = new Scanner (System.in);
			System.out.println("Vamos a agregar un producto: ");
			System.out.println("Codigo de Barra: ");
			codigoBarra = Producto.entradaCodBarra(Categorias.REGALERIA);
			System.out.println("Marca: ");
			marca = entrada.nextLine();
			System.out.println("Descripcion: ");
			descripcion = entrada.nextLine();
			System.out.println("Precio: ");
			precio = Funciones.entradaDouble();
			System.out.println("Stock: ");
			stock = Funciones.entradaInt();
			System.out.println("Material de Fabricacion: ");
			materialFabricacion = entrada.nextLine();
			
			try{
				agregarNovedad(codigoBarra, marca, descripcion, precio, stock, materialFabricacion);
				System.out.println("Regaleria creada con exito ");
			}
			catch(Exception error)
			{
				System.out.println("Fallo la creacion de la Regaleria");
			}
			
			
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
				valores = "Material de fabricación: " + getmaterialFabricacion();
				break;
			default:
				valores= "No se ha seleccionado una opcion correcta";
				break;
			}		
				return valores;
		}
		
		public void mostrar()
		{
			System.out.println(valoresImportantes(1));
			System.out.println(valoresImportantes(2));
			System.out.println(valoresImportantes(3));
		}
		
		
}
