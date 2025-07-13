package sim;
import java.util.*;
import sim.Parent;
import sim.Child;
import sim.Sex;


public class Main {

    static int maleCounter = 0;
    static int femaleCounter = 0;
    static List<Child> maleChilds = new ArrayList<>();
    static List<Child> femaleChilds = new ArrayList<>();

    public static void main(String[] args){

        // User input for no of Root couples
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter no of Root couples to begin with: ");
        int rootNum = sc.nextInt();
        System.out.println("Enter child birth range:");
        System.out.print("Min Range:");
        int minChildRange = sc.nextInt();
        System.out.print("Max Range:");
        int maxChildRange = sc.nextInt();
        System.out.print("Enter generation count:");
        int generationCount = sc.nextInt();
        System.out.println();

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
        System.out.println();

        //CHANGE ROOTS TO PARENTS AND PROCESS 1ST GENERATION
        // assign random sex sessions
        Random rand = new Random();

        // do till available list is not empty
        while(!availableMaleRoots.isEmpty() && !availableFemaleRoots.isEmpty()){

            int randMaleNum = rand.nextInt(availableMaleRoots.size());
            int randFemaleNum = rand.nextInt(availableFemaleRoots.size());
            // System.out.println("Random male index is "+randMaleNum);
            // System.out.println("Random female index is "+randFemaleNum);

            // pick a random man and woman from the list and convert them into parents
            Root rMan = availableMaleRoots.get(randMaleNum);
            Root rWoman = availableFemaleRoots.get(randFemaleNum);
            
            Parent pMan = new Parent(rMan.getGender(), rMan.getName());
            Parent pWoman = new Parent(rWoman.getGender(), rWoman.getName());
            
            // create sex session
            Sex sexSession = new Sex();
            boolean result = sexSession.sex(pMan, pWoman,minChildRange,maxChildRange);

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
        Child.displayAllChilds(maleChilds, femaleChilds);
        System.out.println();

        //LOOP N GENERATIONS, CONVERT CHILDS TO PARENTS AND PROCESS NEXT GENERATIONS
        System.out.println("Next Generations starting....");
        System.out.println("No of generations to be created: "+generationCount);
        System.out.println();


        List<Child> tempMaleChilds = new ArrayList<>();
        List<Child> tempFemaleChilds = new ArrayList<>();
        
        for(int i=0; i<generationCount;i++){

            // Add childs to temp list
            tempMaleChilds.addAll(maleChilds);
            tempFemaleChilds.addAll(femaleChilds);
            System.out.println("----------------");
            System.out.println("Gen count: "+(i+1));
            System.out.println("----------------");
            System.out.println();

            // do till available list is not empty. (Using AND condition since both list will not have equal num of objs)
            if(!tempMaleChilds.isEmpty()){
                if(!tempFemaleChilds.isEmpty()){
                    int randMaleChildNum = rand.nextInt(tempMaleChilds.size());
                    int randFemaleChildNum = rand.nextInt(tempFemaleChilds.size());
                    // System.out.println("Random male child index is "+randMaleChildNum);
                    // System.out.println("Random female child index is "+randFemaleChildNum);

                    // pick a random male child and female child from the temp chid list and convert them into parents
                    Child cMan = tempMaleChilds.get(randMaleChildNum);
                    Child cWoman = tempFemaleChilds.get(randFemaleChildNum);
                    
                    Parent pMan = new Parent(cMan.getGender(), cMan.getName());
                    Parent pWoman = new Parent(cWoman.getGender(), cWoman.getName());
                    
                    // create sex session
                    Sex sexSession = new Sex();
                    boolean result = sexSession.sex(pMan, pWoman,minChildRange,maxChildRange);

                    // if sex is successful
                    if(result){
                        // remove from child list
                        maleChilds.remove(cMan);
                        femaleChilds.remove(cWoman);

                        // remove from temp child list
                        tempMaleChilds.remove(cMan);
                        tempFemaleChilds.remove(cWoman);

                        // add to parents list
                        maleParents.add(pMan);
                        femaleParents.add(pWoman);
                    }
                } else{
                    System.out.println("No female left for reproduction");
                    break;
                }
            } else{
                    System.out.println("No male left for reproduction");
                    break;
                }
        }

        System.out.println("---------------------------------------------------");
        Parent.displayAllParents(maleParents, femaleParents);
        System.out.println("---------------------------------------------------");
        Child.displayAllChilds(maleChilds, femaleChilds);
        System.out.println("---------------------------------------------------");
    }    
}
