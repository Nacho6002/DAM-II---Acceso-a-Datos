	package actividad;

	import java.io.*;

	// Actividad III - Escritura básica
	public class EscribirTexto {
	    public static void main(String[] args) {
	        try {
	            // FileWriter por defecto crea el fichero si no existe y lo sobreescribe
	            // Si quieres añadir sin sobreescribir, usarías: new FileWriter("FichTexto.txt", true);
	            FileWriter fic = new FileWriter("FichTexto.txt");
	            
	            // Escribir un String (que internamente puede verse como un array de caracteres)
	            String datos = "Este es un String escrito de corrido."; 
	            fic.write(datos);

	            // Escribir un array de caracteres
	            char[] masDatos = {'A', 'B', 'C', 'D'};
	            fic.write(masDatos);
	            
	            // Escribir un carácter uno a uno
	            fic.write('E');

	            System.out.println("Datos escritos en FichTexto.txt sin saltos de línea.");
	            
	            fic.close();

	        } catch (IOException io) {
	            System.out.println("Error de E/S: " + io.getMessage());
	        }
	    }
	}
