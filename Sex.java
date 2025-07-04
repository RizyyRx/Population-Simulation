package sim;
import sim.Parent;
import sim.Child;
import java.util.Random;

// creates child obj with male and female
public class Sex {
    public boolean sex(Parent male, Parent female){
        System.out.println(male.getName()+" and "+female.getName()+" are having sex");

        // pick random gender
        Random rand = new Random();
        int num = rand.nextInt(2);
        String gender = null;
        String name = null;
        Child child = null;

        if(num == 0){
            gender = "male";
            name = "male"+Main.maleCounter;

            //create child obj also with father and mother obj
            child = new Child(gender, name, male, female);
            Main.maleCounter++;
        } else if(num == 1){
            gender = "female";
            name = "female"+Main.femaleCounter;

            //create child obj also with father and mother obj
            child = new Child(gender, name, male, female);
            Main.femaleCounter++;
        } else{
            System.out.println("provide correct number");
            return false;
        }

        System.out.println("Child born with following stats:");
        System.out.println("Gender: "+child.getGender()+", Name: "+child.getName()+", Father's name: "+child.getFatherName()+", Mother's name: "+child.getMotherName());

        return true;

    }
}
