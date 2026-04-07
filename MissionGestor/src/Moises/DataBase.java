import java.util.ArrayList;

public class DataBase{
    private ArrayList<Mission> missions = new ArrayList<>(); //Lista de misiones

    public DataBase(){

    }

    public DataBase(ArrayList<Mission> missions){
        this.missions = missions;
    }

    public void addMission(int id, String nameMission, String difficulty, boolean state){ //Metodo para añadir mission.
        Mission mission = new Mission(id, nameMission, difficulty, state);
        missions.add(mission);
    }

    public void GetAll(){ //Listar las misiones existentes.
        for(int i = 0; i < missions.size(); i++){
            System.out.println(missions.get(i));
        }
    }

    public Mission getByIndex(int i){ //Cosneguir mission por indice.
        return missions.get(i); 
    }

    public int getListSize(){ //Conseguir el tamaño del ArrayList.
        return missions.size();
    }
}
        

    

