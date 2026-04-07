public class Mission {
    private int id;
    private String name;
    private String difficulty;
    private boolean state;

    public Mission(){

    }

    public Mission(int id, String name, String difficulty, boolean state){
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
        this.state = state;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getMissionName(){
        return name;
    }

    public void setMissionName(String name){
        this.name = name;
    }

    public String getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(String difficulty){
        this.difficulty = difficulty;
    }

    public boolean getState(){
        return state;
    }

    public void setState(boolean state){
        this.state = state;
    }
}
