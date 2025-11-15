package actividad;
import java.io.*;

public class LectorTexto {
    public static void main(String[] args) {
        // Verificar si se proporcionó un nombre de archivo
        if (args.length == 0) {
            System.out.println("Error: Debe proporcionar el nombre del archivo como argumento.");
            System.out.println("Uso: java LectorTexto <nombreArchivo>");
            return;
        }

        // Obtener el nombre del archivo del primer argumento
        File archivo = new File(args[0]);

        // Comprobar si el archivo existe
        if (!archivo.exists()) {
            System.out.println("Error: El archivo '" + args[0] + "' no existe.");
            return;
        }

        try {
            // Lectura carácter a carácter
            System.out.println("Lectura carácter a carácter:");
            FileReader lectorCaracteres = new FileReader(archivo);
            int caracter;
            while ((caracter = lectorCaracteres.read()) != -1) {
                System.out.print((char) caracter);
            }
            lectorCaracteres.close();

            // Lectura línea a línea
            System.out.println("\n\nLectura línea a línea:");
            // Se crea un nuevo FileReader ya que el anterior ya leyó hasta el final
            BufferedReader lectorLineas = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = lectorLineas.readLine()) != null) {
                System.out.println(linea);
            }
            lectorLineas.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}