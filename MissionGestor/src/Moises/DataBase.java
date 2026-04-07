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
        duplicateId(id);
        missions.add(mission);
    }

    public String duplicateId(int id){
        for(int i = 0; i < missions.size(); i++){
            if(missions.get(i).getId() == id){
                return "Suplicado";
            }
        }
        return "Sin duplicado";
    }

    public void getAll(){ //Listar las misiones existentes.
        for(int i = 0; i < missions.size(); i++){
            System.out.println(missions.get(i));
        }
    }

    public Mission getByIndex(int i){ //Cosneguir mission por indice.
        if(i < 0 || i > missions.size()){
            System.out.println("Indice fuera de rango");
        }
        return missions.get(i); 
    }

    public int getListSize(){ //Conseguir el tamaño del ArrayList.
        return missions.size();
    }
}
        

    

