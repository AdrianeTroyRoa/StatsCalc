//imports the ArrayList class and constructor
import java.util.ArrayList;

public class StatsCalc {
    
    //declaring object for ArrayList class
    ArrayList<Double> given = new ArrayList<Double>();

    //method for finding mean
    double mean() {
        double sum=0;

        //for loop to add all elements in ArrayList object
        for(double el: this.given)
            sum+=el; 

        //returns the mean
        return sum/this.given.size();
    }

    //method for finding median
    double median() {

        //stores the middle position
        int placement=this.given.size()/2;

        //checks if middle position is even or odd then returns appropriate value for median
        if(this.given.size()%2!=0)
            return this.given.get(placement);
        else
            return (this.given.get(placement-1)+this.given.get(placement))/2;
    }

    //method for finding mode
    double mode() {
        //sets the max/mode initially to 0.0
        double max = 0.0;

        //holds the largest appearance value intia to 1
        short appearance = 1;

        //for loop to check for mode
        for(double el: this.given){

            //holds the given element's (el) appearance value
            short inAppear = 0;

            //for loop that holds condition to check appearance value
            for(double inEl: this.given){

                //if el and inEl are equal, the el appearance value is increased by 1
                if(el==inEl)
                    inAppear++;

                //finally, checks if inAppear is greater than the previous largest appearance value
                if(inAppear>appearance){

                    //assigns the inAppear value to appearance and the present el is valued to max
                    appearance=inAppear;
                    max=el;
                }
            }
        }

        //returns the max/mode
        return max;
    }

    public static void main(String[] args) {

        //object for StatsCalc class
        StatsCalc cal= new StatsCalc();

        //for loop to assign all java arguments to given ArrayList
        for(String in: args)
            cal.given.add(Double.parseDouble(in));

        //conditions to check if the returns can be integers. if so, outputs integers.
        if(cal.median()%1!=0)
            System.out.println("Median is "+cal.median());
        else
            System.out.println("Median is "+ (int) cal.median());
        if(cal.mean()%1!=0)
            System.out.println("Mean is "+cal.mean());
        else
            System.out.println("Mean is "+(int) cal.mean());

        //special condition for mode since can be 0
        if(cal.mode()%1!=0 && cal.mode()!=0.0)
            System.out.println("Mode is "+cal.mode());
        else if(cal.mode()==0.0)
            System.out.println("Mode is None");
        else
            System.out.println("Mode is "+(int) cal.mode());
    }
}
