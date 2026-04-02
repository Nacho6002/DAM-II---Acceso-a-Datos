package gestionamigos;

public class Amigo {
    private int idAmigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String aficiones;
    private int idPandilla;

    public Amigo(int idAmigo, String nombre, String direccion, String telefono, String aficiones, int idPandilla) {
        this.idAmigo = idAmigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.aficiones = aficiones;
        this.idPandilla = idPandilla;
    }

    // Getters y Setters
    public int getIdAmigo() {
    	return idAmigo; 
    }
    
    
    public void setIdAmigo(int idAmigo) {
    	this.idAmigo = idAmigo; 
    }

    
    public String getNombre() {
    	return nombre; 
    }
    
    
    public void setNombre(String nombre) {
    	this.nombre = nombre; 
    }

    
    public String getDireccion() {
    	return direccion; 
    }
    
    
    public void setDireccion(String direccion) {
    	this.direccion = direccion; 
    }

    
    public String getTelefono() {
    	return telefono; 
    }
    
    
    public void setTelefono(String telefono) {
    	this.telefono = telefono; 
    }

    
    public String getAficiones() {
    	return aficiones; 
    }
    
    
    public void setAficiones(String aficiones) {
    	this.aficiones = aficiones; 
    }

    
    public int getIdPandilla() {
    	return idPandilla; 
    }
    
    
    public void setIdPandilla(int idPandilla) {
    	this.idPandilla = idPandilla; 
    }
    
    
    
}