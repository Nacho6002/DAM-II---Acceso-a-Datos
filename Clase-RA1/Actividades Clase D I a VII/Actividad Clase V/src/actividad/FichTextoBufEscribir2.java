package actividad;
import java.io.*;

//Actividad V
public class FichTextoBufEscribir2 {
  public static void main(String[] args) {
      try {
          // PrintWriter se inicializa sobre un FileWriter.
          // OJO: Al no usar el 'true' en FileWriter, SOBREESCRIBE el archivo.
          PrintWriter fichero = new PrintWriter(new FileWriter("FichTexto.txt"));

          for(int i=1; i<11; i++){
              // println() escribe la cadena y añade el salto de línea automáticamente
              fichero.println("Fila numero: "+i);
          }

          System.out.println("10 líneas escritas con PrintWriter en FichTexto.txt.");
          fichero.close();

      } catch (FileNotFoundException fn) {
          System.out.println("No se encuentra el fichero");
      } catch (IOException io) {
          System.out.println("Error de E/S ");
      }
  }
}