public class Missions {
    
    private int id;
    private String name;
    private String difficult;
    private boolean state;

    public Missions(int id, String name, String difficult, boolean state){ //Constructor
        this.id = id;
        this.name = name;
        this.difficult = difficult;
        this.state = state;
    }
    //get y set

    public void MissionMaker(){ //Lo que hacer las misiones
        System.out.println("estamos en la clase mision");

    }
}
