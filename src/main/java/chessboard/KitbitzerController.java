package chessboard;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by joshdemusz on 11/17/16.
 */
public class KitbitzerController implements Initializable
{
    @FXML
    Label kitbitzer_label;

    // Thread that allows comments to be refreshed every 5 seconds
    Thread t;

    // Lists of comments
    protected ArrayList<String> pieces;   // Used to generate random move
    protected ArrayList<String> letters;  // Used to generate random move
    protected ArrayList<String> compliments;
    protected ArrayList<String> insults;
    protected ArrayList<String> kanye_quotes;

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        pieces = new ArrayList<String>();
        letters = new ArrayList<String>();
        compliments = new ArrayList<String>();
        insults = new ArrayList<String>();
        kanye_quotes = new ArrayList<>();

        pieces.add("King");
        pieces.add("Queen");
        pieces.add("Bishop");
        pieces.add("Knight");
        pieces.add("Pawn");
        pieces.add("Rook");

        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");
        letters.add("F");
        letters.add("G");
        letters.add("H");

        compliments.add("You look stunning today");
        compliments.add("Your smile is contagious");
        compliments.add("You light up the room");
        compliments.add("You've got all the right moves!");
        compliments.add("You go girl!");
        compliments.add("Your skin is amazing, can't wait to try it on.");
        compliments.add("Your IQ is bigger than Rihanna's forehead");
        compliments.add("Your body was chiseled by the gods themselves");
        compliments.add("If you have a twin I would still choose you");
        compliments.add("You are a genius");

        insults.add("Go back to checkers");
        insults.add("Casey Anthony is better at parenting than you are at chess");
        insults.add("Just give up");
        insults.add("I was going to give you a nasty look but I see you already have one");
        insults.add("You're as useless as the 'g' in Lasagna");
        insults.add("You're so fake, barbie is jealous");
        insults.add("I hope you step on a lego");
        insults.add("There's no way you can win");
        insults.add("Melania Trump is better at speech writing than you are at chess");
        insults.add("!#$%^&%$#@");

        kanye_quotes.add("I still think I am the greatest.");
        kanye_quotes.add("I am God's vessel. But my greatest pain in life is that I will never be able to see myself perform live.");
        kanye_quotes.add("Sometimes people write novels and they just be so wordy and so self-absorbed.");
        kanye_quotes.add("I don't know what's better gettin' laid or gettin' paid.");
        kanye_quotes.add("When you’re the absolute best, you get hated on the most.");
        kanye_quotes.add("I really appreciate the moments that I was able to win rap album of the year or whatever.");
        kanye_quotes.add("I feel like I'm too busy writing history to read it.");
        kanye_quotes.add("Man, I'm the No. 1 living and breathing rock star. I am Axl Rose; I am Jim Morrison; I am Jimi Hendrix.");
        kanye_quotes.add("I am Warhol. I am the No. 1 most impactful artist of our generation. I am Shakespeare in the flesh.");
        kanye_quotes.add("I am God’s vessel. But my greatest pain in life is that I will never be able to see myself perform live.");
        kanye_quotes.add("I will go down as the voice of this generation, of this decade, I will be the loudest voice.");

    }

    public void startKitbitzer()
    {
        // Create a new thread
        t = new Thread(new CommentaryLoop());
        t.start();

        System.out.println("Start kitbitzer");
    }

    public void stopKitbitzer() throws InterruptedException
    {
        // Stop thread
        t.join();
    }

    private class CommentaryLoop implements Runnable
    {
        public void run()
        {
            try
            {
                for (int i = 0; i < 10000; i++)
                {
                    // Pause for 5 seconds
                    Thread.sleep(5000);

                    // Obtain a new comment
                    String random_comment = generateCommentary();

                    // Update "kitbitzer" label
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run()
                        {
                            kitbitzer_label.setText(random_comment);
                        }
                    });
                    //kitbitzer_label.setText(random_comment);

                    System.out.println("Change label");
                }
            } catch (InterruptedException e)
            {
                System.out.println("An error has occured in the Commentary Loop");
            }
        }
    }

    public String generateCommentary()
    {
        // Choose a category for the new comment
        int category = ThreadLocalRandom.current().nextInt(0, 7);
        String commentary = "";

        if(category < 4)
        {
            commentary = generateChessMove();
        }
        else if(category == 4)
        {
            commentary = generateCompliments();
        }
        else if(category == 5)
        {
            commentary = generateInsults();
        }
        else if(category == 6)
        {
            commentary = generateKanyeQuote();
        }

        return commentary;
    }


    public String generateChessMove()
    {
        String r = "";

        //int index = ThreadLocalRandom.current().nextInt(min, max + 1);

        int random_piece = ThreadLocalRandom.current().nextInt(0, pieces.size());
        int random_letter = ThreadLocalRandom.current().nextInt(0, letters.size());
        int random_number = ThreadLocalRandom.current().nextInt(1, 9);

        r = "Move your "+pieces.get(random_piece)+" to "+letters.get(random_letter)+random_number+"!";

        return r;
    }

    public String generateCompliments()
    {
        String r = "";

        int random_index = ThreadLocalRandom.current().nextInt(0, compliments.size());
        r = compliments.get(random_index);

        return r;
    }

    public String generateInsults()
    {
        String r = "";

        int random_index = ThreadLocalRandom.current().nextInt(0, insults.size());
        r = insults.get(random_index);

        return r;
    }

    public String generateKanyeQuote()
    {
        String r = "";

        int random_index = ThreadLocalRandom.current().nextInt(0, kanye_quotes.size());
        r = kanye_quotes.get(random_index);

        return r;
    }

    // Allows the method of this class to be accessed by other controllers
    private static KitbitzerController instance;
    public KitbitzerController()
    {
        instance = this;
    }
    // static method to get instance of view
    public static KitbitzerController getInstance()
    {
        return instance;
    }
}
