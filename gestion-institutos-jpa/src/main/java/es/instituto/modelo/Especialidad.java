package es.instituto.modelo;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Especialidad {
	// Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    // Nombre de la especialidad
    private String nombre;

    // profes que tienen esta especialidad
    @OneToMany(mappedBy = "especialidad")
    private List<Profesor> profesores;

    public Especialidad() {}

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