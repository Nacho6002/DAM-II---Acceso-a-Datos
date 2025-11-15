package lectorjson;

import java.util.List;

public class DatosPersonales {
	
    private String nombre;
    private int edad;
    private String email;
    private Direccion direccion;
    private List<String> lenguajes;

    // Constructores, getters y setters
    public DatosPersonales() {}

    // Constructor completo
    public DatosPersonales(String nombre, int edad, String email, Direccion direccion, List<String> lenguajes) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
        this.direccion = direccion;
        this.lenguajes = lenguajes;
    }

    // Getters y setters de todos los atributos
    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<String> getLenguajes() {
		return lenguajes;
	}

	public void setLenguajes(List<String> lenguajes) {
		this.lenguajes = lenguajes;
	}
    

	@Override
    public String toString() {
        return "DatosPersonales{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", email='" + email + '\'' +
                ", direccion=" + direccion +
                ", lenguajes=" + lenguajes +
                '}';
    }
}

