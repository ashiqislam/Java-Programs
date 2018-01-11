import java.awt.*; 
import javax.swing.event.*; 
import javax.swing.*; ;

public class ShadeDesigner extends JFrame
{
    private JLabel label;
    private JPanel shadesAmountPanel;
    private JPanel stylesPanel;
    private JPanel sizesPanel;
    private JPanel colorsPanel;
    private JPanel totalPanel;
    private JList stylesList;
    private JList sizesList;
    private JList colorsList;
    private JTextField shadesAmountField;
    private JTextField total;

    private String[] styles = {"Regular Shades", "Folding Shades", "Roman Shades"};
    private String[] sizes = {"25 inches", "27 inches", "32 inches", "40 inches"};
    private String[] colors = {"Natural", "Blue", "Teal", "Red", "Green"};
    private double[] stylesRate = {0, 10, 15};
    private double[] sizesRate = {0, 2, 4, 6};
    private double[] colorsRate = {5, 0, 0, 0, 0};

    public ShadeDesigner()
    {
        setTitle("Shade Designer");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,2));

        buildShadesAmountPanel();
        buildStylesPanel();
        buildSizesPanel();
        buildColorsPanel();
        buildTotalPanel();
        add(shadesAmountPanel);
        add(stylesPanel);
        add(sizesPanel);
        add(colorsPanel);
        add(totalPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    private void buildShadesAmountPanel()
    {
        label = new JLabel("Select  the number of shades you want ");
        shadesAmountPanel = new JPanel(); 
        shadesAmountField = new JTextField(" ", 10); 
        shadesAmountField.setEditable(true);
        shadesAmountPanel.add(label); 
        shadesAmountPanel.add(shadesAmountField);
    }

    @SuppressWarnings("unchecked")
    private void buildStylesPanel()
    {
        label = new JLabel("Select a style ");
        stylesPanel = new JPanel();
        stylesList = new JList(styles);
        stylesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        stylesList.addListSelectionListener (new ListListener());
        stylesPanel.add(label);
        stylesPanel.add(stylesList);
    }

    @SuppressWarnings("unchecked")
    private void buildSizesPanel()
    {
        label = new JLabel("Select a size ");
        sizesPanel = new JPanel();
        sizesList = new JList(sizes);
        sizesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        sizesList.addListSelectionListener (new ListListener());
        sizesPanel.add(label);
        sizesPanel.add(sizesList);
    }

    @SuppressWarnings("unchecked")
    private void buildColorsPanel()
    {
        label = new JLabel("Select a color ");
        colorsPanel = new JPanel();
        colorsList = new JList(colors);
        colorsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
        colorsList.addListSelectionListener (new ListListener());
        colorsPanel.add(label);
        colorsPanel.add(colorsList);
    }

    private void buildTotalPanel()
    {
        label = new JLabel("The total is ");
        totalPanel = new JPanel();
        total = new JTextField(10);
        total.setEditable(false);
        totalPanel.add(label);
        totalPanel.add(total);
    }

    private class ListListener implements ListSelectionListener 
    { 
        public void valueChanged(ListSelectionEvent e) 
        { 
            int styles;
            int sizes;
            int colors;
            double total1;

            String shadesAmount = shadesAmountField.getText();

            String stylesSelection = (String)stylesList.getSelectedValue();
            styles = stylesList.getSelectedIndex();

            String sizesSelection = (String)sizesList.getSelectedValue();
            sizes = sizesList.getSelectedIndex();
            
            if (e.getSource() == sizesList) {
                sizesSelection = (String)sizesList.getSelectedValue();
                sizes = sizesList.getSelectedIndex();
            }

            String colorsSelection = (String)colorsList.getSelectedValue();
            colors = colorsList.getSelectedIndex();

            total1 = stylesRate[styles] + sizesRate[sizes] + colorsRate[colors] + (Double.parseDouble(shadesAmount)) * 50;
            total.setText("$" + total1);

        }
    }

    public static void main(String[] args)
    {
        ShadeDesigner sd = new ShadeDesigner();
    }
}