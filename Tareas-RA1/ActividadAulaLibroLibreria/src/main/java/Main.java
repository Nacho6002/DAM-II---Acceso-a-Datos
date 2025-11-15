
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.util.Arrays;
import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        // Crear dos libros
        Libro libro1 = new Libro("Drácula", "Bram Stoker", "Alianza", "978-8420674161");
        Libro libro2 = new Libro("1984", "George Orwell", "Círculo", "978-8499890944");

        // Crear la librería
        Libreria libreria = new Libreria("LectuLandia", "Guadalajara", Arrays.asList(libro1, libro2));

        // JSON
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.writerWithDefaultPrettyPrinter().writeValue(new File("libreria.json"), libreria);
        System.out.println("JSON guardado.");

        // XML
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writerWithDefaultPrettyPrinter().writeValue(new File("libreria.xml"), libreria);
        System.out.println("XML guardado.");
    }
}

