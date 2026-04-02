package es.instituto.modelo;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Profesor {
	// Clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    // Nombre del profesor
    private String nombre;

    //centro al que pertenece el profesor
    @ManyToOne
    private Centro centro;

    //especialidad que realiza el profesor
    @ManyToOne
    private Especialidad especialidad;

    // relacion reflexiva el jefe tambien es un profe
    @ManyToOne
    private Profesor jefeDepartamento;

    // relacion muchos a muchos con las materias
    @ManyToMany
    @JoinTable(
        name = "profesor_asignatura",
        joinColumns = @JoinColumn(name = "profesor_id"),
        inverseJoinColumns = @JoinColumn(name = "asignatura_id")
    )
    private List<Asignatura> asignaturas = new ArrayList<>();

    public Profesor() {
    	// Constructor por defecto
    }
    

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
    
    public Centro getCentro() {
    	return centro; 
    }
    
    public void setCentro(Centro centro) {
    	this.centro = centro; 
    }
    
    public Especialidad getEspecialidad() {
    	return especialidad; 
    }
    
    public void setEspecialidad(Especialidad especialidad) {
    	this.especialidad = especialidad; 
    }
    
    public Profesor getJefeDepartamento() {
    	return jefeDepartamento; 
    }
    
    public void setJefeDepartamento(Profesor jefeDepartamento) {
    	this.jefeDepartamento = jefeDepartamento; 
    }
    
    public List<Asignatura> getAsignaturas() {
    	return asignaturas; 
    }
    
    public void setAsignaturas(List<Asignatura> asignaturas) {
    	this.asignaturas = asignaturas; 
    }
    
    
}