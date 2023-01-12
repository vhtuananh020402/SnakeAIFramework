package GUI;

import snakes.SnakesUIMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class GameMainMenu extends JFrame implements ActionListener {
    public static String[] bots = {"a_zhuchkov", "johndoe", "v_smirnov"};
    public static JComboBox comboBox;

    private ImageIcon snakeIcon;
    private JLabel myLabel;

    private Button myButton;
    private Button myButton2;
    private Button myButton3;
    private Button myButton4;
    private Button myButton5;
    private Button backToMenuButton;
    private static final int buttonTextSize = 20;
    private static final Dimension menuButtonSize = new Dimension(180, 70);;


    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    public GameMainMenu() {
        paintMenu();
    }

    public void paintMenu() {

        this.setTitle("Snake Revolution");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 600));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //this.setLayout(new FlowLayout());
        this.setLayout(null);

        // create a snake Background within a label
        snakeIcon = new ImageIcon(this.getClass().getResource("/GUI/img/snakeGameMenuv2.png"));
        myLabel = new JLabel(snakeIcon);
        myLabel.setSize(new Dimension(600, 600));


//        comboBox = new JComboBox(bots);
//        comboBox.setBounds(50, 50, 100, 50);
//        this.add(comboBox);
//        comboBox.addActionListener(this)


        // create a play button
        myButton = new Button();
        myButton.setFont(new Font("Arial", Font.PLAIN, buttonTextSize));
        myButton.setText("PLAY");
        myButton.setFocusable(false);
        myButton.setPreferredSize(menuButtonSize);
        this.add(myButton);

        Insets insets = this.getInsets();
        Dimension size = myButton.getPreferredSize();
        myButton.setBounds(25 + insets.left + 30, 5 + insets.top + 140, size.width, size.height);
        myButton.addActionListener(this);

        // create a how to play button
        myButton2 = new Button();
        myButton2.setFont(new Font("Arial", Font.PLAIN, buttonTextSize));
        myButton2.setText("HOW TO PLAY");
        myButton2.setFocusable(false);
        myButton2.setPreferredSize(menuButtonSize);
        this.add(myButton2);
        myButton2.setBounds(25 + insets.left + 30, 5 + insets.top + 220, size.width, size.height);
        myButton2.addActionListener(this);

        // create a leaderboard button
        myButton3 = new Button();
        myButton3.setFont(new Font("Arial", Font.PLAIN, buttonTextSize));
        myButton3.setText("LEADERBOARD");
        myButton3.setFocusable(false);
        myButton3.setPreferredSize(menuButtonSize);
        this.add(myButton3);
        myButton3.setBounds(25 + insets.left + 30, 5 + insets.top + 300, size.width, size.height);

        // create an options button
        myButton4 = new Button();
        myButton4.setFont(new Font("Arial", Font.PLAIN, buttonTextSize));
        myButton4.setText("OPTIONS");
        myButton4.setFocusable(false);
        myButton4.setPreferredSize(menuButtonSize);
        this.add(myButton4);
        myButton4.setBounds(25 + insets.left + 30, 5 + insets.top + 380, size.width, size.height);
        myButton4.addActionListener(this);


        // create an exit button
        myButton5 = new Button();
        myButton5.setFont(new Font("Arial", Font.PLAIN, buttonTextSize));
        myButton5.setText("EXIT");
        myButton5.setFocusable(false);
        myButton5.setPreferredSize(menuButtonSize);
        this.add(myButton5);
        myButton5.setBounds(25 + insets.left + 30, 5 + insets.top + 460, size.width, size.height);
        myButton5.addActionListener(this);


        this.add(myLabel);      // insert background img at last

        this.pack();
        this.setVisible(true);

        centreWindow(this);
    }


    public void paintLeaderboard() {
        this.getContentPane().removeAll();
        this.repaint();
    }

    public void paintHowToPlay() {
        this.getContentPane().removeAll();
        this.repaint();

        this.setTitle("Snake Revolution");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(600, 600));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        //this.setLayout(new FlowLayout());
        this.setLayout(null);

        // create a snake Background within a label
        snakeIcon = new ImageIcon(this.getClass().getResource("/GUI/img/gameHowtoPlay.png"));
        myLabel = new JLabel(snakeIcon);
        myLabel.setSize(new Dimension(600, 600));

        backToMenuButton = new Button();
        backToMenuButton.setFont(new Font("Arial", Font.PLAIN, buttonTextSize));
        backToMenuButton.setText("Back");
        backToMenuButton.setFocusable(false);

        backToMenuButton.setPreferredSize(new Dimension(120, 60));

        this.add(backToMenuButton);
        Insets insets = this.getInsets();
        Dimension size = backToMenuButton.getPreferredSize();
        backToMenuButton.setBounds(25 + insets.left + 430, 5 + insets.top + 467, size.width, size.height);
        backToMenuButton.addActionListener(this);


        this.add(myLabel);      // insert background img at last

        this.pack();
        this.setVisible(true);

        centreWindow(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == comboBox) {
            System.out.println(comboBox.getSelectedItem());
        }
        else if (e.getSource() == myButton) {
            this.paintLeaderboard();
        }
        else if (e.getSource() == myButton2) {
            this.paintHowToPlay();
        }

        else if (e.getSource() == myButton5) {
            int respone = JOptionPane.showConfirmDialog(null, "You are about to exit the Game. Are you sure?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);
            if (respone == JOptionPane.YES_OPTION) {
                this.setVisible(false);
                this.dispose();
            }
        }
        else if (e.getSource() == backToMenuButton) {
            this.getContentPane().removeAll();
            //panel.revalidate();
            this.validate();
            this.repaint();

            this.paintMenu();
        }


    }
}
