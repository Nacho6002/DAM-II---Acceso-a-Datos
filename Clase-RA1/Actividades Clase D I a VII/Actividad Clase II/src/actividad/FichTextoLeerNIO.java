package actividad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//Actividad II
public class FichTextoLeerNIO {
	public static void main(String[] args) throws IOException  {
		// Crear un objeto Path. En este caso lee su propio código fuente.
		Path path = Paths.get("FichTextoLeer.java");

		// Leer todo el contenido del archivo como una lista de líneas
		List<String> lineas = Files.readAllLines(path);

		for (String linea : lineas) {
			System.out.println(linea);
		}
	}
}
