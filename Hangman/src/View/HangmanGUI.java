package View;

import Controller.*;
import Model.Player;

//import javax.*;

import java.util.*;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;

public class HangmanGUI {

//    static String secretWord;
    static Integer numOfPlayers;
    public HangmanGUI() {
        // Ask the player to play hangman		
        hangmanFirst();
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new HangmanGUI();
        
    }
    
    public void hangmanFirst()
	{
		JFrame frame11 = new JFrame("Welcome to Hangman !");
		frame11.setVisible(true);
		frame11.setSize(new Dimension(300, 200));
		JPanel panel1 =new JPanel();
		frame11.add(panel1);
		JButton playButton = new JButton("Play Hangman");
		panel1.add(playButton);
		playButton.addActionListener(new hangmanFirstFrame());
	}
}
    //Agree to Play hangman and you will be navigated to the frame asking Secret word

class Players 
{
    Integer numOfTries = 0;
    
    
}
    class hangmanFirstFrame implements ActionListener 
    {
        public hangmanFirstFrame() {
        }

        public void actionPerformed(ActionEvent e) {

        final JFrame frame1 = new JFrame("Welcome to Hangman !");
        frame1.setVisible(true);
        frame1.setSize(new Dimension(300, 200));
        final JPanel panel1 = new JPanel();
        frame1.add(panel1);
             
        JLabel label1 = new JLabel("Choose # of Players(1-4): ");
        panel1.add(label1);
        final TextField numOfPlayers = new TextField(1);
        panel1.add(numOfPlayers);
        
        final JButton contButton = new JButton("Play Hangman");
        //playButton.show(false);
        panel1.add(contButton);
        
        numOfPlayers.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String input2 = numOfPlayers.getText();
                    
                    boolean badData = false;
                    for (int x = 0; x < input2.length(); x++) {
                        if (!(input2.charAt(x) > 47 && input2.charAt(x) < 58)) {
                            badData = true;
                            break;
                        }
                    }
                    if (badData) {
                        JOptionPane.showMessageDialog(null, "Number cannot contain Letters!");
                        //badData = false;
                    }
                    //making sure no spaces are entered
                    if (input2.trim().equals("") == true) {
                        JOptionPane.showMessageDialog(null, "Number cannot contain spaces");
                    } else if (input2.length() < 1) {
                        JOptionPane.showMessageDialog(null, "Number must be atleast 1 characters long");
                    } else if (Integer.parseInt(input2) > 4 || Integer.parseInt(input2) < 1) {
                        JOptionPane.showMessageDialog(null, "Number must be between 1-4");
                    } else {
                        //playButton.show(true);
                        contButton.addActionListener(new hangmanSecondFrame(frame1, input2));
                    }
                }
            });             
    }


    class hangmanSecondFrame implements ActionListener {

        JFrame currentFrame;
        String nop;
        //final String input = "", input2 = "";     
//		public String getSecretWord() {
//			return secretWord;
//		}
//		public void setSecretWord(String secretWord) {
//			this.secretWord = secretWord;
//		}
//                public Integer getNumOfTries() {
//                        return numOfTries;
//                }
//                public void setNumOfTries(Integer numOfTries) {
//                        this.numOfTries = numOfTries;
//                }

        public hangmanSecondFrame() {
        }

        public hangmanSecondFrame(JFrame currentFrame, String n) {
            this.currentFrame = currentFrame;
            nop = n;
        }

        public void actionPerformed(ActionEvent e) {
            //Closes the previous frame
            this.currentFrame.dispatchEvent(new WindowEvent(this.currentFrame, WindowEvent.WINDOW_CLOSING));
            //Creation of current Frame
            final JFrame frame2 = new JFrame("Press Enter after typing text");
            frame2.setVisible(true);
            frame2.setSize(new Dimension(300, 200));
            JPanel panel2 = new JPanel();
            JLabel label2 = new JLabel("Enter Secret Word:");
            frame2.add(panel2);
            panel2.add(label2);

            //Secret words should be maximum 15 characters long
            final TextField secretWordEnter = new TextField(15);
            secretWordEnter.setEchoChar('*');
            panel2.add(secretWordEnter);
            //Validating the secret word with respect to user requirements
            //At the end navigates to the hangman Third frame
            secretWordEnter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub

                    String input = secretWordEnter.getText().trim();
                    //making sure no spaces are entered
                    boolean badData = false;
                    for (int x = 0; x < input.length(); x++) {
                        if (input.charAt(x) < 65 || (input.charAt(x) > 90 && input.charAt(x) < 97) || (input.charAt(x) > 122)) {
                            badData = true;
                            break;
                        }
                    }
                    if (badData) {
                        JOptionPane.showMessageDialog(null, "Word cannot contain Numbers!");
                        //badData = fa                                                                          `lse;
                    }
                    if (input.trim().equals("") == true) {
                        JOptionPane.showMessageDialog(null, "Word cannot contain spaces");
                    } else if (input.length() < 3 || input.length() > 15) {
                        JOptionPane.showMessageDialog(null, "Word must be atleast 3 - 15 characters long");
                    }

                }
            });

            //enter number of misses allowed
            JLabel label3 = new JLabel("Enter number of Tries:");
            final TextField numOfTriesEnter = new TextField(2);
            //numOfTriesEnter.setEchoChar('*');	
            panel2.add(label3);
            panel2.add(numOfTriesEnter);

            //Validating the secret word with respect to user requirements
            //At the end navigates to the hangman Third frame
            numOfTriesEnter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String input = secretWordEnter.getText();
                    String input2 = numOfTriesEnter.getText();
                    
                    boolean badData = false;
                    for (int x = 0; x < input2.length(); x++) {
                        if (!(input2.charAt(x) > 47 && input2.charAt(x) < 58)) {
                            badData = true;
                            break;
                        }
                    }
                    if (badData) {
                        JOptionPane.showMessageDialog(null, "Number cannot contain Letters!");
                        //badData = false;
                    }
                    //making sure no spaces are entered
                    if (input2.trim().equals("") == true) {
                        JOptionPane.showMessageDialog(null, "Number cannot contain spaces");
                    } else if (input2.length() < 1) {
                        JOptionPane.showMessageDialog(null, "Number must be atleast 1 characters long");
                    } else if (Integer.parseInt(input2) < 2 || Integer.parseInt(input2) > 5) {
                        JOptionPane.showMessageDialog(null, "Number must be between 2 and 5");
                    } else {
                        hangmanThirdFrame hTF = new hangmanThirdFrame(frame2, input, input2, nop);
                    }
                }
            });
        }
    }

    class hangmanThirdFrame {

        String guessInput = "";
        String tempSecretWord = "";
        String numOfTries = "";
        Integer numOfPlayers;
        List<String> temp = null;
        JLabel blank[] = new JLabel[20];
        hangmanSecondFrame hSF = new hangmanSecondFrame();

        public hangmanThirdFrame(JFrame frame2, String s1, String s2, String n) {
            tempSecretWord = s1;
            numOfTries = s2;
            numOfPlayers = Integer.parseInt(n);
            frame2.dispatchEvent(new WindowEvent(frame2, WindowEvent.WINDOW_CLOSING));
            final JFrame frame3 = new JFrame();
            frame3.setVisible(true);
            frame3.setSize(new Dimension(300, 200));
            final JPanel panel3 = new JPanel();
            frame3.add(panel3);
//            Players p = new Players();
//            p.numOfTries = Integer.parseInt(s2);
            
            
            panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 5));

            JLabel noOfTries = new JLabel("Tries Remaining:");
            panel3.add(noOfTries);
            final JTextField triesRemaining = new JTextField(4);
            triesRemaining.setEditable(false);
            triesRemaining.setText(numOfTries);
            panel3.add(triesRemaining);
            //layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(noOfTries));

            JLabel guess = new JLabel("Guess Letter:");
            panel3.add(guess);
            final JTextField guessLetter = new JTextField(1);
            panel3.add(guessLetter);
            
            JLabel play = new JLabel("Player:");
            panel3.add(play);
            final JTextField playnumber = new JTextField(1);
            playnumber.setEditable(false);
            playnumber.setText("1");
            panel3.add(playnumber);
            
            final Game hangmanGame = new Game(numOfPlayers, Integer.parseInt(numOfTries));
                hangmanGame.setWord(tempSecretWord); 
                hangmanGame.switchPlayers();
//            } else {
//                hangmanGame = new Game();
//                hangmanGame.setWord(tempSecretWord);
//            }
//            
     
                for (int space = 0; space < 15; space++) {
                    JLabel space1 = new JLabel(" ");
                    panel3.add(space1);
                }
                for (int insBlank = 0; insBlank < tempSecretWord.length(); insBlank++) {
                    JLabel temp = new JLabel("_");
                    blank[insBlank] = temp;
                    panel3.add(blank[insBlank]);
                }
                
                final JLabel playerandTries = new JLabel("Player 1 your turn!");
                panel3.add(playerandTries);

                
                for (int nn = 0; nn < numOfPlayers; nn++) {
                    hangmanGame.players[nn].setNumOfTries(Integer.parseInt(numOfTries));
                }
                guessLetter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
//                        String playerNum = "Player ";
                        
                        Player pNow = hangmanGame.switchPlayers();
                        temp = hangmanGame.statusOfGame().get("Misses");
                        //int missesRemaining = Integer.parseInt(numOfTries) - hangmanGame.getTotalMisses();
                        playerandTries.setText("Player " + pNow.getPlayerName() + " you have " + pNow.getNumOfTries() + " tries remaining");        
                        int missesRemaining = pNow.getNumOfTries() - hangmanGame.getTotalMisses();
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(missesRemaining);
                        String misses = sb.toString();
                        triesRemaining.setText(Integer.toString(pNow.getNumOfTries()));
                        playnumber.setText(pNow.getPlayerName());
                        //panel3.add(playerNames);
                        
                        guessInput = guessLetter.getText();
//                        JLabel playerNames = new JLabel(playerNum);
//                        panel3.add(playerNames);
                        
                        boolean tet = hangmanGame.guessLetter(guessInput);
                        if (tet) {
                            JOptionPane.showMessageDialog(null, "Correct Guess");
                        } else {
                            JOptionPane.showMessageDialog(null, "Wrong guess");
                        }
                        
                        temp = hangmanGame.statusOfGame().get("Progress");

                        for (int x = 0; x < temp.size(); x++) {
                            String a = temp.get(x);
                            if (guessInput.length() == 1) {
                                blank[x].setText(a);
                            } else {
                                JOptionPane.showMessageDialog(null, "Close this dialog box and Enter only one character in textfield");
                            }
                        }                      
                        if (hangmanGame.isGameOver() != null) { //temp.size() == tempSecretWord.length()
                            JOptionPane.showMessageDialog(null, hangmanGame.isGameOver());
                            frame3.dispatchEvent(new WindowEvent(frame3, WindowEvent.WINDOW_CLOSING));
                        } 
//                        else if (hangmanGame.isGameOver() == null && temp.size() != tempSecretWord.length()) {
//                            JOptionPane.showMessageDialog(null, "You Lose");
//                            frame3.dispatchEvent(new WindowEvent(frame3, WindowEvent.WINDOW_CLOSING));
//                        }

                    }
                
                });
                          
        }
    }
}
