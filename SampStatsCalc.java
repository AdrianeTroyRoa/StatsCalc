import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class SampStatsCalc implements ActionListener, KeyListener{
    JFrame frame;
    JLabel meanLabel, mdLabel, moLabel, rLabel, sLabel, vLabel;
    JTextField textFieldA, meanField, mdField, moField;
    JTextField rField, sField, vField;
    JTextArea textFieldB;
    JButton enButton, eqButton, clButton;
    JPanel panel;
    Dimension size;

    ArrayList<Double> numb = new ArrayList<Double>();
    Font myFont = new Font("Roboto", Font.BOLD, 14);

    SampStatsCalc() {
        frame = new JFrame("Simple Sample Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(336,440);
        frame.setLayout(null);
        frame.setResizable(false);

        textFieldA = new JTextField();
        textFieldA.setFont(myFont);
        textFieldA.setBounds(15, 25, 300, 25);
        textFieldA.addKeyListener(this);
        
        textFieldB = new JTextArea();
        textFieldB.setLineWrap(true);
        textFieldB.setFont(myFont);
        textFieldB.setEditable(false);
        textFieldB.setBounds(15, 128, 300, 60);

        enButton = new JButton("Add");
        enButton.addActionListener(this);
        enButton.setFont(myFont);
        enButton.setFocusable(false);

        eqButton = new JButton("Calculate");
        eqButton.addActionListener(this);
        eqButton.setFont(myFont);
        eqButton.setFocusable(false);

        clButton = new JButton("Clear");
        clButton.addActionListener(this);
        clButton.setFont(myFont);
        clButton.setFocusable(false);

        clButton.setBounds(15, 60, 145, 30);
        enButton.setBounds(170, 60, 145, 30);
        eqButton.setBounds(15, 95, 300, 30);

        meanField = new JTextField();
        meanField.setFont(myFont);
        meanField.setEditable(false);
        meanField.setBounds(145, 200, 172, 20);

        meanLabel = new JLabel("Mean");
        meanLabel.setFont(myFont);
        size = meanLabel.getPreferredSize();
        meanLabel.setBounds(15, 202, size.width, size.height);

        mdField = new JTextField();
        mdField.setFont(myFont);
        mdField.setEditable(false);
        mdField.setBounds(145, 230, 172, 20);

        mdLabel = new JLabel("Median");
        mdLabel.setFont(myFont);
        size = mdLabel.getPreferredSize();
        mdLabel.setBounds(15, 232, size.width, size.height);

        moField = new JTextField();
        moField.setFont(myFont);
        moField.setEditable(false);
        moField.setBounds(145, 260, 172, 20);

        moLabel = new JLabel("Mode");
        moLabel.setFont(myFont);
        size = moLabel.getPreferredSize();
        moLabel.setBounds(15, 262, size.width, size.height);

        rField = new JTextField();
        rField.setFont(myFont);
        rField.setEditable(false);
        rField.setBounds(145, 290, 172, 20);

        rLabel = new JLabel("Range");
        rLabel.setFont(myFont);
        size = rLabel.getPreferredSize();
        rLabel.setBounds(15, 292, size.width, size.height);

        sField = new JTextField();
        sField.setFont(myFont);
        sField.setEditable(false);
        sField.setBounds(145, 320, 172, 20);

        sLabel = new JLabel("Standard Deviation");
        sLabel.setFont(myFont);
        size = sLabel.getPreferredSize();
        sLabel.setBounds(15, 322, size.width, size.height);

        vField = new JTextField();
        vField.setFont(myFont);
        vField.setEditable(false);
        vField.setBounds(145, 350, 172, 20);

        vLabel = new JLabel("Variance");
        vLabel.setFont(myFont);
        size = rLabel.getPreferredSize();
        vLabel.setBounds(15, 352, 100, size.height);

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
        frame.setVisible(true);

    }

    double mean() {
        double sum = 0.0;
        for(double el: numb)
            sum+=el;
        double average = sum/numb.size();
        ArrayList<Character> ans = new ArrayList<Character>();
        for(char i: String.valueOf(average).toCharArray())
            ans.add(i);
        if(ans.indexOf('.') < ans.indexOf('9'))
            average = (double) Math.round(average*10)/10;
        return average;
    }

    double median() {
        int placement=numb.size()/2;
        if(numb.size()%2!=0)
            return numb.get(placement);
        else
            return (numb.get(placement-1)+numb.get(placement))/2;
    }

    double mode() {
        double mode = 0.0;
        short appearance = 1;
        for(double el: numb){
            short inAppear = 0;
            for(double inEl: numb){
                if(el==inEl)
                    inAppear++;
                if(inAppear>appearance){
                    appearance=inAppear;
                    mode=el;
                }
            }
        }
        return mode;
    }

    double range() {
        Collections.sort(numb);
        double max = numb.get(numb.size()-1);
        double min = numb.get(0);
        double diff = max - min;
        ArrayList<Character> ans = new ArrayList<Character>();
        for(char i: String.valueOf(diff).toCharArray())
            ans.add(i);
        if(ans.indexOf('.') < ans.indexOf('9'))
            diff = (double) Math.round(diff*10)/10;
        return diff;
    }

    double standardDev() {
        double sumSq = 0.0;
        for(double el: numb){
            double squared = el-mean();
            squared=squared*squared;
            sumSq+=squared;
        }
        double quo = sumSq/(numb.size()-1);
        return Math.sqrt(quo);
    }

    double variance() {
        double sumSq = 0.0;
        for(double el: numb){
            double squared = el-mean();
            squared=squared*squared;
            sumSq+=squared;
        }
        double quo = sumSq/(numb.size()-1);
        return quo;
    }

    public static void main(String[] args){
        
        SampStatsCalc stat = new SampStatsCalc();
   
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
       //unused 
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
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
            for(double i: numb){
                if(i%1==0)
                    textFieldB.setText(textFieldB.getText().concat(String.valueOf((int) i))+" ");
                else
                    textFieldB.setText(textFieldB.getText().concat(String.valueOf(i))+" ");
            }
        }
        if(keyCode == KeyEvent.VK_ENTER){
            if(mean()%1!=0)
                meanField.setText(String.valueOf(mean()));
            else
                meanField.setText(String.valueOf((int) mean()));
            if(median()%1!=0)
                mdField.setText(String.valueOf(median()));
            else
                mdField.setText(String.valueOf((int) median()));
            if(mode()%1!=0 && mode()!=0.0)
                moField.setText(String.valueOf(mode()));
            else if(mode()==0.0)
                moField.setText("None");
            else
                moField.setText(String.valueOf((int) mode()));
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
            numb.clear();
            textFieldA.setText("");
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        //unused

    }

    @Override
    public void actionPerformed(ActionEvent e){
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
            for(double i: numb){
                if(i%1==0)
                    textFieldB.setText(textFieldB.getText().concat(String.valueOf((int) i))+" ");
                else
                    textFieldB.setText(textFieldB.getText().concat(String.valueOf(i))+" ");
            }
        }
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
        }
        if(e.getSource() == eqButton){
            if(mean()%1!=0)
                meanField.setText(String.valueOf(mean()));
            else
                meanField.setText(String.valueOf((int) mean()));
            if(median()%1!=0)
                mdField.setText(String.valueOf(median()));
            else
                mdField.setText(String.valueOf((int) median()));
            if(mode()%1!=0 && mode()!=0.0)
                moField.setText(String.valueOf(mode()));
            else if(mode()==0.0)
                moField.setText("None");
            else
                moField.setText(String.valueOf((int) mode()));
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
            numb.clear();
            textFieldA.setText("");
        } 
    }
}
