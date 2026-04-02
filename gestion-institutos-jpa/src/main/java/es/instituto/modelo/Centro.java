package es.instituto.modelo;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Centro {
	// clave primaria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
 // codigo del centro
    private String codigo;
    
    // nombre del centro
    private String nombre;
    
    // localidad del centro
    private String localidad;

    // un centro tiene varios profes
    @OneToMany(mappedBy = "centro")
    private List<Profesor> profesores;

    // el director del insti es un profesor, pero puede ser null
    @OneToOne
    private Profesor director;

    public Centro() {}

    public int getId() { 
    	return id; 
    }
    public void setId(int id) { 
    	this.id = id; 
    }
    public String getCodigo() { 
    	return codigo; 
    }
    public void setCodigo(String codigo) { 
    	this.codigo = codigo; 
    }
    public String getNombre() { 
    	return nombre; 
    }
    public void setNombre(String nombre) { 
    	this.nombre = nombre; 
    }
    public String getLocalidad() { 
    	return localidad; 
    }
    public void setLocalidad(String localidad) { 
    	this.localidad = localidad; 
    }
    public List<Profesor> getProfesores() { 
    	return profesores; 
    }
    public void setProfesores(List<Profesor> profesores) { 
    	this.profesores = profesores; 
    }
}