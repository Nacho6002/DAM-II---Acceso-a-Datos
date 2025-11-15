package actividad;

import java.io.Serializable;
//Esto se agrego para que java sepa como convertir al objeto persona en bytes en el metodo de guardarAgenda

//Esta clase es la mas sensilla es como la plantilla que se utilizara para agregar, eliminar y buscar a cada persona en la Agenda
public class Persona implements Serializable {
    //Estos atributos son privados y son los que van a conformas cada persona tiene que tener un dni un nombre y un telefono
    private String dni;
    private String nombre;
    private long telefono;

//El constructor cuando se agrega a una nueva persona le pasa los datos dni, nombre y telefono y los guarda dentro del objeto persona
    public Persona(String dni, String nombre, long telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }

//Estos getter sirven para leer los datos privados desde las otras clases
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public long getTelefono() {
        return telefono;
    }

//Pues este toString nos sirve para cuando quiera imprimir una persona imprime todos sus atributos
    @Override
    public String toString() {
        return "DNI: " + dni + ", Nombre: " + nombre + ", Teléfono: " + telefono;
    }
}
