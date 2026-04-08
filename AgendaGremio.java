/**
 * Clase AgendaGremio
 * Administra miembros usando arreglos fijos.
 * Operaciones: agregar, listar, buscar por nombre y buscar por rango.
 * Aplica validaciones, control de índice y recorridos con for.
 */
public class AgendaGremio {

    // Constante: capacidad máxima del arreglo (evitar desborde)
    private static final int CAPACIDAD_MAXIMA = 50;

    // Arreglos paralelos para nombres y rangos
    private String[] nombres;
    private String[] rangos;

    // También arreglo de objetos Miembro (POO)
    private Miembro[] miembros;

    // Índice que apunta al siguiente espacio libre
    private int totalMiembros;

    // Constructor
    public AgendaGremio() {
        nombres      = new String[CAPACIDAD_MAXIMA];
        rangos       = new String[CAPACIDAD_MAXIMA];
        miembros     = new Miembro[CAPACIDAD_MAXIMA];
        totalMiembros = 0;
    }

    // ─────────────────────────────────────────
    //  AGREGAR
    // ─────────────────────────────────────────
    /**
     * Agrega un nuevo miembro al gremio.
     * Valida: agenda no llena, datos no vacíos, sin duplicados.
     *
     * @param nombre Nombre del aventurero
     * @param rango  Rango dentro del gremio
     * @return true si se agregó correctamente, false en caso contrario
     */
    public boolean agregar(String nombre, String rango) {

        // Validación 1: control de desborde
        if (totalMiembros >= CAPACIDAD_MAXIMA) {
            System.out.println("[ERROR] La agenda está llena. Capacidad máxima: " + CAPACIDAD_MAXIMA);
            return false;
        }

        // Validación 2: datos no nulos ni vacíos
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("[ERROR] El nombre no puede estar vacío.");
            return false;
        }
        if (rango == null || rango.trim().isEmpty()) {
            System.out.println("[ERROR] El rango no puede estar vacío.");
            return false;
        }

        // Normalizar entradas
        nombre = nombre.trim();
        rango  = rango.trim();

        // Validación 3: evitar nombres duplicados (recorrido for)
        for (int i = 0; i < totalMiembros; i++) {
            if (nombres[i].equalsIgnoreCase(nombre)) {
                System.out.println("[ERROR] Ya existe un miembro con el nombre: " + nombre);
                return false;
            }
        }

        // Insertar en la posición actual del índice
        nombres[totalMiembros]  = nombre;
        rangos[totalMiembros]   = rango;
        miembros[totalMiembros] = new Miembro(nombre, rango);
        totalMiembros++;

        System.out.println("[OK] Miembro agregado: " + nombre + " (" + rango + ")");
        return true;
    }

    // ─────────────────────────────────────────
    //  LISTAR
    // ─────────────────────────────────────────
    /**
     * Lista todos los miembros registrados en la agenda.
     * Recorre el arreglo de objetos Miembro con un for indexado.
     */
    public void listar() {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║         AGENDA DEL GREMIO DE AVENTUREROS      ║");
        System.out.println("╠══════════════════════════════════════════════╣");

        // Validación: agenda vacía
        if (totalMiembros == 0) {
            System.out.println("║  (Sin miembros registrados)                  ║");
            System.out.println("╚══════════════════════════════════════════════╝\n");
            return;
        }

        // Recorrido for con índice explícito
        for (int i = 0; i < totalMiembros; i++) {
            System.out.printf("║ #%-3d %s%n", (i + 1), miembros[i]);
        }

        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  Total de miembros: " + totalMiembros +
                           " / " + CAPACIDAD_MAXIMA +
                           " (espacios libres: " + (CAPACIDAD_MAXIMA - totalMiembros) + ")");
        System.out.println("╚══════════════════════════════════════════════╝\n");
    }

    // ─────────────────────────────────────────
    //  BUSCAR POR NOMBRE
    // ─────────────────────────────────────────
    /**
     * Busca un miembro por nombre (sin distinguir mayúsculas).
     *
     * @param nombre Nombre a buscar
     * @return objeto Miembro si se encontró, null en caso contrario
     */
    public Miembro buscarPorNombre(String nombre) {
        System.out.println("\n[BÚSQUEDA] Buscando por nombre: \"" + nombre + "\"");

        // Validación de entrada
        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("[ERROR] El nombre de búsqueda no puede estar vacío.");
            return null;
        }

        nombre = nombre.trim();

        // Recorrido for con búsqueda lineal
        for (int i = 0; i < totalMiembros; i++) {
            if (nombres[i].equalsIgnoreCase(nombre)) {
                System.out.println("[ENCONTRADO] Posición #" + (i + 1));
                System.out.println(miembros[i]);
                return miembros[i];
            }
        }

        System.out.println("[NO ENCONTRADO] No existe un miembro llamado: " + nombre);
        return null;
    }

    // ─────────────────────────────────────────
    //  BUSCAR POR RANGO
    // ─────────────────────────────────────────
    /**
     * Busca y lista TODOS los miembros que tengan el rango indicado.
     *
     * @param rango Rango a filtrar
     * @return cantidad de miembros encontrados con ese rango
     */
    public int buscarPorRango(String rango) {
        System.out.println("\n[BÚSQUEDA] Filtrando por rango: \"" + rango + "\"");

        // Validación de entrada
        if (rango == null || rango.trim().isEmpty()) {
            System.out.println("[ERROR] El rango de búsqueda no puede estar vacío.");
            return 0;
        }

        rango = rango.trim();
        int encontrados = 0;

        System.out.println("─────────────────────────────────────────");

        // Recorrido for completo para encontrar todos los que coincidan
        for (int i = 0; i < totalMiembros; i++) {
            if (rangos[i].equalsIgnoreCase(rango)) {
                System.out.printf("  #%-3d %s%n", (i + 1), miembros[i]);
                encontrados++;
            }
        }

        System.out.println("─────────────────────────────────────────");

        if (encontrados == 0) {
            System.out.println("[NO ENCONTRADO] No hay miembros con el rango: " + rango);
        } else {
            System.out.println("[RESULTADO] " + encontrados + " miembro(s) encontrado(s) con rango \"" + rango + "\"");
        }

        return encontrados;
    }

    // ─────────────────────────────────────────
    //  GETTERS DE ESTADO
    // ─────────────────────────────────────────
    public int getTotalMiembros() {
        return totalMiembros;
    }

    public int getCapacidadMaxima() {
        return CAPACIDAD_MAXIMA;
    }

    public boolean estaLlena() {
        return totalMiembros >= CAPACIDAD_MAXIMA;
    }
}
