package ejercicio;

import javax.swing.text.Document;
import java.text.Format;

public class ConversionEntreFormatos {
    // Crear el documento
    Document document = new Document(root);
    // Guardar en un archivo
    XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
xmlOutputter.output(document, new FileWriter("personas.xml"));
System.out.println("Fichero XML creado.");
    String salida = xmlOutputter.outputString(document);
System.out.println(salida);
}


