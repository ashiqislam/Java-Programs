import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DormAndMealCalc extends JFrame
{
    private JPanel dormsPanel;
    private JPanel mealPanel;
    private JPanel chargesPanel;
    private JComboBox dormBox;
    private JComboBox mealBox;
    private JFormattedTextField chargeField;

    private String[] dorms = {"Allen Hall", "Pike Hall", "Farthing Hall", "University Suites" };
    private String[] meals = {"7 Meals Per Week", "14 Meals Per Week", "Unlimited Meals Per Week"};
    private int[] dormPrices = {1500, 1600, 1200, 1800};
    private int [] mealPrices = {560, 1095, 1500};

    public DormAndMealCalc()
    {
        super("Dorm and Meal Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        buildDormsPanel();
        buildMealPanel();
        buildChargesPanel();
        add(dormsPanel, BorderLayout.EAST);
        add(mealPanel, BorderLayout.WEST);
        add(chargesPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    private void buildChargesPanel()
    {
        chargesPanel = new JPanel();
        JLabel chargesLabel = new JLabel("Total charge per semester: ");
        chargeField = new JFormattedTextField(java.text.NumberFormat.getCurrencyInstance());
        chargeField.setEditable(false);
        chargesPanel.add(chargesLabel);
        chargesPanel.add(chargeField);
        chargeField.setValue((dormPrices[0] + mealPrices[0])); 
    }

    /**
     * method that creates the panel, label and combo box for selecting meal plan
     */
    private void buildMealPanel()
    {
        mealPanel = new JPanel();
        JLabel mealLabel = new JLabel("Meal Plans");
        mealBox = new JComboBox(meals);                
        mealBox.addItemListener(new comboBoxListener());
        mealPanel.add(mealLabel);
        mealPanel.add(mealBox);
    }

    private void buildDormsPanel()
    {
        dormsPanel = new JPanel();
        JLabel dormLabel = new JLabel("Dormitories");
        dormBox = new JComboBox(dorms);             
        dormBox.addItemListener(new comboBoxListener());
        dormsPanel.add(dormLabel);
        dormsPanel.add(dormBox);
    }

    private class comboBoxListener implements ItemListener
    {
        public void itemStateChanged(ItemEvent e)
        {
            int mealIndex = mealBox.getSelectedIndex();
            int dormIndex = dormBox.getSelectedIndex();
            chargeField.setValue((dormPrices[dormIndex] + mealPrices[mealIndex]));
        }
    }

    public static void main(String[] args)
    {
        new DormAndMealCalc();
    }
}