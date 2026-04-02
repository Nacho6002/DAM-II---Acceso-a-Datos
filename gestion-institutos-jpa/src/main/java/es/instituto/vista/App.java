package es.instituto.vista;

import java.util.List;
import javax.swing.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import es.instituto.modelo.Asignatura;
import es.instituto.modelo.Centro;
import es.instituto.modelo.Profesor;

public class App {

    private EntityManagerFactory emf;
    private EntityManager em;

    public App() {
        // iniciamos conexion con la bd JPA
        emf = Persistence.createEntityManagerFactory("InstitutoJPA");
        em = emf.createEntityManager();
        crearMenuVentana();
    }

    private void crearMenuVentana() {
        JFrame frame = new JFrame("Gestión de Institutos - JPA");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // pa que salga centrada en pantalla

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JButton btnListarAsig = new JButton("1. Listado de asignaturas y profesores");
        btnListarAsig.setBounds(40, 40, 300, 40);
        panel.add(btnListarAsig);

        JButton btnListarCentros = new JButton("2. Listado de centros");
        btnListarCentros.setBounds(40, 100, 300, 40);
        panel.add(btnListarCentros);

        JButton btnAsignarDocencia = new JButton("3. Insertar asignatura y profesor");
        btnAsignarDocencia.setBounds(40, 160, 300, 40);
        panel.add(btnAsignarDocencia);

        JButton btnSalir = new JButton("4. SALIR");
        btnSalir.setBounds(40, 220, 300, 40);
        panel.add(btnSalir);

        btnListarAsig.addActionListener(e -> listarAsignaturasProfesores());
        btnListarCentros.addActionListener(e -> listarCentros());
        btnAsignarDocencia.addActionListener(e -> insertarAsignaturayProfesor());
        
        btnSalir.addActionListener(e -> {
            em.close();
            emf.close();
            System.exit(0);
        });

        frame.setVisible(true);
    }

    private void listarAsignaturasProfesores() {
        List<Asignatura> listaAsig = em.createQuery("SELECT a FROM Asignatura a", Asignatura.class).getResultList();
        StringBuilder sb = new StringBuilder();
        
        sb.append("=== ASIGNATURAS Y PROFESORES ===\n");
        // linea de guiones re larga pa obligar a la ventana a que sea ancha
        sb.append("----------------------------------------------------------------------------------------------------\n");

        // variables para ver cual asignatura tiene mas profes
        int maxProfesores = 0;
        String asignaturaMasProfesores = "Ninguna";

        for (Asignatura a : listaAsig) {
            int numProfes = a.getProfesores().size(); // contamos los profes
            
            // comprueba si es la que mas tiene profesores
            if (numProfes > maxProfesores) {
                maxProfesores = numProfes;
                asignaturaMasProfesores = a.getNombre();
            }

            // pone el total de profes al lado del nombre
            sb.append("Asignatura [").append(a.getId()).append("]: ").append(a.getNombre())
              .append(" (Total profes: ").append(numProfes).append(")\n");
              
            if (a.getProfesores().isEmpty()) {
                sb.append("  -> Sin profesores asignados.\n");
            } else {
                for (Profesor p : a.getProfesores()) {
                    sb.append("  -> Prof: ").append(p.getNombre())
                      .append(" (Especialidad: ").append(p.getEspecialidad().getNombre()).append(")\n");
                }
            }
            sb.append("----------------------------------------------------------------------------------------------------\n");
        }
        
        // imprime al final la ganadora
        sb.append("\nASIGNATURA CON MÁS PROFESORES: ").append(asignaturaMasProfesores)
          .append(" (").append(maxProfesores).append(" profesores)\n");
        
        JOptionPane.showMessageDialog(null, sb.toString(), "Listado Asignaturas", JOptionPane.INFORMATION_MESSAGE);
    }

    private void listarCentros() {
        List<Centro> listaCentros = em.createQuery("SELECT c FROM Centro c", Centro.class).getResultList();
        StringBuilder sb = new StringBuilder();
        
        sb.append("=== LISTADO DE CENTROS ===\n");
        sb.append("----------------------------------------------------------------------------------------------------\n");

        for (Centro c : listaCentros) {
            sb.append("Centro: ").append(c.getNombre()).append(" (").append(c.getLocalidad()).append(")\n");
            sb.append("Total profesores: ").append(c.getProfesores().size()).append("\n");
            sb.append("----------------------------------------------------------------------------------------------------\n");
        }
        
        JOptionPane.showMessageDialog(null, sb.toString(), "Listado Centros", JOptionPane.INFORMATION_MESSAGE);
    }

    private void insertarAsignaturayProfesor() {
        try {
            // muestra lista de profes con su especialidad primero
            List<Profesor> profes = em.createQuery("SELECT p FROM Profesor p", Profesor.class).getResultList();
            StringBuilder sbProfes = new StringBuilder();
            sbProfes.append("=== LISTADO DE PROFESORES ===\n");
            sbProfes.append("------------------------------------------------------------------------------------------------\n");
            for (Profesor p : profes) {
                sbProfes.append("ID: ").append(p.getId())
                        .append(" | Nombre: ").append(p.getNombre())
                        .append(" | Especialidad: ").append(p.getEspecialidad().getNombre()).append("\n");
            }
            sbProfes.append("------------------------------------------------------------------------------------------------\n");
            sbProfes.append("\nIntroduce ID del profesor: ");

            String idProf = JOptionPane.showInputDialog(sbProfes.toString());

            if (idProf == null || idProf.trim().isEmpty()) {
                return;
            }

            // muestra materias
            List<Asignatura> asignaturas = em.createQuery("SELECT a FROM Asignatura a", Asignatura.class).getResultList();
            StringBuilder sbAsig = new StringBuilder();
            sbAsig.append("=== LISTADO DE ASIGNATURAS ===\n");
            sbAsig.append("------------------------------------------------------------------------------------------------\n");
            for (Asignatura a : asignaturas) {
                sbAsig.append("ID: ").append(a.getId())
                        .append(" | Asignatura: ").append(a.getNombre()).append("\n");
            }
            sbAsig.append("------------------------------------------------------------------------------------------------\n");
            sbAsig.append("\nIntroduce ID de la asignatura: ");

            String idAsig = JOptionPane.showInputDialog(sbAsig.toString());

            if (idAsig == null || idAsig.trim().isEmpty()) {
                return;
            }

            // pasa a numeros
            int idProfesor = Integer.parseInt(idProf);
            int idAsignatura = Integer.parseInt(idAsig);

            Profesor prof = em.find(Profesor.class, idProfesor);
            Asignatura asig = em.find(Asignatura.class, idAsignatura);

            // validacion porsiacaso el usuario meta un id que no existe en la bd
            if(prof == null) {
                JOptionPane.showMessageDialog(null, "El profesor no existe en la base de datos.");
                return;
            }

            if(asig == null) {
                JOptionPane.showMessageDialog(null, "La asignatura no existe en la base de datos.");
                return;
            }

            if (prof.getAsignaturas().contains(asig)) {
                JOptionPane.showMessageDialog(null, "El profesor ya imparte esa asignatura.");
                return;
            }

            // guarda en la bd
            em.getTransaction().begin();
            prof.getAsignaturas().add(asig);
            asig.getProfesores().add(prof);
            em.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "¡Asignatura añadida al profesor correctamente!");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error: Debes introducir un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // si sale algun error hace rollback
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Error inesperado: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new App();
    }
}