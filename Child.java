package sim;
import sim.Parent;

public class Child extends Parent{
    String gender;
    String name;
    Parent father;
    Parent mother;

    public Child(String gender, String name, Parent father, Parent mother){
        super(gender,name);
        this.father = father;
        this.mother = mother;
    }

    public String getFatherName(){
        return this.father.getName();
    }

    public String getMotherName(){
        return this.mother.getName();
    }
}
