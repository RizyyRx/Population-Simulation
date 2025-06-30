package sim;
import java.util.*;
import sim.ManWoman;
import sim.Child;
import sim.Sex;


public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i=0;i<10;i++){
            ManWoman man = new ManWoman("Male", "male"+i);
            ManWoman woman = new ManWoman("Female", "female"+i);
            System.out.println("couple "+i);
            System.out.println(man.getName());
            System.out.println(woman.getName());
            Sex operation = new Sex();
            operation.sex(man, woman);
            System.out.println("------------------------------------------");
        }
    }    
}
