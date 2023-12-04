public class Customer {
    private final int customerNumber;

    private final long custStartTime = System.currentTimeMillis();
    private static long custEndTime = 0;


    public Customer(int x){
        customerNumber = x;
    }

    public static void setCustEndTime(){
        custEndTime = System.currentTimeMillis();
    }
    public long determineTotalTime(){
         return custEndTime - custStartTime;
    }
    public String toString(){
        return "Customer # " + customerNumber;
    }


}
