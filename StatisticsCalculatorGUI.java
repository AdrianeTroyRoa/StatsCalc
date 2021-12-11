import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StatisticsCalculatorGUI extends JFrame {

    private JPanel mainPanel;
    private JTable statisticsContainerTable;
    private JTextField dataSetTextField;
    private JButton calculateButton;
    private JFormattedTextField meanTextField;
    private JFormattedTextField medianTextField;
    private JFormattedTextField modeTextField;
    private JFormattedTextField rangeTextField;
    private JFormattedTextField standardDeviationTextField;
    private JFormattedTextField varianceTextField;
    private JLabel meanLabel;
    private JLabel medianLabel;
    private JLabel modeLabel;
    private JLabel rangeLabel;
    private JLabel standardDeviationLabel;
    private JLabel varianceLabel;

    public StatisticsCalculatorGUI(String title){
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
    }

    public static void main(String[] args) {
        JFrame frame = new StatisticsCalculatorGUI("Statistics Calculator");
        frame.setVisible(true);


    }
}
