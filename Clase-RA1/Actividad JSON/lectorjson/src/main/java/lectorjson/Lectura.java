package lectorjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Map;

public class Lectura {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Leer como Map
            Map<String, Object> map = mapper.readValue(new File("src/main/resources/datospersonal.json"), Map.class);
            System.out.println("Leído como Map: " + map);

            // Leer como objeto DatosPersonales
            DatosPersonales datos = mapper.readValue(new File("src/main/resources/datospersonal.json"), DatosPersonales.class);
            System.out.println("Leído como objeto: " + datos);
        } catch (Exception e) {
            System.err.println("Error al leer el JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}