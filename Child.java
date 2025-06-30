package sim;
import sim.ManWoman;

public class Child {
    String gender;
    String name;

    public Child(String gender, String name){
        this.gender = gender;
        this.name = name;
    }

    //getters
    public String getGender(){
        return this.gender;
    }

    public String getName(){
        return this.name;
    }
}
