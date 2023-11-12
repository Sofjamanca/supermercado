package Ejercicios;
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
	
	public Producto(int codigoBarra, String marca, String descripcion, double precio, int stock)
	{
		this.codigoBarra = codigoBarra;
		this.marca = marca;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		
		//Agrego este producto a la lista
		listaProductos.add(this);
	}

	public static List<Producto> obtenerTodosLosProductos() {
        return listaProductos;
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
	
	public abstract void mostrar();


	public abstract String valoresImportantes(int valor);
	
}



