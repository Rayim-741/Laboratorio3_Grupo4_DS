public class MenuListMission extends MenuLogic{

    public MenuListMission(int userOption){
        super(userOption);
    }

    public static void listMissions(){
        for(int i = 0; i < dBase.getListSize(); i++ ){
            System.out.println("Mission#" + (i + 1));
            System.out.println("Id de la mision: " + dBase.getByIndex(i).getId());
            System.out.println("Nombre de la mision: " + dBase.getByIndex(i).getMissionName());
            System.out.println("Dificultad de la mision: " + dBase.getByIndex(i).getDifficulty());
            System.out.println("Estado de la mision: " + dBase.getByIndex(i).getState());
            System.out.println("\n");
        }
    }
}
