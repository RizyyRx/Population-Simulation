package sim;
import sim.Parent;
import sim.Child;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// creates child obj with male and female
public class Sex {
    public boolean sex(Parent male, Parent female, int minChildRange, int maxChildRange){
        System.out.println(male.getName()+" and "+female.getName()+" are picked");
        System.out.println();
        int childCountRange = ThreadLocalRandom.current().nextInt(minChildRange, maxChildRange+1); // max is exclusive, so add 1
        System.out.println("Child count will be "+childCountRange);
        System.out.println();

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
                Main.maleChilds.add(child);
            } else if(GenderNum == 1){
                gender = "female";
                name = "female"+Main.femaleCounter;

                //create child obj also with father and mother obj
                child = new Child(gender, name, male, female);
                Main.femaleCounter++;
                Main.femaleChilds.add(child);
            } else{
                System.out.println("provide correct number");
                return false;
            }

            System.out.println("Child born with following stats:");
            System.out.println("Gender: "+child.getGender()+", Name: "+child.getName()+", Father's name: "+child.getFatherName()+", Mother's name: "+child.getMotherName());
            System.out.println("------------------------------------------------------------------------------------------------");
            System.out.println();
        }

        return true;

    }
}
