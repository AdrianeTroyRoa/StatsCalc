import java.util.ArrayList;

public class StatsCalc {
    
    ArrayList<Double> given = new ArrayList<Double>();

    double mean() {
        double sum=0;
        for(double el: this.given)
            sum+=el; 
        return sum/this.given.size();
    }

    double median() {
        int placement=this.given.size()/2;
        if(this.given.size()%2!=0)
            return this.given.get(placement);
        else
            return (this.given.get(placement-1)+this.given.get(placement))/2;
    }

    double mode() {
      double max = 0.0;
      short appearance = 1;
      for(double el: this.given){
          short inAppear = 0;
          for(double inEl: this.given){
              if(el==inEl)
                  inAppear++;
              if(inAppear>appearance){
                  appearance=inAppear;
                  max=el;
              }
          }
      }
      return max;
    }

    public static void main(String[] args) {
        StatsCalc cal= new StatsCalc();

        for(String in: args)
            cal.given.add(Double.parseDouble(in));

        if(cal.median()%1!=0)
            System.out.println("Median is "+cal.median());
        else
            System.out.println("Median is "+ (int) cal.median());
        if(cal.mean()%1!=0)
            System.out.println("Mean is "+cal.mean());
        else
            System.out.println("Mean is "+(int) cal.mean());
        if(cal.mode()%1!=0)
            System.out.println("Mode is "+cal.mode());
        else
            System.out.println("Mode is "+(int) cal.mode());
    }
}
