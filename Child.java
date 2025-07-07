package sim;
import java.util.List;

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

    public static void displayAllChilds( List<Child> maleChilds,  List<Child> femaleChilds){
        System.out.println("Male childs list:");
        for(int i=0; i<maleChilds.size();i++){
            System.out.println("Male child name: "+maleChilds.get(i).getName());
        }

        System.out.println("Female childs list:");
        for(int i=0; i<femaleChilds.size();i++){
            System.out.println("Female child name: "+femaleChilds.get(i).getName());
        }
    }
}
