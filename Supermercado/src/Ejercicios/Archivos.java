package Ejercicios;
import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Archivos {
	public static void crearArchivo(String ruta)
	{	
	File miArchivo = new File (ruta);
	if (miArchivo.exists() == true)
	{
		return;
	}
	else
	{
		try 
		{
			PrintWriter salida = new PrintWriter (miArchivo);
			salida.close();
		}
		catch(FileNotFoundException error)
		{
			System.out.println(error.getMessage());
		}
	}
	}
	
	public static void escribirArchivo(String ruta, String contenido)
	{
		File miArchivo = new File (ruta);
		
		try
		{
			PrintWriter escritura = new PrintWriter (new FileWriter(miArchivo, true));
			escritura.println(contenido);
			escritura.close();
		}
		catch(FileNotFoundException error)
		{
			System.out.println(error.getMessage());
		}
		catch(IOException error)
		{
			System.out.println(error.getMessage());
		}
	}
	
	public static void copyContent(File a, File b)
    { 
		try {
			 FileInputStream in = new FileInputStream(a); 
		        FileOutputStream out = new FileOutputStream(b); 
		  
		            int n;	  
		            while ((n = in.read()) != -1) { 
		                out.write(n); 
		            } 
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
        } 

    private static void borrarDatosArchivoTemporal(String archivoTemporal) {
        Path temporalPath = Paths.get(archivoTemporal);
        try {
            // Sobrescribe el archivo temporal con una cadena vacía
            Files.write(temporalPath, new byte[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	
	public static void modificarArchivo(String nombre, int numLinea, int numColumna, String valor)
	{
		File miArchivo = new File (nombre);	int contLineas = 1, contColumnas = 1;
		try{
			BufferedReader lectura = new BufferedReader(new FileReader(miArchivo));
			String contenido = lectura.readLine();
			while(contenido != null) {
				String newLine = contenido;
				if(contLineas == numLinea)
				{
					String[] columns = contenido.split(",");
					newLine = "";
					for(String columna : columns)
					{
						if(contColumnas>1) newLine = newLine + ",";
						if(numColumna==contColumnas){
							newLine = newLine + "" + valor;
						} else {
							newLine = newLine + "" + columna;
						}
						contColumnas++;
					}
				}
				contLineas++;
				Archivos.escribirArchivo("temp.txt",newLine);
				contenido = lectura.readLine();
			}
			lectura.close();
			copyContent(new File ("temp.txt"), new File (nombre));
			borrarDatosArchivoTemporal("temp.txt");			
		}
		catch(FileNotFoundException error)
		{
			System.out.println(error.getMessage());
		}
		catch(IOException error)
		{
			System.out.println(error.getMessage());
		}
		
	}
	
	
}
