package sim;
import sim.Parent;
import sim.Child;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// creates child obj with male and female
public class Sex {
    public boolean sex(Parent male, Parent female, int min, int max){
        int childCountRange = ThreadLocalRandom.current().nextInt(min, max+1); // max is exclusive, so add 1
        System.out.println("Child count will be "+childCountRange);

        // loop for child count
        for(int i=0; i<childCountRange; i++){
            System.out.println("session "+(i+1));
            System.out.println(male.getName()+" and "+female.getName()+" are having sex");

            // pick random gender
            Random rand = new Random();
            int GenderNum = rand.nextInt(2);
            String gender = null;
            String name = null;
            Child child = null;
            

            if(GenderNum == 0){
                gender = "male";
                name = "male"+Main.maleCounter;

                //create child obj also with father and mother obj
                child = new Child(gender, name, male, female);
                Main.maleCounter++;
            } else if(GenderNum == 1){
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
        }

        return true;

    }
}
