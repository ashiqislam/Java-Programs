import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
This class demonstrates the List Component.
 */

public class ListWindow extends JFrame
{
    private JPanel flowerPanel; // To hold components
    private JPanel selectedFlowerPanel; // To hold components
    private JList flowerList; // The flowers
    private JTextField selectedFlower; // The selected flower
    private JLabel label; // A message
    private JLabel imageLabel;
    // The following array holds the values that will
    // be displayed in the flowerList list component.
    private String[] flowers = { "Rose","Tulip","Calla lily","Peony","Eustoma"};

    /**
    Constructor
     */

    public ListWindow()
    {
        // Set the title.
        setTitle("List Demo");

        // Specify an action for the close button.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a BorderLayout manager.
        setLayout(new BorderLayout());

        // Build the flower and selectedFlower panels.
        buildFlowerPanel();
        buildSelectedFlowerPanel();

        // Add the panels to the content pane.
        add(flowerPanel, BorderLayout.CENTER);
        add(selectedFlowerPanel, BorderLayout.SOUTH);

        // Pack and display the window.
        pack();
        setVisible(true);
    }

    /**
    The buildFlowerPanel method adds a list containing
    the names of the flowers to a panel.
     */

    private void buildFlowerPanel()
    {
        // Create a panel to hold the list.
        flowerPanel = new JPanel();

        // Create the list.
        flowerList = new JList(flowers);

        // Set the selection mode to single selection.
        flowerList.setSelectionMode(
            ListSelectionModel.SINGLE_SELECTION);

        // Register the list selection listener.
        flowerList.addListSelectionListener(
            new ListListener());

        // Add the list to the panel.
        flowerPanel.add(flowerList);
    }

    /**
    The buildSelectedFlowerPanel method adds an
    uneditable text field to a panel.
     */

    private void buildSelectedFlowerPanel()
    {
        // Create a panel to hold the text field.
        selectedFlowerPanel = new JPanel();

        // Create the label.
        label = new JLabel("You selected: ");
        imageLabel = new JLabel();
        // Create the text field.
        selectedFlower = new JTextField(10);

        // Make the text field uneditable.
        selectedFlower.setEditable(false);

        // Add the label and text field to the panel.
        selectedFlowerPanel.add(label);
        selectedFlowerPanel.add(selectedFlower);
        selectedFlowerPanel.add(imageLabel);
    }

    /**
    Private inner class that handles the event when
    the user selects an item from the list.
     */

    private class ListListener
    implements ListSelectionListener
    {
        @Override
        public void valueChanged(ListSelectionEvent e)
        {
            // Get the selected flower.
            String selection =
                (String) flowerList.getSelectedValue();

            // Put the selected flower in the text field.
            selectedFlower.setText(selection);
            ImageIcon rose = new ImageIcon("rose.jpg");
            ImageIcon tulip = new ImageIcon("Tulip.jpg");
            ImageIcon calla = new ImageIcon("Calla-lily.jpg");
            ImageIcon peony = new ImageIcon("Peony.jpg");
            ImageIcon eustoma = new ImageIcon("Eustoma.jpg");
            if(selection.equals("Rose")) imageLabel.setIcon(rose);
            if(selection.equals("Tulip")) imageLabel.setIcon(tulip);
            if(selection.equals("Calla lily"))imageLabel.setIcon(calla);
            if (selection.equals("Peony"))imageLabel.setIcon(peony);
            if (selection.equals("Eustoma"))imageLabel.setIcon(eustoma);

            // Pack and display the window.
            pack();
            setVisible(true);
        }
    }

    /**
    The main method creates an instance of the
    ListWindow class which causes it to display
    its window.
     */

    public static void main(String[] args)
    {
        new ListWindow();
    }
}