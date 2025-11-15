package actividad;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
//Actividad VI
public class EscribirNIO {
    public static void main(String[] args) {
        Path ruta = Path.of("FichTextoNIO.txt");
        //cadena a escribir
        String cadena = "\nEscribimos una línea usando java.nio.file.";
        try {
            // CREATE: crea un fichero si no existe. Si existe, lo SOBREESCRIBE (por defecto si no hay otras opciones)
            // Files.writeString es un método de conveniencia para escribir cadenas.
            Files.writeString(ruta, "Primera línea con NIO." + cadena, StandardOpenOption.CREATE);
            
            // APPEND: si el fichero existe, agrega los datos al final
            Files.writeString(ruta, "Segunda línea agregada al final." + cadena, StandardOpenOption.APPEND);
            System.out.println("Datos escritos y agregados con java.nio.file en FichTextoNIO.txt.");
            
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
    }
}
