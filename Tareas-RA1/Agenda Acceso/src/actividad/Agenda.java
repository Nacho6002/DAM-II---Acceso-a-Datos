package actividad;

//Esta clase es la que tiene los metodos de agregar una persona, buscarla por el dni, eliminarla
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    //En esta lista es donde se guardan todas las personas agregadas a la agenda
    private List<Persona> personas;
    private static final String NOMBRE_ARCHIVO = "agenda.dat";

    //Este constructor lo que hace es que al ejecutar llama a cargarAgenda para intentar recuperar los datos guardados
    public Agenda() {
        this.personas = new ArrayList<>();
        cargarAgenda();
    }

    //Este metodo lo que hace es que cuando recibe los datos comprueba con el for si el dni ya existe si ya existe pues devuelve false si no esta se guarda la persona
    public boolean agregar(String dni, String nom, long tel) {
        for (Persona p : personas) {
            if (p.getDni().equals(dni)) {
                return false;
            }
        }
        personas.add(new Persona(dni, nom, tel));
        return true;
    }

    //Este metodo con removeIf revisa toda la lista persona si hay una persona con el numero de dni resivido la elimina
    public void eliminar(String dni) {
        personas.removeIf(p -> p.getDni().equals(dni));
    }

    //Este metodo con el for recorre toda la lista buscando la persana con el dni resivido si la encuantra pues te devuelve la persona con ese dni si no la encuentra devuelve un null
    public Persona Buscar(String dni) {
        for (Persona p : personas) {
            if (p.getDni().equals(dni)) {
                return p;
            }
        }
        return null;
    }

    public List<Persona> total() {
        return new ArrayList<>(personas);
    }

    //Este metodo utiliza ObjectOutputStream que esto practicamente agarra toda la lista personas y las mete en agenda.dat
    public void guardarAgenda() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            oos.writeObject(personas);
            System.out.println("Agenda guardada correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar la agenda: " + e.getMessage());
        }
    }
//Este metodo hace lo contrario de lo que hace el anterior utiliza ObjectInputStream para coger todo lo guardado en agenda.dat y volverlo a cargar en la lista personas nuevamente
    private void cargarAgenda() {
        File archivo = new File(NOMBRE_ARCHIVO);
        if (archivo.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                personas = (ArrayList<Persona>) ois.readObject();
                System.out.println("Agenda cargada correctamente.");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error al cargar la agenda: " + e.getMessage());
            }
        }
    }
}