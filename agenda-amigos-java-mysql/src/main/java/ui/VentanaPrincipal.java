package ui;

import gestionamigos.Amigo;
import gestionamigos.AmigoDAO;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        // configuracion de la ventana 
        setTitle("Agenda de Amigos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1)); 
        setLocationRelativeTo(null); 

        // botones
        JButton btnAgregar = new JButton("Agregar nuevo Amigo");
        JButton btnListar = new JButton("Listar Amigos");
        JButton btnBuscar = new JButton("Buscar Amigo");
        JButton btnModificar = new JButton("Modificar datos de Amigo");

        this.add(btnAgregar);
        this.add(btnListar);
        this.add(btnBuscar);
        this.add(btnModificar);

        // accion agregar
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaAmigo(VentanaPrincipal.this);
            }
        });

        // accion listar modificada para mostrar todo
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AmigoDAO dao = new AmigoDAO();
                List<Amigo> lista = dao.obtenerTodos();
                
                StringBuilder texto = new StringBuilder();
                for (Amigo a : lista) {
                    texto.append("ID: ").append(a.getIdAmigo())
                         .append(" Nombre: ").append(a.getNombre())
                         .append(" Dir: ").append(a.getDireccion())
                         .append(" Tel: ").append(a.getTelefono())
                         .append(" Aficiones: ").append(a.getAficiones())
                         .append(" Pandilla: ").append(a.getIdPandilla())
                         .append("\n");
                }
                
                if (texto.length() == 0) {
                    texto.append("No hay amigos en la base de datos");
                }
                
                JOptionPane.showMessageDialog(null, texto.toString(), "Lista de Amigos", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // accion bucar con opcion a buscar por nombre o telefono y filtrar por pandilla o no filtrar
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String op = JOptionPane.showInputDialog("Escribe 1 para buscar por nombre o 2 para buscar por telefono");
                if (op != null) {
                    String criterio = "telefono";
                    if (op.equals("1")) {
                        criterio = "nombre";
                    }
                    
                    String valor = JOptionPane.showInputDialog("Escribe el nombre o telefono a buscar");
                    if (valor != null && !valor.trim().isEmpty()) {
                        String pand = JOptionPane.showInputDialog("Escribe el ID de la pandilla o deja en blanco para buscar en todas");
                        int idPand = 0;
                        try {
                            if (pand != null && !pand.trim().isEmpty()) {
                                idPand = Integer.parseInt(pand);
                            }
                        } catch (Exception ex) {
                            // si mete letras no hace nada malo solo ignora y busca en todas
                        }
                        
                        AmigoDAO dao = new AmigoDAO();
                        List<Amigo> encontrados = dao.buscarAmigosAvanzado(criterio, valor, idPand);
                        
                        if (!encontrados.isEmpty()) {
                            StringBuilder datos = new StringBuilder();
                            for (Amigo a : encontrados) {
                                datos.append("Nombre: ").append(a.getNombre()).append("\n")
                                     .append("Direccion: ").append(a.getDireccion()).append("\n")
                                     .append("Telefono: ").append(a.getTelefono()).append("\n")
                                     .append("Aficiones: ").append(a.getAficiones()).append("\n")
                                     .append("ID Pandilla: ").append(a.getIdPandilla()).append("\n\n");
                            }
                            JOptionPane.showMessageDialog(null, datos.toString(), "Resultados", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontro a nadie con esos datos");
                        }
                    }
                }
            }
        });

        // accion modificar
        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tlf = JOptionPane.showInputDialog("Telefono del amigo a modificar");
                if (tlf != null && !tlf.trim().isEmpty()) {
                    AmigoDAO dao = new AmigoDAO();
                    List<Amigo> encontrados = dao.buscarAmigos("telefono", tlf);
                    
                    if (!encontrados.isEmpty()) {
                        Amigo amigoAEditar = encontrados.get(0);
                        new VentanaModificar(VentanaPrincipal.this, amigoAEditar);
                    } else {
                        JOptionPane.showMessageDialog(null, "No existe un amigo con ese telefono");
                    }
                }
            }
        });
    }
}