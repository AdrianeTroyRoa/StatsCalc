import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StatCalcGui implements ActionListener {
    JFrame frame;
    JLabel label;


    StatCalcGui(){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 800);
        frame.setTitle("Statistics Calculator");
        frame.setVisible(true);









    }
    public static void main(String[] args) {
        new StatCalcGui();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
