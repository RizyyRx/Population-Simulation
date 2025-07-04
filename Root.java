package sim;

public class Root {
    String gender;
    String name;

    public Root(String gender, String name){
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
