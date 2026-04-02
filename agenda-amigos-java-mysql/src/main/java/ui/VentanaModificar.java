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

public class VentanaModificar extends JDialog {

    public VentanaModificar(JFrame padre, Amigo amigoOriginal) {
        super(padre, true);
        setTitle("Modificar Amigo");
        setSize(300, 350);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setLocationRelativeTo(padre);

        // lleno los campos con la info actual
        JTextField txtNombre = new JTextField(amigoOriginal.getNombre());
        JTextField txtDireccion = new JTextField(amigoOriginal.getDireccion());
        JTextField txtTelefono = new JTextField(amigoOriginal.getTelefono());
        JTextField txtAficiones = new JTextField(amigoOriginal.getAficiones());
        JTextField txtIdPandilla = new JTextField(String.valueOf(amigoOriginal.getIdPandilla()));

        this.add(new JLabel("Nombre:"));
        this.add(txtNombre);
        this.add(new JLabel("Dirección:"));
        this.add(txtDireccion);
        this.add(new JLabel("Teléfono:"));
        this.add(txtTelefono);
        this.add(new JLabel("Aficiones:"));
        this.add(txtAficiones);
        this.add(new JLabel("ID de la Pandilla:"));
        this.add(txtIdPandilla);

        JButton btnGuardar = new JButton("Actualizar Datos");
        this.add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idPandilla = Integer.parseInt(txtIdPandilla.getText());
                    
                    // meto los datos nuevos pero dejamos el id original
                    amigoOriginal.setNombre(txtNombre.getText());
                    amigoOriginal.setDireccion(txtDireccion.getText());
                    amigoOriginal.setTelefono(txtTelefono.getText());
                    amigoOriginal.setAficiones(txtAficiones.getText());
                    amigoOriginal.setIdPandilla(idPandilla);
                    
                    AmigoDAO dao = new AmigoDAO();
                    dao.modificarAmigo(amigoOriginal);
                    
                    JOptionPane.showMessageDialog(VentanaModificar.this, "¡Datos actualizados!");
                    dispose(); // cerramos
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(VentanaModificar.this, "Error de formato.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setVisible(true);
    }
}