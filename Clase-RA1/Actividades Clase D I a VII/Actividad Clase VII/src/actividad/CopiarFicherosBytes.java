package actividad;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//Actividad VII
public class CopiarFicherosBytes {
    public static void main(String[] args) throws IOException {

        // Se inicializan los streams de entrada y salida
        // Asume que Ffuente.txt existe, si no, lanzará una FileNotFoundException.
        FileInputStream in = new FileInputStream(new File("Ffuente.txt"));
        FileOutputStream out = new FileOutputStream(new File("Fdestino.txt"));

        int c;
        // El bucle lee un byte (como un int) de 'in'
        // El bucle se detiene cuando read() devuelve -1 (fin de archivo)
        while ((c = in.read()) != -1) {
            // El byte leído se escribe en 'out'
            out.write(c);
        }
        
        // Es crucial cerrar ambos streams
        in.close();
        out.close();
        
        System.out.println("Copia byte a byte de Ffuente.txt a Fdestino.txt completada.");
    }
}