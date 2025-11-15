
import java.util.List;

public class Libreria {
    private String nombre;
    private String ciudad;
    private List<Libro> libros;

    public Libreria() {}

    public Libreria(String nombre, String ciudad, List<Libro> libros) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.libros = libros;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public List<Libro> getLibros() { return libros; }
    public void setLibros(List<Libro> libros) { this.libros = libros; }

    @Override
    public String toString() {
        return nombre + ", " + ciudad + ", " + libros;
    }
}
