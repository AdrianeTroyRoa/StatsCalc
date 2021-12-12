import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private ArrayList<Double> given = new ArrayList<Double>();

    public StatisticsCalculatorGUI(String title){
        super(title);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double usrMeanData = (double) ((Double.parseDouble(dataSetTextField.getText())));
                given.add(usrMeanData);
                String strMean = String.valueOf(usrMeanData);
                meanTextField.setText(strMean);

                double usrMedianData = (double) ((Double.parseDouble(dataSetTextField.getText())));
                given.add(usrMedianData);
                String strMedian = String.valueOf(usrMedianData);
                medianTextField.setText(strMedian);

                double usrModeData = (double) ((Double.parseDouble(dataSetTextField.getText())));
                given.add(usrModeData);
                String strMode = String.valueOf(usrModeData);
                modeTextField.setText(strMode);

                double usrRangeData = (double) ((Double.parseDouble(dataSetTextField.getText())));
                given.add(usrRangeData);
                String strRange = String.valueOf(usrRangeData);
                rangeTextField.setText(strMedian);

                double usrStandardDeviationData = (double) ((Double.parseDouble(dataSetTextField.getText())));
                given.add(usrStandardDeviationData);
                String strSD = String.valueOf(usrStandardDeviationData);
                standardDeviationTextField.setText(strSD);

                double usrVarianceData = (double) ((Double.parseDouble(dataSetTextField.getText())));
                given.add(usrVarianceData);
                String strVariance = String.valueOf(usrVarianceData);
                varianceTextField.setText(strVariance);
                
            }
        });
    }

    public double median() {
        ArrayList<Double> given = new ArrayList<Double>();
        //stores the middle position
        int placement=this.given.size()/2;

        //checks if middle position is even or odd then returns appropriate value for median
        if(this.given.size()%2!=0)
            return this.given.get(placement);
        else
            return (this.given.get(placement-1)+this.given.get(placement))/2;
    }

    public static void main(String[] args) {
        JFrame frame = new StatisticsCalculatorGUI("Statistics Calculator");
        frame.setVisible(true);


    }
}
