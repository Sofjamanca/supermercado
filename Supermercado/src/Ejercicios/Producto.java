package Ejercicios;
import java.io.*;
import java.util.*;


public abstract class Producto {
	
	private static List<Producto> listaProductos = new ArrayList<>();
	
	private int codigoBarra;
	private int codigoCategoria;
	private Categorias nombreCategoria;
	private String marca;
	private String descripcion;
	private double precio;
	private int stock;
	private String nombreArchivo;
	
	public Producto(int codigoBarra, String marca, String descripcion, double precio, int stock, String nombreArchivo)
	{
		this.codigoBarra = codigoBarra;
		this.marca = marca;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.nombreArchivo = nombreArchivo;
		
		//Agrego este producto a la lista
		listaProductos.add(this);
	}

	public static List<Producto> obtenerTodosLosProductos() {
        return listaProductos;
    }
	
	private int indiceProducto()
	{
		int cont = 0, encontre = -1;
		for(Producto producto : listaProductos)
		{
			if(producto.codigoBarra == codigoBarra && producto.nombreCategoria == nombreCategoria) {
				encontre = cont;
			}
			if(producto.nombreCategoria == nombreCategoria) cont++;
		}
		return encontre;
	}
	public int getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(int codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public Categorias getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(Categorias nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	
	public void mostrarInfoCategorias()
	{
		        System.out.println("Categoria: " + getNombreCategoria());
		        System.out.println("Codigo Interno: " + getCodigoCategoria());
	}
	
	public static int entradaCodBarra(Categorias tipo)
	{
		boolean validCod = false;int codigoBarra = 0;
		Producto producto;
		while(validCod == false)
		{
			codigoBarra = Funciones.entradaInt();
			producto = Producto.buscar(codigoBarra, tipo);
			if(producto == null)
			{
				validCod = true;
			}
			else {
				System.out.println("El codigo de barra ya EXISTE");
			}
		}
		
		return codigoBarra;
	}
	
	public static Producto buscar(int codigo, Categorias tipo)
	{
		Producto encontrado = null;
		for(Producto producto : listaProductos)
		{
			if(encontrado != null)
			{
				break;
			}
			if(producto.codigoBarra == codigo && producto.nombreCategoria == tipo)
			{
				encontrado = producto;
			}
		}
		return encontrado;
	}
	
	public static int maxCodBarra()
	{
		int max = 0;
		for(Producto elemento : listaProductos)
		{
			if(max < elemento.codigoBarra)
			{
				max = elemento.codigoBarra;
			}
		}
		return max;
	}
	
	public static int cantProductos(Categorias tipo)
	{
		int cont = 0;
		for(Producto elemento : listaProductos)
		{
			if(elemento.nombreCategoria == tipo)
			{
				cont++;
			}
		}
		return cont;
	}
	
	public static void buscarProducto(Categorias tipo)
	{
		int cont = cantProductos(tipo), opcionBuscar;
		Producto producto;
    	if(cont == 0)
    	{
    		System.out.println("No existen " + tipo);
    		return;
    	}
    	System.out.println("Ingrese el codigo que desea buscar: ");
    	opcionBuscar = Funciones.entradaOpcion(Producto.maxCodBarra());
    	producto = Producto.buscar(opcionBuscar, tipo);
    	if(producto == null)
    	{
    		System.out.println("No existe el producto");
    	}
    	else
    	{
    		producto.mostrar();
    	}
	}
	
	public static void mostrarProductos()
	{
		for(Producto elemento : listaProductos)
		{
			elemento.mostrar();
			System.out.println("--------------------------------------");
		}
	}
	
	public void modificarStock(int valor, int operacion)
	{
		int total = 0;
		if(operacion == 1)
		{
			total = stock + valor;
		}
		else{
			 total = stock - valor;
			}
		if (total < 0)
			{
				System.out.println("El stock no puede ser menor a 0, por lo tanto, no se ha podido modificar el stock");
			}
		else {
			stock = total;
			Archivos.modificarArchivo(nombreArchivo, (indiceProducto()+1), 5, Integer.toString(stock));
		}
	}

	public abstract void mostrar();


	public abstract String valoresImportantes(int valor);
	
}



