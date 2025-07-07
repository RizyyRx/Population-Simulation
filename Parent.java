package sim;
import java.util.List;

public class Parent extends Root{
    Parent father;
    Parent mother;


    public Parent(String gender, String name){
        super(gender, name);
    }

    //getters
    public String getGender(){
        return this.gender;
    }

    public String getName(){
        return this.name;
    }

    public String getFatherName(){
        return this.father.getName();
    }

    public String getMotherName(){
        return this.mother.getName();
    }

    public void setFatherMother(Parent fatherObj, Parent motherObj){
        father = fatherObj;
        mother = motherObj;
    }

    public static void displayAllParents( List<Parent> maleParents,  List<Parent> femaleParents){
        System.out.println("Male parents list:");
        for(int i=0; i<maleParents.size();i++){
            System.out.println("Male parent name: "+maleParents.get(i).getName());
        }

        System.out.println("Female parents list:");
        for(int i=0; i<femaleParents.size();i++){
            System.out.println("Female parent name: "+femaleParents.get(i).getName());
        }
    }
}
