package lectorjson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;

public class AgregarYQuitarCampos {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode root = mapper.readTree(new File("src/main/resources/datospersonal.json"));

            // Agregar campo "casada"
            ((ObjectNode) root).put("casada", true);
            // Eliminar campo "email"
            ((ObjectNode) root).remove("email");

            // Mostrar JSON actualizado bonito
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root));

            // Guardar cambios
            mapper.writeValue(new File("src/main/resources/datospersonal.json"), root);
        } catch (Exception e) {
            System.err.println("Error al modificar el JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}