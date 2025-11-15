package actividad;
import java.io.*;

//Actividad IV
public class FichTextoBufEscribir {
  public static void main(String[] args) {
      try {
          // El 'true' en FileWriter indica que se va a ANEXAR (append) al fichero. 
          // Si el fichero no existe, se crea.
          FileWriter fic = new FileWriter("FichTexto.txt", true);
          
          // BufferedWriter mejora la eficiencia de escritura y tiene el método newLine()
          BufferedWriter fichero = new BufferedWriter(fic);

          for (int i = 1; i < 11; i++) {
              // escribe una cadena de 10 caracteres (o más)
              fichero.write("Fila numero: " + i); 
              // escribe un salto de línea
              fichero.newLine(); 
          }
          
          System.out.println("10 líneas añadidas a FichTexto.txt.");
          fichero.close();

      } catch (FileNotFoundException fn) {
          System.out.println("No se encuentra el fichero");
      } catch (IOException io) {
          System.out.println("Error de E/S ");
      }
  }
}
