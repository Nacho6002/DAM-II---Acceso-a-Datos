package ui;

import gestionamigos.Amigo;
import gestionamigos.AmigoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VentanaAmigo extends JDialog {

    public VentanaAmigo(JFrame padre) {
        super(padre, true); // esto bloquea la ventana de atras
        setTitle("Nuevo Amigo");
        setSize(300, 350);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); // todo en vertical
        setLocationRelativeTo(padre);

        // campos
        JTextField txtNombre = new JTextField();
        JTextField txtDireccion = new JTextField();
        JTextField txtTelefono = new JTextField();
        JTextField txtAficiones = new JTextField();
        JTextField txtIdPandilla = new JTextField();

        this.add(new JLabel("Nombre:"));
        this.add(txtNombre);
        this.add(new JLabel("Dirección:"));
        this.add(txtDireccion);
        this.add(new JLabel("Teléfono:"));
        this.add(txtTelefono);
        this.add(new JLabel("Aficiones:"));
        this.add(txtAficiones);
        this.add(new JLabel("ID de la Pandilla (1, 2 o 3):"));
        this.add(txtIdPandilla);

        JButton btnGuardar = new JButton("Guardar Amigo");
        this.add(btnGuardar);

        // accion guardar
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idPandilla = Integer.parseInt(txtIdPandilla.getText());
                    
                    // se manda el  id 0 porque la bd lo genera sola
                    Amigo nuevoAmigo = new Amigo(0, txtNombre.getText(), txtDireccion.getText(), 
                                                 txtTelefono.getText(), txtAficiones.getText(), idPandilla);
                    
                    AmigoDAO dao = new AmigoDAO();
                    dao.insertarAmigo(nuevoAmigo);
                    
                    JOptionPane.showMessageDialog(VentanaAmigo.this, "¡Amigo guardado con éxito!");
                    dispose(); // cerramos
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(VentanaAmigo.this, "Error: Comprueba que el ID de la pandilla sea un número.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
}