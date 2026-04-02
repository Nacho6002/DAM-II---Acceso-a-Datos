package es.instituto.modelo;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Asignatura {
	// Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

    // tabla intermedia con los profes que dan esta materia
    @ManyToMany
    @JoinTable(
        name = "profesor_asignatura",
        joinColumns = @JoinColumn(name = "asignatura_id"),
        inverseJoinColumns = @JoinColumn(name = "profesor_id")
    )
    private List<Profesor> profesores = new ArrayList<>();

    public Asignatura() {}

    public int getId() { 
    	return id; 
    }
    
    public void setId(int id) { 
    	this.id = id; 
    }
    public String getNombre() { 
    	return nombre; 
    }
    public void setNombre(String nombre) { 
    	this.nombre = nombre; 
    }
    public List<Profesor> getProfesores() {
    	return profesores; 
    }
    public void setProfesores(List<Profesor> profesores) { 
    	this.profesores = profesores; 
    }
}