package Ejercicios;

public enum Categorias {
	
		ALIMENTOS(1),
		BEBIDAS(2),
		ELECTRONICA(3),
		JUGUETERIA(4),
		LACTEOS(5),
		LIMPIEZA(6),
		MASCOTAS(7),
		PANADERIA(8),
		PERFUMERIA(9),
		REGALERIA(10);
	
	
	private int numeroInterno;
	
	private Categorias (int numeroInterno)
	{
		this.numeroInterno = numeroInterno;
	}
	
	public int getNumInterno()
	{
		return numeroInterno;
	}
	

	
	}
