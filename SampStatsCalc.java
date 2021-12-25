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
    Font myFont = new Font("Consolas", Font.BOLD, 14);

    SampStatsCalc() {
        frame = new JFrame("Simple Sample Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(336,440);
        frame.setLayout(null);
        frame.setResizable(false);

        textFieldA = new JTextField();
        textFieldA.setFont(myFont);
        textFieldA.setBounds(15, 25, 300, 25);
        textFieldA.setEditable(false);
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
        meanField.setBounds(165, 200, 152, 20);

        meanLabel = new JLabel("Mean");
        meanLabel.setFont(myFont);
        size = meanLabel.getPreferredSize();
        meanLabel.setBounds(15, 202, size.width, size.height);

        mdField = new JTextField();
        mdField.setFont(myFont);
        mdField.setEditable(false);
        mdField.setBounds(165, 230, 152, 20);

        mdLabel = new JLabel("Median");
        mdLabel.setFont(myFont);
        size = mdLabel.getPreferredSize();
        mdLabel.setBounds(15, 232, size.width, size.height);

        moField = new JTextField();
        moField.setFont(myFont);
        moField.setEditable(false);
        moField.setBounds(165, 260, 152, 20);

        moLabel = new JLabel("Mode");
        moLabel.setFont(myFont);
        size = moLabel.getPreferredSize();
        moLabel.setBounds(15, 262, size.width, size.height);

        rField = new JTextField();
        rField.setFont(myFont);
        rField.setEditable(false);
        rField.setBounds(165, 290, 152, 20);

        rLabel = new JLabel("Range");
        rLabel.setFont(myFont);
        size = rLabel.getPreferredSize();
        rLabel.setBounds(15, 292, size.width, size.height);

        sField = new JTextField();
        sField.setFont(myFont);
        sField.setEditable(false);
        sField.setBounds(165, 320, 152, 20);

        sLabel = new JLabel("Standard Deviation");
        sLabel.setFont(myFont);
        size = sLabel.getPreferredSize();
        sLabel.setBounds(15, 322, size.width, size.height);

        vField = new JTextField();
        vField.setFont(myFont);
        vField.setEditable(false);
        vField.setBounds(165, 350, 152, 20);

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
        return (double) Math.round(average*10000)/10000; 
    }

    double median() {
        int placement=numb.size()/2;
        if(numb.size()%2!=0)
            return numb.get(placement);
        else
            return (numb.get(placement-1)+numb.get(placement))/2;
    }

    void mode() {
        ArrayList<Double> mode=new ArrayList<Double>();
        ArrayList<Double> cloneNumb=new ArrayList<Double>();

        short appearance = 0;
        for(double el: numb){
            short inAppear = 0;
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
            if(!(cloneNumb.contains(el)))
                cloneNumb.add(el);
        }

        for(double i: mode){
            if(i%1!=0 && i!=0.0)
                moField.setText(moField.getText().concat(String.valueOf(i)));
            else
                moField.setText(moField.getText().concat(String.valueOf((int) i)));
        }

        if(mode.size()==0 || mode.equals(cloneNumb)){
            mode.clear();
            moField.setText("None");
        }
    }

    double range() {
        Collections.sort(numb);
        double max = numb.get(numb.size()-1);
        double min = numb.get(0);
        double diff = max - min;
        return (double) Math.round(diff*10000)/10000;
    }

    double standardDev() {
        double sumSq = 0.0;
        for(double el: numb){
            double squared = (double) Math.round((el-mean())*10000)/10000;
            squared=squared*squared;
            sumSq+=squared;
        }
        double quo = sumSq/(numb.size()-1);
        return (double) Math.round(Math.sqrt(quo)*10000)/10000;
    }

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
            else{}

            if(mean()%1!=0)
                meanField.setText(String.valueOf(mean()));
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
            numb.clear();
            textFieldA.setText("");
        }
        if(keyCode == KeyEvent.VK_0) {
            textFieldA.setText(textFieldA.getText().concat("0"));
        }
        if(keyCode == KeyEvent.VK_1) {
            textFieldA.setText(textFieldA.getText().concat("1"));
        }
        if(keyCode == KeyEvent.VK_2) {
            textFieldA.setText(textFieldA.getText().concat("2"));
        }
        if(keyCode == KeyEvent.VK_3) {
            textFieldA.setText(textFieldA.getText().concat("3"));
        }
        if(keyCode == KeyEvent.VK_4) {
            textFieldA.setText(textFieldA.getText().concat("4"));
        }
        if(keyCode == KeyEvent.VK_5) {
            textFieldA.setText(textFieldA.getText().concat("5"));
        }
        if(keyCode == KeyEvent.VK_6) {
            textFieldA.setText(textFieldA.getText().concat("6"));
        }
        if(keyCode == KeyEvent.VK_7) {
            textFieldA.setText(textFieldA.getText().concat("7"));
        }
        if(keyCode == KeyEvent.VK_8) {
            textFieldA.setText(textFieldA.getText().concat("8"));
        }
        if(keyCode == KeyEvent.VK_9) {
            textFieldA.setText(textFieldA.getText().concat("9"));
        }
        if(keyCode == KeyEvent.VK_PERIOD) {
            textFieldA.setText(textFieldA.getText().concat("."));
        }
        if(keyCode == KeyEvent.VK_BACK_SPACE){
            StringBuilder sb = new StringBuilder();
            String given = textFieldA.getText();
            sb.deleteCharAt(given.length()-1);
            textFieldA.setText(sb.toString());
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
            numb.clear();
        } 
    }
}
