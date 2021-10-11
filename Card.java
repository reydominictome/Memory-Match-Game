import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.*;

/**
*   A Card class that sets up the type of card to be set on the board
**/
public class Card extends JButton{
    private int cardNumber;     //Card attribute that identifies a card as an individual
    private int id;             //Card attribute that identifies
    private boolean matched = false;
    private boolean clicked = false;

    //Constructor for Card
    public Card(int id, int cardNumber){
        this.id = id;
        this.cardNumber = cardNumber;
    }

    //Returns the card id
    public int getId(){
        return this.id;
    }

    //Sets the back icon of the card
    public void setBackIcon(){
        this.setIcon(new ImageIcon("Images/questionmark.jpg"));
    }

    //Method that will set the match attribute to true or false
    public void setMatched(boolean matched){
        this.matched = matched;
    }

    //Method that returns the boolean value of matched attribute
    public boolean getMatched(){
        return this.matched;
    }

    //Compares two cards if they are the same
    public boolean equals(Object obj){
        boolean ok = false;

        if(obj != null && obj instanceof Card){
            Card c = (Card) obj;
            if(this.cardNumber == c.cardNumber && this.id == c.id)
                ok=true;
        }

        return ok;
    }

    //Displays card info
    public String toString(){
        return "[Card ID: " + this.id + " | Card Number: " + this.cardNumber + " | Matched: " + this.matched + " ]\n";
    }

     //Sets the front icon of the card
    public void setCardIcon(int val, double cardPack){
        String[] cardSet = {"Anime", "Pokemon", "Place", "Emoticons", "Halloween", "Smug"};
        String cardFolder = "Card Images";
        String imageType = ".jpg";

        this.setIcon(new ImageIcon(""+cardFolder+"/"+cardSet[(int)cardPack]+"/"+(val+1)+imageType+""));
    }
}












 /*if(cardPack == 1){
            switch(val){
               case    0:  this.setIcon(new ImageIcon("Card Images/Anime/1.jpg"));
                            break;
               case    1:  this.setIcon(new ImageIcon("Card Images/Anime/2.jpg"));
                            break;
               case    2:  this.setIcon(new ImageIcon("Card Images/Anime/3.jpg"));
                            break;
               case    3:  this.setIcon(new ImageIcon("Card Images/Anime/4.jpg"));
                            break;
               case    4:  this.setIcon(new ImageIcon("Card Images/Anime/5.jpg"));
                            break;
               case    5:  this.setIcon(new ImageIcon("Card Images/Anime/6.jpg"));
                            break;
               case    6:  this.setIcon(new ImageIcon("Card Images/Anime/7.jpg"));
                            break;
               case    7:  this.setIcon(new ImageIcon("Card Images/Anime/8.jpg"));
                            break;
               case    8:  this.setIcon(new ImageIcon("Card Images/Anime/9.jpg"));
                            break;
               case    9:  this.setIcon(new ImageIcon("Card Images/Anime/10.jpg"));
                            break;
            }
        }
        else if(cardPack == 2){
           switch(val){
               case    0:  this.setIcon(new ImageIcon("Card Images/Pokemon/1.jpg"));
                            break;
               case    1:  this.setIcon(new ImageIcon("Card Images/Pokemon/2.jpg"));
                            break;
               case    2:  this.setIcon(new ImageIcon("Card Images/Pokemon/3.jpg"));
                            break;
               case    3:  this.setIcon(new ImageIcon("Card Images/Pokemon/4.jpg"));
                            break;
               case    4:  this.setIcon(new ImageIcon("Card Images/Pokemon/5.jpg"));
                            break;
               case    5:  this.setIcon(new ImageIcon("Card Images/Pokemon/6.jpg"));
                            break;
               case    6:  this.setIcon(new ImageIcon("Card Images/Pokemon/7.jpg"));
                            break;
               case    7:  this.setIcon(new ImageIcon("Card Images/Pokemon/8.jpg"));
                            break;
               case    8:  this.setIcon(new ImageIcon("Card Images/Pokemon/9.jpg"));
                            break;
               case    9:  this.setIcon(new ImageIcon("Card Images/Pokemon/10.jpg"));
                            break;
            }
        }
        else if(cardPack == 3){
            switch(val){
               case    0:  this.setIcon(new ImageIcon("Card Images/Place/1.jpg"));
                            break;
               case    1:  this.setIcon(new ImageIcon("Card Images/Place/2.jpg"));
                            break;
               case    2:  this.setIcon(new ImageIcon("Card Images/Place/3.jpg"));
                            break;
               case    3:  this.setIcon(new ImageIcon("Card Images/Place/4.jpg"));
                            break;
               case    4:  this.setIcon(new ImageIcon("Card Images/Place/5.jpg"));
                            break;
               case    5:  this.setIcon(new ImageIcon("Card Images/Place/6.jpg"));
                            break;
               case    6:  this.setIcon(new ImageIcon("Card Images/Place/7.jpg"));
                            break;
               case    7:  this.setIcon(new ImageIcon("Card Images/Place/8.jpg"));
                            break;
               case    8:  this.setIcon(new ImageIcon("Card Images/Place/9.jpg"));
                            break;
               case    9:  this.setIcon(new ImageIcon("Card Images/Place/10.jpg"));
                            break;
            }
        }
        else if(cardPack == 4){
            switch(val){
               case    0:  this.setIcon(new ImageIcon("Card Images/Emoticons/1.jpg"));
                            break;
               case    1:  this.setIcon(new ImageIcon("Card Images/Emoticons/2.jpg"));
                            break;
               case    2:  this.setIcon(new ImageIcon("Card Images/Emoticons/3.jpg"));
                            break;
               case    3:  this.setIcon(new ImageIcon("Card Images/Emoticons/4.jpg"));
                            break;
               case    4:  this.setIcon(new ImageIcon("Card Images/Emoticons/5.jpg"));
                            break;
               case    5:  this.setIcon(new ImageIcon("Card Images/Emoticons/6.jpg"));
                            break;
               case    6:  this.setIcon(new ImageIcon("Card Images/Emoticons/7.jpg"));
                            break;
               case    7:  this.setIcon(new ImageIcon("Card Images/Emoticons/8.jpg"));
                            break;
               case    8:  this.setIcon(new ImageIcon("Card Images/Emoticons/9.jpg"));
                            break;
               case    9:  this.setIcon(new ImageIcon("Card Images/Emoticons/10.jpg"));
                            break;
            }
        }
        else if(cardPack == 5){
            switch(val){
               case    0:  this.setIcon(new ImageIcon("Card Images/Halloween/1.jpg"));
                            break;
               case    1:  this.setIcon(new ImageIcon("Card Images/Halloween/2.jpg"));
                            break;
               case    2:  this.setIcon(new ImageIcon("Card Images/Halloween/3.jpg"));
                            break;
               case    3:  this.setIcon(new ImageIcon("Card Images/Halloween/4.jpg"));
                            break;
               case    4:  this.setIcon(new ImageIcon("Card Images/Halloween/5.jpg"));
                            break;
               case    5:  this.setIcon(new ImageIcon("Card Images/Halloween/6.jpg"));
                            break;
               case    6:  this.setIcon(new ImageIcon("Card Images/Halloween/7.jpg"));
                            break;
               case    7:  this.setIcon(new ImageIcon("Card Images/Halloween/8.jpg"));
                            break;
               case    8:  this.setIcon(new ImageIcon("Card Images/Halloween/9.jpg"));
                            break;
               case    9:  this.setIcon(new ImageIcon("Card Images/Halloween/10.jpg"));
                            break;
            }
        }
        else if(cardPack == 6){
            switch(val){
               case    0:  this.setIcon(new ImageIcon("Card Images/Smug/1.jpg"));
                            break;
               case    1:  this.setIcon(new ImageIcon("Card Images/Smug/2.jpg"));
                            break;
               case    2:  this.setIcon(new ImageIcon("Card Images/Smug/3.jpg"));
                            break;
               case    3:  this.setIcon(new ImageIcon("Card Images/Smug/4.jpg"));
                            break;
               case    4:  this.setIcon(new ImageIcon("Card Images/Smug/5.jpg"));
                            break;
               case    5:  this.setIcon(new ImageIcon("Card Images/Smug/6.jpg"));
                            break;
               case    6:  this.setIcon(new ImageIcon("Card Images/Smug/7.jpg"));
                            break;
               case    7:  this.setIcon(new ImageIcon("Card Images/Smug/8.jpg"));
                            break;
               case    8:  this.setIcon(new ImageIcon("Card Images/Smug/9.jpg"));
                            break;
               case    9:  this.setIcon(new ImageIcon("Card Images/Smug/10.jpg"));
                            break;
            }
        }*/