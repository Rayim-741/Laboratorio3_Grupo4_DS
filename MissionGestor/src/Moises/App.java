import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       Scanner rd = new Scanner(System.in);
        System.out.println("Id de mision: ");
        int id = rd.nextInt();
        System.out.println("Nombre: ");
        String name = rd.nextLine();
        System.out.println("Nivel de dificultad: ");
        String difficult = rd.nextLine();
        System.out.println("Estado: ");
        boolean state = rd.nextBoolean();

       Missions mision = new Missions(id, name, difficult, state);
       mision.MissionMaker();


       rd.close();
    }
}
