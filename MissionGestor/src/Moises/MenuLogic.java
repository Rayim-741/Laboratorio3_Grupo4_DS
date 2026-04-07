import java.util.Scanner;

public class MenuLogic extends Menu{ 
    static Scanner rd = new Scanner(System.in); 
    static DataBase dBase = new DataBase(); 
    static Menu menu = new Menu();
    
    static int userOp; 

    public MenuLogic(int userOption){
        super(userOption);
    }

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
                    MenuAddMission.addMission();
                break;

                case 1:
                    MenuUpdateMission.updateMission();
                break;

                case 2:
                    MenuListMission.listMissions();
                break;     
            }
        }while(menu.getUserOption() < 3);
    }
}



    