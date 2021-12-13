import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class SampStatsCalc implements ActionListener, KeyListener{
    JFrame frame;
    JLabel meanLabel, mdLabel, moLabel;
    JTextField textFieldA, textFieldB, meanField, mdField, moField;
    JButton enButton, eqButton, clButton;
    JPanel panel;
    Dimension size;

    ArrayList<Double> numb = new ArrayList<Double>();
    Font myFont = new Font("Arial", Font.BOLD, 14);

    SampStatsCalc() {
        frame = new JFrame("Simple Stats Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(336,440);
        frame.setLayout(null);

        textFieldA = new JTextField();
        textFieldA.setFont(myFont);
        textFieldA.setBounds(25, 25, 280, 30);
        textFieldA.addKeyListener(this);
        
        textFieldB = new JTextField();
        textFieldB.setFont(myFont);
        textFieldB.setEditable(false);
        textFieldB.setBounds(25, 60, 280, 30);

        enButton = new JButton("\u21A9");
        enButton.addActionListener(this);
        enButton.setFont(myFont);
        enButton.setFocusable(false);

        eqButton = new JButton("=");
        eqButton.addActionListener(this);
        eqButton.setFont(myFont);
        eqButton.setFocusable(false);

        clButton = new JButton("clr");
        clButton.addActionListener(this);
        clButton.setFont(myFont);
        clButton.setFocusable(false);

        enButton.setBounds(40, 100, 50, 30);
        eqButton.setBounds(100, 100, 50, 30);
        clButton.setBounds(160, 100, 80, 30);

        meanField = new JTextField();
        meanField.setFont(myFont);
        meanField.setEditable(false);
        meanField.setBounds(90, 200, 217, 20);

        meanLabel = new JLabel("Mean");
        meanLabel.setFont(myFont);
        size = meanLabel.getPreferredSize();
        meanLabel.setBounds(30, 202, size.width, size.height);

        mdField = new JTextField();
        mdField.setFont(myFont);
        mdField.setEditable(false);
        mdField.setBounds(90, 230, 217, 20);

        mdLabel = new JLabel("Median");
        mdLabel.setFont(myFont);
        size = mdLabel.getPreferredSize();
        mdLabel.setBounds(30, 232, size.width, size.height);

        moField = new JTextField();
        moField.setFont(myFont);
        moField.setEditable(false);
        moField.setBounds(90, 260, 217, 20);

        moLabel = new JLabel("Mode");
        moLabel.setFont(myFont);
        size = moLabel.getPreferredSize();
        moLabel.setBounds(30, 262, size.width, size.height);

        frame.add(enButton);
        frame.add(eqButton);
        frame.add(clButton);
        frame.add(meanField);
        frame.add(meanLabel);
        frame.add(mdField);
        frame.add(mdLabel);
        frame.add(moField);
        frame.add(moLabel);
        frame.add(textFieldA);
        frame.add(textFieldB);
        frame.setVisible(true);

    }

    double mean() {
        double sum=0;
        for(double el: numb)
            sum+=el;
        return sum/numb.size();
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
        if(keyCode == KeyEvent.VK_ENTER){
            numb.add(Double.parseDouble(textFieldA.getText()));
            textFieldA.setText("");
            textFieldB.setText("");
            for(double i: numb){
                if(i%1==0)
                    textFieldB.setText(textFieldB.getText().concat(String.valueOf((int) i))+" ");
                else
                    textFieldB.setText(textFieldB.getText().concat(String.valueOf(i))+" ");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        //unused

    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == enButton){
            numb.add(Double.parseDouble(textFieldA.getText()));
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
            numb.clear();
            textFieldA.setText("");

        } 
    }
}
