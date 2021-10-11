import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
*   Test class for the Memory Match Game
**/
public class Game extends JFrame{
    //Buttons
    private JButton btnStart = new JButton();
    private JButton btnInstruction = new JButton();
    private JButton btnExit = new JButton();

    //Panel
    private JPanel menuPanel= new JPanel();

    //Constructor Game
    public Game(){
        super("Memory Match Game");

        menuPanel.add(btnStart);
        btnStart.setIcon(new ImageIcon("Images/start.jpg"));
        menuPanel.add(btnInstruction);
        btnInstruction.setIcon(new ImageIcon("Images/instructions.jpg"));
        menuPanel.add(btnExit);
        btnExit.setIcon(new ImageIcon("Images/exit.jpg"));

        menuPanel.setLayout(new GridLayout(3, 1));

        initialize();

        this.add(menuPanel);
        this.setVisible(true);
        this.setSize(250,300);
        this.setLocation(500,200);
    }

    //Initializes the buttons
    public void initialize(){
        //When this button is clicked, the board will be displayed in a new frame
        btnStart.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Board b = new Board();
            }
        });

        //Shows instructions for card game
        btnInstruction.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(new Frame(), "This game is a simple memory match game where you have to\n" +
                "find all pairs of cards.\n\nYou will be scored according to the amount of failed attempts \n\nMechanics:\n"
                + "1.) Click" + " on the card to show the image" + "\n2.) You cannot click a card consecutively. If you do, it won't" +
                " flip\n3.) Once you flip a card, you can't flip it back. So choose carefully."
                , "Instructions", JOptionPane.PLAIN_MESSAGE);
            }
        });

        //terminates the program
        btnExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }

    //Main method where user can play the game when run
    public static void main(String args[]){
        Game g = new Game();
    }
}