import java.util.ArrayList;
import java.util.Scanner;

public class Specimen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Double> input = new ArrayList<Double>();

        try {
            boolean initialize = true;
            while (true) {
                System.out.println("Enter data set: ");
                double dataSet = scan.nextDouble();
                input.add(dataSet);

                if (scan.equals(0)) {break;};
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid Entry!");
        }

    }
}