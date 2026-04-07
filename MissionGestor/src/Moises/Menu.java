
public class Menu {
    private int userOption;
    
    public Menu(){

    }

    public Menu(int userOption){
        this.userOption = userOption;
    }

    // setters y getters
    public int getUserOption(){
        return userOption;
    }

    public void setUserOption(int userOption){
        this.userOption = userOption - 1;
    } 
    
}
