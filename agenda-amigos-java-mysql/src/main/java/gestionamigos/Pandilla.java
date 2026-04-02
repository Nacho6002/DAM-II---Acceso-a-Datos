package gestionamigos;

public class Pandilla {
    private int idPandilla;
    private String nombre;
    private String lugarVacaciones;

    public Pandilla(int idPandilla, String nombre, String lugarVacaciones) {
        this.idPandilla = idPandilla;
        this.nombre = nombre;
        this.lugarVacaciones = lugarVacaciones;
    }

    // Getters y Setters
    public int getIdPandilla() {
    	return idPandilla; 
    }
    
    public void setIdPandilla(int idPandilla) {
    	this.idPandilla = idPandilla; 	
    }

    
    public String getNombre() { 
    	return nombre; 
    }
    
    public void setNombre(String nombre) {
    	this.nombre = nombre; 
    }

    
    public String getLugarVacaciones() {
    	return lugarVacaciones; 
    }
    
    
    public void setLugarVacaciones(String lugarVacaciones) {
    	this.lugarVacaciones = lugarVacaciones; 
    }

    
    @Override
    public String toString() {
        return nombre + " (Vacaciones: " + lugarVacaciones + ")";
    }
}