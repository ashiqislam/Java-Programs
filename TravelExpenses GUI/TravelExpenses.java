import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class TravelExpenses extends JFrame 
{
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    JPanel panel = new JPanel();
    private JLabel numberOfDaysLabel;
    private JLabel AirfareLabel;
    private JLabel RentalFeeLabel;
    private JLabel parkingFeeLabel;
    private JLabel seminarFeeLabel;
    private JLabel lodgingFeeLabel;
    private JTextField daysField;
    private JTextField AirfareField;
    private JTextField RentalFeeField;
    private JTextField parkingFeeField;
    private JTextField seminarFeeField;
    private JTextField lodgingFeeField;
    private JButton calculateButton;

    public TravelExpenses() 
    {
        setTitle("Travel Expenses");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        add(panel);
        setVisible(true);

    }

    private void buildPanel() 
    {

        numberOfDaysLabel = new JLabel("Number of days on the trip: ");
        daysField = new JTextField(10);

        AirfareLabel = new JLabel("Amount of airfare: ");
        AirfareField = new JTextField(10);

        RentalFeeLabel = new JLabel("Amount of car rental fee: ");
        RentalFeeField = new JTextField(10);

        parkingFeeLabel = new JLabel("Amount of parking fees: ");
        parkingFeeField = new JTextField(10);

        seminarFeeLabel = new JLabel("Conference fees: ");
        seminarFeeField = new JTextField(10);

        lodgingFeeLabel = new JLabel("Lodging charges per night");
        lodgingFeeField = new JTextField(10);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new buttonListener());
        panel = new JPanel(new GridLayout(9, 2, 5, 10));

        panel.add(numberOfDaysLabel);
        panel.add(daysField);
        panel.add(AirfareLabel);
        panel.add(AirfareField);
        panel.add(RentalFeeLabel);
        panel.add(RentalFeeField);
        panel.add(parkingFeeLabel);
        panel.add(parkingFeeField);
        panel.add(seminarFeeLabel);
        panel.add(seminarFeeField);
        panel.add(lodgingFeeLabel);
        panel.add(lodgingFeeField);
        panel.add(calculateButton);

    }

    public class buttonListener implements ActionListener 
    {

        public void actionPerformed(ActionEvent e) 
        {
            String stringDay, stringAirfare, stringCarRental, stringParkingFee, stringSeminarFee, stringLodgingFee;
            double Days, AirFare, CarRental, ParkingFee, seminarFee, lodgingFee;
            final double dayMeal = 37.00;
            final double parkingFee = 10.00;
            final double lodgingCharge = 95.00;
            double totalAllowed;
            double totalOwed;
            double totalSaved;
            double totalExpenses;
            

            stringDay = daysField.getText();
            Days = Double.parseDouble(stringDay);

            stringAirfare = AirfareField.getText();
            AirFare = Double.parseDouble(stringAirfare);

            stringCarRental = RentalFeeField.getText();
            CarRental = Double.parseDouble(stringCarRental);

            stringParkingFee = parkingFeeField.getText();
            ParkingFee = Double.parseDouble(stringParkingFee);

            stringSeminarFee = seminarFeeField.getText();
            seminarFee = Double.parseDouble(stringSeminarFee);

            stringLodgingFee = lodgingFeeField.getText();
            lodgingFee = Double.parseDouble(stringLodgingFee);

            totalExpenses = AirFare + CarRental + ParkingFee + seminarFee + lodgingFee * Days;
            totalAllowed = Days * dayMeal + Days * parkingFee + Days * lodgingCharge;

            if (totalExpenses > totalAllowed) 
            {
                totalOwed = totalExpenses - totalAllowed;
            } else {
                totalOwed = 0;
            }

            if (totalAllowed > totalExpenses) 
            {
                totalSaved = totalAllowed - totalExpenses;
            } else {
                totalSaved = 0;
            }

            System.out.println("The total expenses for the trip are " + totalExpenses
                + " \nThe total allowed to spend is " + totalAllowed + "\nThe total you owe is "
                + totalOwed + "\nTotal saved is " + totalSaved);

        }
    }
}