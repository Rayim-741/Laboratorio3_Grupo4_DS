/**
 * Clase que representa un miembro del gremio.
 * Encapsula nombre y rango como atributos privados.
 */
public class Miembro {

    // Atributos privados (encapsulamiento)
    private String nombre;
    private String rango;

    // Constructor
    public Miembro(String nombre, String rango) {
        this.nombre = nombre;
        this.rango = rango;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getRango() {
        return rango;
    }

    // Setters con validación básica
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        }
    }

    public void setRango(String rango) {
        if (rango != null && !rango.trim().isEmpty()) {
            this.rango = rango.trim();
        }
    }

    // Representación en texto del miembro
    @Override
    public String toString() {
        return String.format("  %-25s | Rango: %s", nombre, rango);
    }
}
