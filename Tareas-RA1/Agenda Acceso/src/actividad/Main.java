package actividad;
//Esta clase es la que tiene el main para iniciar el programa y los menus que se utilizan
import java.util.List;
import java.util.Scanner;

public class Main {

    //Este es el menu de la aplicacion del que el usuario se va a guiar para poder utilizarla
    private static void MostrarElMenu() {
        System.out.println("\n--- MENÚ AGENDA ---");
        System.out.println("1. Agregar una nueva persona a la Agenda");
        System.out.println("2. Buscar una persona en la Agenda");
        System.out.println("3. Eliminar una persona de la Agenda");
        System.out.println("4. Mostrar todas las personas en la Agenda");
        System.out.println("5. Salir del programa");
        System.out.print("Elige una de las opciones: ");
    }

    private static void AgregarPersona(Scanner scanner, Agenda agenda) {
        System.out.print("Introduce el DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce el teléfono: ");
        long telefono = scanner.nextLong();
        scanner.nextLine();

        if (agenda.agregar(dni, nombre, telefono)) {
            System.out.println("Persona agregada con éxito.");
        } else {
            System.out.println("Error: Ya existe una persona con ese DNI.");
        }
    }

    private static void buscarPersonas(Scanner scanner, Agenda agenda) {
        System.out.print("Introduce el DNI de la persona a buscar: ");
        String dni = scanner.nextLine();
        Persona persona = agenda.Buscar(dni);

        if (persona != null) {
            System.out.println("Persona encontrada:");
            System.out.println(persona);
        } else {
            System.out.println("Persona no encontrada.");
        }
    }

    private static void eliminarPersonas(Scanner scanner, Agenda agenda) {
        System.out.print("Introduce el DNI de la persona a eliminar: ");
        String dni = scanner.nextLine();
        agenda.eliminar(dni);
        System.out.println("Si la persona existía, ha sido eliminada.");
    }

    private static void mostrarTodasLasPersonas(Agenda agenda) {
        List<Persona> personas = agenda.total();
        if (personas.isEmpty()) {
            System.out.println("La agenda está vacía.");
        } else {
            System.out.println("--- LISTA DE TODAS LAS PERSONAS ---");
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        }
    }

    //Crea el scanner para que pueda leer lo que se escriba por consola y crea el objeto agenda
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion;

//El interruptor para los menus
        do {
            MostrarElMenu();

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Numero incorrecto por favor, ingrese un número entre 1 y 5.");
                scanner.nextLine();
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    AgregarPersona(scanner, agenda);
                    break;
                case 2:
                    buscarPersonas(scanner, agenda);
                    break;
                case 3:
                    eliminarPersonas(scanner, agenda);
                    break;
                case 4:
                    mostrarTodasLasPersonas(agenda);
                    break;
                case 5:
                    agenda.guardarAgenda();
                    System.out.println("Saliendo de la aplicación. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}