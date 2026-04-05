import java.util.Scanner;

class Gremio {

    private String[] nombres;
    private int[] rangos;
    private int contador;
    private int capacidad;

    // Constructor
    public Gremio(int capacidad) {
        this.capacidad = capacidad;
        nombres = new String[capacidad];
        rangos = new int[capacidad];
        contador = 0;
    }

    // Método para agregar miembro
    public void agregar(String nombre, int rango) {
        if (contador >= capacidad) {
            System.out.println("❌ No se pueden agregar más miembros (agenda llena).");
            return;
        }

        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("❌ Nombre inválido.");
            return;
        }

        nombres[contador] = nombre;
        rangos[contador] = rango;
        contador++;

        System.out.println("✅ Miembro agregado correctamente.");
    }

    // Método para listar miembros
    public void listar() {
        if (contador == 0) {
            System.out.println("📭 No hay miembros registrados.");
            return;
        }

        System.out.println("\n📜 Lista del Gremio:");
        for (int i = 0; i < contador; i++) {
            System.out.println((i + 1) + ". Nombre: " + nombres[i] + " | Rango: " + rangos[i]);
        }
    }

    // Método para buscar miembro
    public void buscar(String nombre) {
        boolean encontrado = false;

        for (int i = 0; i < contador; i++) {
            if (nombres[i].equalsIgnoreCase(nombre)) {
                System.out.println("🔍 Encontrado: " + nombres[i] + " | Rango: " + rangos[i]);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("❌ Miembro no encontrado.");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Gremio gremio = new Gremio(5); // Capacidad máxima

        int opcion;

        do {
            System.out.println("\n=== AGENDA DEL GREMIO ===");
            System.out.println("1. Agregar miembro");
            System.out.println("2. Listar miembros");
            System.out.println("3. Buscar miembro");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese rango (número): ");
                    int rango = sc.nextInt();

                    gremio.agregar(nombre, rango);
                    break;

                case 2:
                    gremio.listar();
                    break;

                case 3:
                    System.out.print("Ingrese nombre a buscar: ");
                    String buscar = sc.nextLine();
                    gremio.buscar(buscar);
                    break;

                case 4:
                    System.out.println("👋 Saliendo del sistema...");
                    break;

                default:
                    System.out.println("❌ Opción inválida.");
            }

        } while (opcion != 4);

        sc.close();
    }
}
