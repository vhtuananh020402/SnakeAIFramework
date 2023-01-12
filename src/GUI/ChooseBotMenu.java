package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import GUI.Button;

public class ChooseBotMenu extends JFrame implements ActionListener {
    public static String[] bots = {"a_zhuchkov", "johndoe", "v_smirnov"};
    public static JComboBox comboBox;

    private ImageIcon snakeIcon;
    private JLabel myLabel;


    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    public ChooseBotMenu() {
        JFrame ChooseBotMenu = new JFrame("Setting our bot");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 600));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //this.setLayout(new FlowLayout());
        this.setLayout(null);
        snakeIcon = new ImageIcon(this.getClass().getResource("/GUI/img/snakeGameMenu.png"));
        myLabel = new JLabel(snakeIcon);
        myLabel.setSize(new Dimension(600, 600));


        comboBox = new JComboBox(bots);
        comboBox.setBounds(50, 50, 100, 50);
        this.add(comboBox);
        comboBox.addActionListener(this);

        this.add(myLabel);


        // create a button
        Button myButton = new Button();
        this.add(myButton);

        this.pack();
        this.setVisible(true);

        centreWindow(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == comboBox) {
            System.out.println(comboBox.getSelectedItem());
        }
    }
}
