package View;

import Controller.*; 
import java.util.Scanner; 
import java.util.List; 

public class HangmanText { 

    public static String replay = "Y"; 
    public static boolean rep = true;
    
    public static void main(String[] args) 
    {   
        do
        {
            Game();
            System.out.println("GAME OVER"); 
            System.out.println("Do you want to play again? Y or N?"); 
            Scanner sc = new Scanner(System.in); 
            rep = sc.nextLine().trim().equalsIgnoreCase("Y") ? true : false;
            System.out.println(rep); 
        }while(rep);            
    } 

    public static void Game()
    {
        Scanner sc = new Scanner(System.in); 
        Game game1 = new Game(); 
        String player1 = "Player 1";
        String playername = "Player 2";
        System.out.println("Welcome to Hangman!"+'\n'); 

        //player 1 chooses name
        System.out.print("Choose your name Player 1: "); 
        playername = sc.nextLine();
        game1.p1.setName(playername != null ? playername : "Player 1");
        // player 2 chooses name
        System.out.print("Choose your name Player 2: "); 
        playername = sc.nextLine();
        game1.p2.setName(playername == "" ? "Player 2" : playername);
        System.out.print(game1.p1.getName() + ", enter secret word: "); 
        game1.setWord(sc.nextLine().trim());

        //Add some spaces to clear the secret word off the screen.
        for(int i = 0; i < 100; i++){
                System.out.println("");
        }

        System.out.println("GUESSING TIME!!"); 
        List<String> temp; 	


        do{ 
                System.out.print(game1.p2.getName() + ", enter letter: "); 
                boolean tet = game1.guessLetter(sc.nextLine()); 
                System.out.println("");

                if(tet) 
                        System.out.println("Correct Guess!"+'\n'); 
                else
                        System.out.println("Wrong"+'\n'); 

                temp = game1.statusOfGame().get("Misses"); 
                System.out.println("Misses Remaining: "+ (6 - game1.getTotalMisses())); 
                System.out.print("Missed Letters: "); 

                for(int x=0;x<temp.size();x++) 
                        System.out.print(temp.get(x)+", "); 

                System.out.println(""); 
                temp = game1.statusOfGame().get("Progress"); 

                for (int x = 0; x < temp.size(); x++)  
                        System.out.print(temp.get(x)+" "); 
                System.out.println(""); 

        }while(game1.isGameOver() == null);
    }
} 
