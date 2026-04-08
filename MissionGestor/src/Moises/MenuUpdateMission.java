public class MenuUpdateMission extends MenuLogic{
    public MenuUpdateMission(int userOption){
        super(userOption);
    }

    public static void updateMission(){
        int newID;
        String newNamesMission;
        String newDifficulty;
        boolean newState;

        System.out.println("¿Que mision desea actualizar?");
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
        
        int userUpdateOption;
        userUpdateOption = rd.nextInt();
        userUpdateOption = userUpdateOption - 1;

        switch(userUpdateOption){
            case 0:
                System.out.println("introduzca el nuevo ID: ");
                newID = rd.nextInt();
                dBase.getByIndex(menu.getUserOption()).setId(newID);
            break;
            case 1:
                rd.nextLine();
                System.out.println("Introduzca el nuevo nombre: ");
                newNamesMission = rd.nextLine();
                dBase.getByIndex(menu.getUserOption()).setMissionName(newNamesMission);
            break;
            case 2:
                rd.nextLine();
                System.out.println("Introduzca la nueva dificultad: ");
                newDifficulty = rd.nextLine();
                dBase.getByIndex(menu.getUserOption()).setDifficulty(newDifficulty);
            break;
            case 3:
                rd.nextLine();
                System.out.println("Introduzca el nuevo estado de la mision: ");
                newState = rd.nextBoolean();
                dBase.getByIndex(menu.getUserOption()).setState(newState);
            break;
        }
    }   
}
