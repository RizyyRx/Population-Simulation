package sim;
import java.util.*;
import sim.Parent;
import sim.Child;
import sim.Sex;


public class Main {

    static int maleCounter = 0;
    static int femaleCounter = 0;

    public static void main(String[] args){

        // User input for no of Root couples
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter no of Root couples to begin with: ");
        int rootNum = sc.nextInt();

        // Male and Female Roots list
        List<Root> availableMaleRoots = new ArrayList<>();
        List<Root> availableFemaleRoots = new ArrayList<>();
        List<Root> finishedMaleRoots = new ArrayList<>();
        List<Root> finishedFemaleRoots = new ArrayList<>();

        // Male and Female Parents list
        List<Parent> maleParents = new ArrayList<>();
        List<Parent> femaleParents = new ArrayList<>();

        // Roots creation
        for(int i=0;i<rootNum;i++){
            Root man = new Root("male", "male"+maleCounter);
            maleCounter++;
            availableMaleRoots.add(man);
            Root woman = new Root("female", "female"+femaleCounter);
            femaleCounter++;
            availableFemaleRoots.add(woman);
        }
        System.out.println(availableMaleRoots.size()+" Root couples are created");

        // assign random sex sessions
        Random rand = new Random();

        // do till available list is not empty
        while(!availableMaleRoots.isEmpty() && !availableFemaleRoots.isEmpty()){

            int randMaleNum = rand.nextInt(availableMaleRoots.size());
            int randFemaleNum = rand.nextInt(availableFemaleRoots.size());
            System.out.println("Random male index is "+randMaleNum);
            System.out.println("Random female index is "+randFemaleNum);

            // pick a random man and woman from the list and convert them into parents
            Root rMan = availableMaleRoots.get(randMaleNum);
            Root rWoman = availableFemaleRoots.get(randFemaleNum);
            
            Parent pMan = new Parent(rMan.getGender(), rMan.getName());
            Parent pWoman = new Parent(rWoman.getGender(), rWoman.getName());
            
            // create sex session
            Sex sexSession = new Sex();
            boolean result = sexSession.sex(pMan, pWoman);

            // if sex is successful
            if(result){
                // remove from available list
                availableMaleRoots.remove(rMan);
                availableFemaleRoots.remove(rWoman);

                // add to finished list
                finishedMaleRoots.add(rMan);
                finishedFemaleRoots.add(rWoman);

                // add to parents list
                maleParents.add(pMan);
                femaleParents.add(pWoman);
            }
        }

        Parent.displayAllParents(maleParents, femaleParents);

    }    
}
