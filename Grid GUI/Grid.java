import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

public class Grid 
{
    public static void main(String[] args) {

        JFrame frame = new JFrame("Grid");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 2));

        final Color button1Default;
        final Color button1Secondary;

        final Color button2Default;
        final Color button2Secondary;

        final Color button3Default;
        final Color button3Secondary;

        final Color button4Default;
        final Color Button4Secondary;

        final JButton button1 = new JButton("BLUE");
        frame.add(button1);

        final JButton button2 = new JButton("GREEN");
        frame.add(button2);

        final JButton button3 = new JButton("RED");
        frame.add(button3);

        final JButton button4 = new JButton("YELLOW");
        frame.add(button4);

        button1Default = button1.getBackground();
        button1.addActionListener(new ActionListener(){
                public void actionPerformed(java.awt.event.ActionEvent e) 
                {
                    if(button1.getBackground().equals(button1Default))
                        button1.setBackground(Color.BLUE);
                    else
                        button1.setBackground(button1Default);
                }
            });

        button2Default = button2.getBackground();
        button2.addActionListener(new ActionListener(){
                public void actionPerformed(java.awt.event.ActionEvent e) 
                {
                    if(button2.getBackground().equals(button2Default))
                        button2.setBackground(Color.GREEN);
                    else
                        button2.setBackground(button2Default);
                }
            });

        button3Default = button3.getBackground();
        button3.addActionListener(new ActionListener(){
                public void actionPerformed(java.awt.event.ActionEvent e) 
                {
                    if(button3.getBackground().equals(button3Default))
                        button3.setBackground(Color.RED);
                    else
                        button3.setBackground(button3Default);
                }
            });

        button4Default = button4.getBackground();
        button4.addActionListener(new ActionListener(){
                public void actionPerformed(java.awt.event.ActionEvent e) 
                {
                    if(button4.getBackground().equals(button4Default))
                        button4.setBackground(Color.YELLOW);
                    else
                        button4.setBackground(button4Default);
                }
            });

        frame.setSize(800, 800);
        frame.setVisible(true);

    }
}
