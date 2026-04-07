public class MenuAddMission extends MenuLogic{
    public MenuAddMission(int userOption){
        super(userOption);
    }
    
    public static void addMission(){
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
}
