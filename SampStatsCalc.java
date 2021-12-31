/*
Simple Statistics Calculator: A Java Program Final Output
In Partial Fulfillment of the Requirements of the Course CC 11.0

Submitted by:
    Christian Carlo O. Galarita
    Clint Harvey C. Gamolo
    Adriane Troy V. Roa

January 2022
*/

//importing needed java packages and classes
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

//declaring class that implements ActionLister and KeyListener
public class SampStatsCalc implements ActionListener, KeyListener{

    //declaring objects
    JFrame frame;
    JLabel meanLabel, mdLabel, moLabel, rLabel, sLabel, vLabel;
    JLabel inLabel;
    JTextField textFieldA, meanField, mdField, moField;
    JTextField rField, sField, vField;
    JTextArea textFieldB;
    JButton enButton, eqButton, clButton;
    Dimension size;

    //declaring and initializing Arraylist object and Font objects
    ArrayList<Double> numb = new ArrayList<Double>();
    Font myFont = new Font("Consolas", Font.BOLD, 14);
    Font inFont = new Font("Consolas", Font.ITALIC, 12);

    //defining constructor
    SampStatsCalc() {

        //initializing JTextField object
        frame = new JFrame("Simple Sample Calculator (FINAL OUTPUT)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(339,440);
        frame.setLayout(null);
        frame.setResizable(false);

        //initializing JTextField object
        textFieldA = new JTextField();
        textFieldA.setFont(myFont);
        textFieldA.setBounds(15, 25, 300, 25);
        textFieldA.setEditable(false);
        textFieldA.addKeyListener(this);
        textFieldA.getCaret().setVisible(true);
        
        //initializing JTextArea object
        textFieldB = new JTextArea();
        textFieldB.setLineWrap(true);
        textFieldB.setFont(myFont);
        textFieldB.setEditable(false);
        textFieldB.setBounds(15, 128, 300, 60);

        //initializing JButton object
        enButton = new JButton("Add");
        enButton.addActionListener(this);
        enButton.setFont(myFont);
        enButton.setFocusable(false);

        //initializing JButton object
        eqButton = new JButton("Calculate");
        eqButton.addActionListener(this);
        eqButton.setFont(myFont);
        eqButton.setFocusable(false);

        //initializing JButton object
        clButton = new JButton("Clear");
        clButton.addActionListener(this);
        clButton.setFont(myFont);
        clButton.setFocusable(false);

        //initializing button dimensions
        clButton.setBounds(15, 60, 145, 30);
        enButton.setBounds(170, 60, 145, 30);
        eqButton.setBounds(15, 95, 300, 30);

        //initializing JTextField object
        meanField = new JTextField();
        meanField.setFont(myFont);
        meanField.setEditable(false);
        meanField.setBounds(165, 200, 152, 20);

        //initializing JLabel object
        meanLabel = new JLabel("Mean");
        meanLabel.setFont(myFont);
        size = meanLabel.getPreferredSize();
        meanLabel.setBounds(15, 202, size.width, size.height);

        //initializing JTextField object
        mdField = new JTextField();
        mdField.setFont(myFont);
        mdField.setEditable(false);
        mdField.setBounds(165, 230, 152, 20);

        //initializing JLabel object
        mdLabel = new JLabel("Median");
        mdLabel.setFont(myFont);
        size = mdLabel.getPreferredSize();
        mdLabel.setBounds(15, 232, size.width, size.height);

        //initializing JTextField object
        moField = new JTextField();
        moField.setFont(myFont);
        moField.setEditable(false);
        moField.setBounds(165, 260, 152, 20);

        //initializing JLabel object
        moLabel = new JLabel("Mode");
        moLabel.setFont(myFont);
        size = moLabel.getPreferredSize();
        moLabel.setBounds(15, 262, size.width, size.height);

        //initializing JTextField object
        rField = new JTextField();
        rField.setFont(myFont);
        rField.setEditable(false);
        rField.setBounds(165, 290, 152, 20);

        //initializing JLabel object
        rLabel = new JLabel("Range");
        rLabel.setFont(myFont);
        size = rLabel.getPreferredSize();
        rLabel.setBounds(15, 292, size.width, size.height);

        //initializing JTextField object
        sField = new JTextField();
        sField.setFont(myFont);
        sField.setEditable(false);
        sField.setBounds(165, 320, 152, 20);

        //initializing JLabel object
        sLabel = new JLabel("Standard Deviation");
        sLabel.setFont(myFont);
        size = sLabel.getPreferredSize();
        sLabel.setBounds(15, 322, size.width, size.height);

        //initializing JTextField object
        vField = new JTextField();
        vField.setFont(myFont);
        vField.setEditable(false);
        vField.setBounds(165, 350, 152, 20);

        //initializing JLabel object
        vLabel = new JLabel("Variance");
        vLabel.setFont(myFont);
        size = rLabel.getPreferredSize();
        vLabel.setBounds(15, 352, 100, size.height);

        //initializing JLabel object
        inLabel = new JLabel("SPACE key for Add | ENTER key for Calculate");
        inLabel.setFont(inFont);
        size = inLabel.getPreferredSize();
        inLabel.setBounds(15, 392, size.width, size.height);

        //adding initialized objects to the JFrame object
        frame.add(enButton);
        frame.add(eqButton);
        frame.add(clButton);
        frame.add(meanField);
        frame.add(meanLabel);
        frame.add(mdField);
        frame.add(mdLabel);
        frame.add(moField);
        frame.add(moLabel);
        frame.add(rField);
        frame.add(rLabel);
        frame.add(sField);
        frame.add(sLabel);
        frame.add(vField);
        frame.add(vLabel);
        frame.add(textFieldA);
        frame.add(textFieldB);
        frame.add(inLabel);

        //setting visibility of frame to appear
        frame.setVisible(true);

    }
    /*
     Section for statistical operations.
     Decimal answers are limited to four decimal places only
     which explains the usage of Math.round() method together
     with the figure 10000. However, operations with no intricate
     calculations are not given this configuration.
     */

    //method for mean operation
    double mean() {
        double sum = 0.0;

        //for loop to add all double values and assigning the result
        //to sum
        for(double el: numb)
            sum+=el;

        //average is given the value of the final mean operation
        double average = sum/numb.size();
        return (double) Math.round(average*10000)/10000; 
    }

    //method for median operation
    double median() {

        //assigns the half of the integer size of the arraylist
        int placement=numb.size()/2;

        //sorts the arraylist elements ascendingly
        Collections.sort(numb);

        //condition to check if odd or even arraylist size
        if(numb.size()%2!=0)
            return numb.get(placement);
        return (numb.get(placement-1)+numb.get(placement))/2;
    }

    //method for mode operation
    void mode() {

        //declaring and initializing arraylist objects for mode
        //and copy of numb arraylist
        ArrayList<Double> mode=new ArrayList<Double>();
        ArrayList<Double> cloneNumb=new ArrayList<Double>();

        //declaring and initializing variable to handle the highest
        //number of appearance
        short appearance = 0;

        //loop to check the mode in the arraylist
        for(double el: numb){

            //declaring and initializing variable for an element's
            //appearance
            short inAppear = 0;

            //loop with conditions to check the element with highest
            //occurence in the arraylist
            for(double inEl: numb){
                if(el==inEl)
                    inAppear++;
                if(inAppear>appearance){
                    mode.clear();
                    appearance=inAppear;
                    mode.add(el);
                }
                else if(inAppear==appearance && !(mode.contains(el)))
                    mode.add(el);
            }

            //condition to copy numb arraylist's elements once
            if(!(cloneNumb.contains(el)))
                cloneNumb.add(el);
        }

        //loop with conditions in printing the answer/s
        for(double i: mode){
            if(i%1!=0 && i!=0.0)
                moField.setText(moField.getText().concat(String.valueOf(i)).concat(" "));
            else
                moField.setText(moField.getText().concat(String.valueOf((int) i)).concat(" "));
        }

        //condition to check if there is no mode
        if(mode.size()==0 || mode.equals(cloneNumb)){
            mode.clear();
            moField.setText("None");
        }
    }

    //method for range operation
    double range() {

        //sorts the list to know the maximum and minimum elements
        //such elements are then checked of their difference
        Collections.sort(numb);
        double max = numb.get(numb.size()-1);
        double min = numb.get(0);
        double diff = max - min;

        return (double) Math.round(diff*10000)/10000;
    }

    //method for standard deviation operation
    double standardDev() {
        double sumSq = 0.0;

        //loop for the operation in the numerator/dividend 
        //of the formula
        for(double el: numb){
            double squared = (double) Math.round((el-mean())*10000)/10000;
            squared=squared*squared;
            sumSq+=squared;
        }

        //variable to handle the result of the inside division
        double quo = sumSq/(numb.size()-1);

        //returns the square root of the result
        return (double) Math.round(Math.sqrt(quo)*10000)/10000;
    }

    //method for variance operation
    // same as standard deviation but without the square root operation
    double variance() {
        double sumSq = 0.0;
        for(double el: numb){
            double squared = (double) Math.round((el-mean())*10000)/10000;
            squared=squared*squared;
            sumSq+=squared;
        }
        double quo = sumSq/(numb.size()-1);
        return (double) Math.round(quo*10000)/10000;
    }

    //main method with object declaration and initialization
    //in order for the program to run
    public static void main(String[] args){
        
        SampStatsCalc stat = new SampStatsCalc();
   
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
       //unused 
    }

    //static method of KeyEvent to limit keys entered in keyboard
    //and give functions to chosen keys
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        //if user presses space, input is added to arraylist
        if(keyCode == KeyEvent.VK_SPACE){
            String given = textFieldA.getText();
            char[] figure = given.toCharArray();
            for(char i: figure){
                if(i=='.'){
                    given.concat("0");
                    break;
                }
            }
            numb.add(Double.parseDouble(given));
            textFieldA.setText("");
            textFieldB.setText("");
            meanField.setText("");
            mdField.setText("");
            moField.setText("");
            rField.setText("");
            sField.setText("");
            rField.setText("");
            vField.setText("");
            for(double i: numb){
                if(i%1==0)
                    textFieldB.setText(textFieldB.getText().concat(String.valueOf((int) i))+" ");
                else
                    textFieldB.setText(textFieldB.getText().concat(String.valueOf(i))+" ");
            }
        }
        //if user presses enter, if there is input not yet added,
        //it adds it, then proceeds to display the answers to
        //all statistic
        if(keyCode == KeyEvent.VK_ENTER){
            String given = textFieldA.getText();
            if(!(given.equals(""))){
                char[] figure = given.toCharArray();
                for(char i: figure){
                    if(i=='.'){
                        given.concat("0");
                        break;
                    }
                }
                numb.add(Double.parseDouble(given));
                textFieldA.setText("");
                textFieldB.setText("");
                meanField.setText("");
                mdField.setText("");
                moField.setText("");
                rField.setText("");
                sField.setText("");
                rField.setText("");
                vField.setText("");
                for(double i: numb){
                    if(i%1==0)
                        textFieldB.setText(textFieldB.getText().concat(String.valueOf((int) i))+" ");
                    else
                        textFieldB.setText(textFieldB.getText().concat(String.valueOf(i))+" ");
                }
            }

            if(mean()%1!=0)
                meanField.setText(String.valueOf(mean()));
            else if(mean() == 0)
                meanField.setText("");
            else
                meanField.setText(String.valueOf((int) mean()));
            if(median()%1!=0)
                mdField.setText(String.valueOf(median()));
            else
                mdField.setText(String.valueOf((int) median()));
            mode();
            if(range()%1!=0)
                rField.setText(String.valueOf(range()));
            else
                rField.setText(String.valueOf((int) range()));
            if(standardDev()%1!=0)
                sField.setText(String.valueOf(standardDev()));
            else
                sField.setText(String.valueOf((int) standardDev()));
            if(variance()%1!=0)
                vField.setText(String.valueOf(variance()));
            else
                vField.setText(String.valueOf((int) variance()));

            //clears the arraylist and input field after display of results
            //to ready for next set of inputs
            numb.clear();
            textFieldA.setText("");
        }

        /* 
         This section comprises of configurations to only
         limit accepted inputs to numbers and decimal point
         only.
         */
        if(keyCode == KeyEvent.VK_0 || keyCode == KeyEvent.VK_NUMPAD0) {
            textFieldA.setText(textFieldA.getText().concat("0"));
        }
        if(keyCode == KeyEvent.VK_1 || keyCode == KeyEvent.VK_NUMPAD1) {
            textFieldA.setText(textFieldA.getText().concat("1"));
        }
        if(keyCode == KeyEvent.VK_2 || keyCode == KeyEvent.VK_NUMPAD2) {
            textFieldA.setText(textFieldA.getText().concat("2"));
        }
        if(keyCode == KeyEvent.VK_3 || keyCode == KeyEvent.VK_NUMPAD3) {
            textFieldA.setText(textFieldA.getText().concat("3"));
        }
        if(keyCode == KeyEvent.VK_4 || keyCode == KeyEvent.VK_NUMPAD4) {
            textFieldA.setText(textFieldA.getText().concat("4"));
        }
        if(keyCode == KeyEvent.VK_5 || keyCode == KeyEvent.VK_NUMPAD5) {
            textFieldA.setText(textFieldA.getText().concat("5"));
        }
        if(keyCode == KeyEvent.VK_6 || keyCode == KeyEvent.VK_NUMPAD6) {
            textFieldA.setText(textFieldA.getText().concat("6"));
        }
        if(keyCode == KeyEvent.VK_7 || keyCode == KeyEvent.VK_NUMPAD7) {
            textFieldA.setText(textFieldA.getText().concat("7"));
        }
        if(keyCode == KeyEvent.VK_8 || keyCode == KeyEvent.VK_NUMPAD8) {
            textFieldA.setText(textFieldA.getText().concat("8"));
        }
        if(keyCode == KeyEvent.VK_9 || keyCode == KeyEvent.VK_NUMPAD9) {
            textFieldA.setText(textFieldA.getText().concat("9"));
        }
        if(keyCode == KeyEvent.VK_PERIOD || keyCode == KeyEvent.VK_DECIMAL) {
            boolean check = true;
            for(char i: textFieldA.getText().toCharArray()){
                if(i == '.')
                    check = false;
            }
            if(check)
                textFieldA.setText(textFieldA.getText().concat("."));
        }

        //condition to enable use of BACKSPACE to erase characters
        if(keyCode == KeyEvent.VK_BACK_SPACE){
            ArrayList<Character> given = new ArrayList<Character>();
            for(char i:textFieldA.getText().toCharArray())
                given.add(i);
            given.remove(given.size()-1);

            textFieldA.setText("");

            for(char i: given)
                textFieldA.setText(textFieldA.getText().concat(String.valueOf(i)));
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        //unused

    }

    //static method of ActionListener to assign functions of each button
    @Override
    public void actionPerformed(ActionEvent e){

        //if user clicks on add button, the same instructions as SPACE
        //will execute
        if(e.getSource() == enButton){
            String given = textFieldA.getText();
            char[] figure = given.toCharArray();
            for(char i: figure){
                if(i=='.'){
                    given.concat("0");
                    break;
                }
            }
            numb.add(Double.parseDouble(given));
            textFieldA.setText("");
            textFieldB.setText("");
            meanField.setText("");
            mdField.setText("");
            moField.setText("");
            rField.setText("");
            sField.setText("");
            rField.setText("");
            vField.setText("");
            for(double i: numb){
                if(i%1==0)
                    textFieldB.setText(textFieldB.getText().concat(String.valueOf((int) i))+" ");
                else
                    textFieldB.setText(textFieldB.getText().concat(String.valueOf(i))+" ");
            }
        }

        //if user clicks CLEAR button, all contents in arraylist and all
        //fields will be wiped out
        if(e.getSource() == clButton){
            numb.clear();
            textFieldA.setText("");
            textFieldB.setText("");
            meanField.setText("");
            mdField.setText("");
            moField.setText("");
            rField.setText("");
            sField.setText("");
            rField.setText("");
            vField.setText("");
        }

        //if user clicks on calculate button, the same instructions as ENTER
        //will execute
        if(e.getSource() == eqButton){
            String given = textFieldA.getText();
            char[] figure = given.toCharArray();
            for(char i: figure){
                if(i=='.'){
                    given.concat("0");
                    break;
                }
            }
            numb.add(Double.parseDouble(given));
            textFieldA.setText("");
            textFieldB.setText("");
            meanField.setText("");
            mdField.setText("");
            moField.setText("");
            rField.setText("");
            sField.setText("");
            rField.setText("");
            vField.setText("");
            for(double i: numb){
                if(i%1==0)
                    textFieldB.setText(textFieldB.getText().concat(String.valueOf((int) i))+" ");
                else
                    textFieldB.setText(textFieldB.getText().concat(String.valueOf(i))+" ");
            }

            if(mean()%1!=0)
                meanField.setText(String.valueOf(mean()));
            else if(mean() == 0)
                meanField.setText("");
            else
                meanField.setText(String.valueOf((int) mean()));
            if(median()%1!=0)
                mdField.setText(String.valueOf(median()));
            else
                mdField.setText(String.valueOf((int) median()));
            mode();
            if(range()%1!=0)
                rField.setText(String.valueOf(range()));
            else
                rField.setText(String.valueOf((int) range()));
            if(standardDev()%1!=0)
                sField.setText(String.valueOf(standardDev()));
            else
                sField.setText(String.valueOf((int) standardDev()));
            if(variance()%1!=0)
                vField.setText(String.valueOf(variance()));
            else
                vField.setText(String.valueOf((int) variance()));

            //clears the arraylist and input field after display of results
            //to ready for next set of inputs
            numb.clear();
            textFieldA.setText("");
        } 
    }
}
