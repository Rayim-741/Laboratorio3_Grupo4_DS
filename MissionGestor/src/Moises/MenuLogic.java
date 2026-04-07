import java.util.Scanner;

public class MenuLogic extends Menu{ 
    //instancias---
    static Scanner rd = new Scanner(System.in); 
    static DataBase dBase = new DataBase(); 
    static Menu menu = new Menu();
    
    //Variables---
    static int userOp; //Esta variable es mejor que haga una sola cosa.

    public MenuLogic(int userOption){
        super(userOption);
    }

    public static void listMissionMenu(){
        for(int i = 0; i < dBase.getListSize(); i++ ){
            System.out.println("Mission#" + (i + 1));
            System.out.println("Id de la mision: " + dBase.getByIndex(i).getId());
            System.out.println("Nombre de la mision: " + dBase.getByIndex(i).getMissionName());
            System.out.println("Dificultad de la mision: " + dBase.getByIndex(i).getDifficulty());
            System.out.println("Estado de la mision: " + dBase.getByIndex(i).getState());
            System.out.println("\n");
        }
    }

    public static void updateMissionMenu(){
        int newID;
        String newNamesMission;
        String newDifficulty;
        boolean newState;

        System.out.println("¿Que mission desea actualizar?");
        for(int i = 0; i < dBase.getListSize(); i++){
            System.out.println("Mission#" + (i + 1));
        }

        System.out.println("\n");

        userOp = rd.nextInt();
        menu.setUserOption(userOp);

        System.out.println("¿Que parte de la mision desea actualizar?");
        System.out.println("1. ID: " + dBase.getByIndex(menu.getUserOption()).getId());
        System.out.println("2. Nombre: " + dBase.getByIndex(menu.getUserOption()).getMissionName());
        System.out.println("3. Dificultad:" + dBase.getByIndex(menu.getUserOption()).getDifficulty());
        System.out.println("4. Estado: " + dBase.getByIndex(menu.getUserOption()).getState());
        
        userOp = rd.nextInt();
        menu.setUserOption(userOp);
        rd.nextLine(); //Limpiar buffer

        switch(menu.getUserOption()){
            case 0:
                System.out.println("introduzca el nuevo ID: ");
                newID = rd.nextInt();
                dBase.getByIndex(menu.getUserOption() - 1).setId(newID);
            break;
            case 1:
                System.out.println("Introduzca el nuevo nombre: ");
                newNamesMission = rd.nextLine();
                dBase.getByIndex(menu.getUserOption() - 1).setMissionName(newNamesMission);
            break;
            case 2:
                System.out.println("Introduzca la nueva dificultad: ");
                newDifficulty = rd.nextLine();
                dBase.getByIndex(menu.getUserOption() - 1).setDifficulty(newDifficulty);
            break;
            case 3:
                System.out.println("Introduzca el nuevo estado de la mision: ");
                newState = rd.nextBoolean();
                dBase.getByIndex(menu.getUserOption() - 1).setState(newState);
            break;
        }   
    }

    public static void addMissionMenu(){
        int id;
        String missionName;     
        String difficulty;
        boolean state;
        
        System.out.println("Ingrese los parametros de la mision");
        System.out.print("id: ");
        id = rd.nextInt();
        rd.nextLine();
        System.out.print("Nombre: ");
        missionName = rd.nextLine();
        System.out.print("Dificultad: ");
        difficulty = rd.nextLine();
        System.out.print("Estado: ");
        state = rd.nextBoolean();

        dBase.addMission(id, missionName, difficulty, state);
    }

    // public static void taste(){
    //     System.out.println("Introduce el valor");
    //     int op;
    //     op = rd.nextInt();
    //     menu.setUserOption(op);
    //     System.out.println(menu.getUserOption());
    // }

    public static void showMenu(){
        do{ 
            System.out.println("\n");
            System.out.print("""
                G E S T O R  D E  M I S I O N E S
                1. Añadir mision.
                2. Modificar mision. 
                3. Listar misiones existentes.  
                4. Salir.    

                -Responter abajo-
                R: """);
        
            userOp = rd.nextInt();
            menu.setUserOption(userOp);

            System.out.println("\n");

            switch(menu.getUserOption()){
                case 0:
                    addMissionMenu();
                break;

                case 1:
                    updateMissionMenu();
                break;

                case 2:
                    listMissionMenu();
                break;

                case 3:
                     
                break;
      
     
            }
        }while(menu.getUserOption() < 4);
    }
}



    