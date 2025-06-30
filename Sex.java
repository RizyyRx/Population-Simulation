package sim;
import sim.ManWoman;
import sim.Child;
import java.util.Random;

public class Sex {
    public void sex(ManWoman male, ManWoman female){
        System.out.println(male.getName()+" and "+female.getName()+" are having sex");
        int maleNum = Integer.parseInt(male.getName().substring(4));
        int femaleNum = Integer.parseInt(female.getName().substring(6));
        Random rand = new Random();
        int num = rand.nextInt(2);

        if(num == 0){
            Child child = new Child("Male","maleM"+maleNum+"F"+femaleNum);
            System.out.println("Child born with following stats:");
            System.out.println("Gender: "+child.getGender()+", Name: "+child.getName());
        } else if(num == 1){
            Child child = new Child("Female","femaleM"+maleNum+"F"+femaleNum);
            System.out.println("Child born with following stats:");
            System.out.println("Gender: "+child.getGender()+", Name: "+child.getName());
        } else{
            System.out.println("provide correct number");
        }
    }
}
