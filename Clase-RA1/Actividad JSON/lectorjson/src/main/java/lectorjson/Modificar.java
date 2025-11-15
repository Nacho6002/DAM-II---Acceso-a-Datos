package lectorjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Modificar {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            DatosPersonales datos = mapper.readValue(new File("src/main/resources/datospersonal.json"), DatosPersonales.class);

            // Añadir "C" a la lista de lenguajes
            datos.getLenguajes().add("C");

            // Modificar la calle
            datos.getDireccion().setCalle("Avenida del Tajo");

            // Guardar cambios en el archivo
            mapper.writeValue(new File("src/main/resources/datospersonal.json"), datos);

            System.out.println("Modificado y guardado: " + datos);
        } catch (Exception e) {
            System.err.println("Error al modificar el JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}