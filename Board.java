import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
*   This is the class that sets the board for the game
**/

public class Board extends JFrame{
    //Final attributes
    private final int MAX_SELECTED_CARDS = 2;
    private final int MAX_CARD_NUMBER = 20;
    private final int MAX_PAIRS = 10;
    private final int FAILED_ATTEMPTS_MULTIPLIER = 2;
    private final int VISIBLE_DELAY = 200;
    private final int PEEK_DELAY = 1500;

    //Static attributes
    //These are the board parameters
    private static int selectedCards = 0;
    private static int cardNumber = 0;
    private static int matchedPair = 0;
    private static int failedAttempts = 0;

    //Attributes
    private List<Card> cards;
    private Card selectedCard;
    private Card c1;
    private Card c2;
    private Timer cardChecker;
    private Timer peekTimer;
    private float finalScore = 0.0f;


    //Panels
    private final JPanel panel = new JPanel(new GridLayout(4,5));
    //Constructor for Board
    public Board(){
        super("Memory Match");
        initialize();
        this.add(panel);
        this.setPreferredSize(new Dimension(1000,740)); //need to use this instead of setSize
        this.setLocation(200, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    //Method that initializes the board
    public void initialize(){
        initializeCards();
        peekCards();
        setBoard();
    }

    //Initializes the cards for the game
    public void initializeCards(){
        List<Card> cardsList = new ArrayList<Card>();
        List<Integer> cardVals = new ArrayList<Integer>();
        double cardPack = (int)(Math.random() * ((5 - 0) + 0)) + 0;

        //adds number to cardVals which will be used later for assigning card ID
        for (int i = 0; i < MAX_PAIRS; i++){
            cardVals.add(i);
            cardVals.add(i);
        }

        //Shuffles the card values
        Collections.shuffle(cardVals);

        int i = 1;      //i is counter used to set card number
        for (int val : cardVals){
            Card c = new Card(val, i);  //Val assigns card ID and i assigns card number
            c.setCardIcon(val, cardPack);
            c.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    if(selectedCards < MAX_SELECTED_CARDS && !(c.equals(selectedCard))){
                        selectedCard = c;
                        selectedCards++;
                        c.setCardIcon(val, cardPack);
                        assignCards();
                    }
                }
            });

            cardsList.add(c);   //adds the instantiated cards to the cardsList
            i++;
        }

        this.cards = cardsList;     //adds list of cards to the cards attribute of the board

        //set up the timer for checking cards
        cardChecker = new Timer(VISIBLE_DELAY, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               checkCards();
          }
        });
        cardChecker.setRepeats(false);
    }

    //Method that shows where the images are located for a short period of time
    public void peekCards(){
         peekTimer = new Timer(PEEK_DELAY, new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                for(Card card : cards){
                    card.setBackIcon();
                }
            }
        });
        peekTimer.setRepeats(false);
        peekTimer.start();
    }

    //Sets the cards in the frame through a panel
    public void setBoard(){
        for (Card c : cards){
            panel.add(c);
        }
    }

    //Passes the cards to the c1 and c2 card objects respectively for checking if cards are a pair or not
    public void assignCards(){
        if (c1 == null && c2 == null){  //Checks if Card c1 object is empty
            c1 = selectedCard;
        }

        if (c1 != null && c1 != selectedCard && c2 == null){    //Checks if Card c1 is not empty and c2 is empty
            c2 = selectedCard;
            cardChecker.start();           //Starts the timer for checking cards and setting delay for visibility of selected cards
        }
    }

    //Method that checks if cards are matched
    public void checkCards(){
        if(!(c1.equals(c2))){   //checks if the selected card was itself or not
            if (c1.getId() == c2.getId()){//checks if the conditions are matched
                c1.setEnabled(false); //disables the buttons
                c2.setEnabled(false);
                c1.setMatched(true); //flags the buttons as having been matched
                c2.setMatched(true);
                matchedPair++;      //increments the amount of pairs matched
            }
            else{
                failedAttempts++; //increments failed attempts if cards were not successfully matched
                c1.setBackIcon(); //'hides' the images
                c2.setBackIcon();
            }
        }

        c1 = null;          //reset c1 and c2 and selectedCards counter
        c2 = null;
        selectedCards = 0;

        //Checks if the game is won. Also stops the program
        if(this.isGameWon()){
            this.finalScore = 100 * ((100 - ((float)(failedAttempts) * FAILED_ATTEMPTS_MULTIPLIER))/100);
            if(this.finalScore < 0){
                this.finalScore = 0.00f;
            }
            JOptionPane.showMessageDialog(this, "You win! \nMatched Pairs: " + this.matchedPair + "\nFailed Attempts: " +
            this.failedAttempts + "\nFinal Score: " + this.finalScore + "%");
            resetStats();
            exitProgram();
        }
    }

    //Resets player statistics
    public void resetStats(){
        this.matchedPair = 0;
        this.finalScore = 0;
        this.failedAttempts = 0;
    }

    //Method that checks whether all cards have been matched
    public boolean isGameWon(){
        boolean ok = true;

        //Loop that checks if each cards in the list are matched
        for(Card c: this.cards){
            if (c.getMatched() == false){
                ok = false;
            }
        }
        return ok;
    }

    //Method that exits the game interface
    public void exitProgram(){
        this.dispose();
    }
}