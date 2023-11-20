
import java.util.*;

/* The following program is a simple simulation of checkout lines in a grocery store.
The lines are implemented using queues and customers are added and removed from the lines randomly.
 */



public class GroceryLines{


    public static int custNum = 1;//this int keeps track of the customer number

    //creating the Queues to put into the array
    public static Queue<String> Q1 = new LinkedList<>();
    public static Queue<String> Q2 = new LinkedList<>();
    public static Queue<String> Q3 = new LinkedList<>();
    public static Queue<String> Q4 = new LinkedList<>();
    public static Queue<String> Q5 = new LinkedList<>();

    //putting the Queues into the array
    public static Queue[] lines = {Q1, Q2, Q3, Q4, Q5};


    //simple method to print all of the queues
    public static void printLines() {
        System.out.println("Q1: " + Q1);
        System.out.println("Q2: " + Q2);
        System.out.println("Q3: " + Q3);
        System.out.println("Q4: " + Q4);
        System.out.println("Q5: " + Q5);
        System.out.println("\n");
    }

    //method to generate a customer and put them into the first available and shortest line
    public static void generateCustomer(){
        int temp = 0;

        for(int i = 0; i < lines.length-1; i++){
            if(lines[i].size() > lines[i+1].size()){
                temp = i+1;
            }
        }

        lines[temp].add("Customer #" + custNum);
        custNum++;
        System.out.println("Customer added to Queue # " + (temp+1) );
        printLines();
    }

    //method to complete a transaction and remove the customer from the correlating queue
    public static void completeTransaction(){
        int r = new Random().nextInt((4) + 1);

        if(lines[r].size() == 0){
            //do nothing
        }else {
            System.out.println("Transaction completed at Queue # " + (r + 1));
            lines[r].remove();
            printLines();
        }

    }

    //method to simulation of a busy day
    public static void busyDaySim(){
        //populating the queues with one customer each
        Q1.add("Customer #" + custNum);
        custNum++;
        Q2.add("Customer #" + custNum);
        custNum++;
        Q3.add("Customer #" + custNum);
        custNum++;
        Q4.add("Customer #" + custNum);
        custNum++;
        Q5.add("Customer #" + custNum);
        custNum++;

        printLines();





        /*this loop iterates 100 times, each time it iterates
        there is a 2/3 chance that it generates a customer
        and a 1/3 chance that a transaction is completed
         */
        for(int i = 0; i < 100; i++){
            int r = new Random().nextInt(3);

            if(r==0){
                completeTransaction();
            }else{
                generateCustomer();
            }

            //the following is used to slow down the program to a manageable pace
            //so that the user can read what is happening
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Something went wrong");
            }

        }
    }

    //method to run simulation of a slow day
    public static void slowDaySim(){
        //populating the queues with one customer each
        Q1.add("Customer #" + custNum);
        custNum++;
        Q2.add("Customer #" + custNum);
        custNum++;
        Q3.add("Customer #" + custNum);
        custNum++;
        Q4.add("Customer #" + custNum);
        custNum++;
        Q5.add("Customer #" + custNum);
        custNum++;

        printLines();





        /*this loop iterates 100 times, each time it iterates
        there is a 1/3 chance that it generates a customer
        and a 2/3 chance that a transaction is completed
         */
        for(int i = 0; i < 100; i++){
            int r = new Random().nextInt(3);

            if(r==0){
                generateCustomer();
            }else{
                completeTransaction();
            }

            //the following is used to slow down the program to a manageable pace
            //so that the user can read what is happening
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Something went wrong");
            }

        }
    }

    //method to run simulation of an average day
    public static void averageDaySim(){
        //populating the queues with one customer each
        Q1.add("Customer #" + custNum);
        custNum++;
        Q2.add("Customer #" + custNum);
        custNum++;
        Q3.add("Customer #" + custNum);
        custNum++;
        Q4.add("Customer #" + custNum);
        custNum++;
        Q5.add("Customer #" + custNum);
        custNum++;

        printLines();




        /*this loop iterates 100 times, each time it iterates
        there is a 50% chance that it generates a customer
        and a 50% chance that a transaction is completed
         */
        for(int i = 0; i < 100; i++){
            int r = new Random().nextInt(2);

            if(r==0){
                generateCustomer();
            }else{
                completeTransaction();
            }

            //the following is used to slow down the program to a manageable pace
            //so that the user can read what is happening
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Something went wrong");
            }

        }
    }



    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int userChoice;

        System.out.println("\n*******************************************************************");
        System.out.println("Would you like to simulate a store on a busy, average, or slow day?");
        System.out.println("*******************************************************************");
        System.out.println("Enter '1' for a busy day");
        System.out.println("Enter '2' for a average day");
        System.out.println("Enter '3' for an slow day");


        userChoice = input.nextInt();



        switch(userChoice) {
            case 1:
                System.out.println("Beginning Busy Day Simulation....");
                busyDaySim();
                break;
            case 2:
                System.out.println("Beginning Average Day Simulation....");
                averageDaySim();
                break;
            case 3:
                System.out.println("Beginning Slow Day Simulation....");
                slowDaySim();
                break;
            default:
                System.out.println("Invalid Input....");
                System.out.println("Terminating Program....");
                System.exit(0);
                break;
        }







    }
}
