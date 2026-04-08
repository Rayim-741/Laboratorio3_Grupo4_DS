import java.util.Scanner;

/**
 * Clase principal: punto de entrada del programa.
 * Menú interactivo con Scanner para probar todas las funcionalidades.
 */
public class Main {

    public static void main(String[] args) {

        AgendaGremio agenda = new AgendaGremio();
        Scanner scanner     = new Scanner(System.in);

        // ── Datos de prueba precargados ──────────────────
        System.out.println("\n══════════════════════════════════════════");
        System.out.println("   INICIALIZANDO AGENDA DEL GREMIO...");
        System.out.println("══════════════════════════════════════════");

        agenda.agregar("Arlan Swordbreaker", "Maestro");
        agenda.agregar("Lyria Moonwhisper", "Experta");
        agenda.agregar("Torin Ashblade",    "Experto");
        agenda.agregar("Nessa Brightflame", "Aprendiz");
        agenda.agregar("Drak Ironfoot",     "Maestro");
        agenda.agregar("Selyria Voss",      "Novato");
        agenda.agregar("Borin Deepaxe",     "Aprendiz");

        // Prueba de validaciones
        agenda.agregar("",                  "Maestro");     // nombre vacío
        agenda.agregar("Arlan Swordbreaker","Novato");      // nombre duplicado

        // ── Menú principal ───────────────────────────────
        int opcion = -1;

        do {
            System.out.println("\n╔══════════════════════════════════╗");
            System.out.println("║     ⚔  GREMIO DE AVENTUREROS  ⚔  ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║  1. Agregar miembro              ║");
            System.out.println("║  2. Listar todos los miembros    ║");
            System.out.println("║  3. Buscar por nombre            ║");
            System.out.println("║  4. Buscar por rango             ║");
            System.out.println("║  0. Salir                        ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("  Elige una opción: ");

            // Validación de entrada del menú
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // limpiar buffer
            } else {
                System.out.println("[ERROR] Ingresa un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {

                case 1: // ── AGREGAR ──────────────────────────────
                    System.out.println("\n── Agregar nuevo miembro ──");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.println("Rangos disponibles: Novato | Aprendiz | Experto | Maestro | Leyenda");
                    System.out.print("Rango: ");
                    String rango = scanner.nextLine();

                    agenda.agregar(nombre, rango);
                    break;

                case 2: // ── LISTAR ───────────────────────────────
                    agenda.listar();
                    break;

                case 3: // ── BUSCAR POR NOMBRE ────────────────────
                    System.out.print("\nIngresa el nombre a buscar: ");
                    String buscarNombre = scanner.nextLine();
                    agenda.buscarPorNombre(buscarNombre);
                    break;

                case 4: // ── BUSCAR POR RANGO ─────────────────────
                    System.out.println("\nRangos: Novato | Aprendiz | Experto | Maestro | Leyenda");
                    System.out.print("Ingresa el rango a buscar: ");
                    String buscarRango = scanner.nextLine();
                    agenda.buscarPorRango(buscarRango);
                    break;

                case 0: // ── SALIR ─────────────────────────────────
                    System.out.println("\n¡Hasta la próxima aventura, camarada!\n");
                    break;

                default:
                    System.out.println("[ERROR] Opción no válida. Elige entre 0 y 4.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
