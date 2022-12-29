import java.util.Scanner;
import java.util.Random;


public class Pisti4{
    public static void main(String[] args){
        System.out.println("WELCOME PISTI GAME");
        Scanner sc = new Scanner(System.in);
        Random r = new Random(System.currentTimeMillis());
//........................CREATING ARRAYS AND PRIMATIVES...............................
        Cards Cards = new Cards();
        Cards[] deck = new Cards[52];
        Cards[] playerHand = new Cards[5];
        Cards[] computerHand = new Cards[5];
        Cards[] table = new Cards[53];
        Cards[] playerWonCards = new Cards[52];
        Cards[] playerpişti = new Cards[52];
        Cards[] computerWonCards = new Cards[52];
        Cards[] computerpişti = new Cards[52];


        int scoreOfPlayer=0;
        int playerwoncards = 0;
        int scoreOfComputer = 0;
        int computerwoncards = 0;
        int deckcardCounter=0;
        int topofTable = 0;
        boolean gameContinue = true;
        
        
//..........................CREATING CARD DECK................................................
        for(int i=0; i<52; i++){
            int a = (i%13) + 1;
            String b;
            if(a==1) {b="Ace";}
            else if(a==11) {b="Joker";}
            else if(a==12) {b="Queen";}
            else if(a==13) {b="King";}
            else { b = String.valueOf(a);}
            if(0<=i && i<13){
                deck[i]= new Cards("Club", b);  
            } else if(13<=i && i<26){
                deck[i]= new Cards("Spade", b);
            } else if(26<=i && i<39){
                deck[i]= new Cards("Heart", b);
            } else{
                deck[i]= new Cards("Diamond", b); 
            }
        
        }
//.............................SHUFFLING THE DECK.......................................
        Cards.shuffle(deck);
//.............................CUTTING THE DECK WITH TRY CATCH........................................
        int cutvalue = 0;

        for(;;){
                System.out.print("Write number to cut the deck:");  
            try{
                cutvalue = Integer.parseInt(sc.nextLine());
                Cards.cut(deck,cutvalue);
                break;   
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Please write a number between 1 to 52");
            }
            catch (Exception e){
                System.out.println("Please write a number.");
            } 
        }
    //............................DEALİNG CARDS................................................
            System.out.println("...................");
            deckcardCounter = Cards.deal(deck,computerHand,playerHand,deckcardCounter);
                
    //...............................DEALİNG CARDS TO THE TABLE............................
                for(int i=1; i<5;i++){
                    table[i] = deck[deckcardCounter];
                    deckcardCounter++;
                    topofTable=i;
                }
                System.out.println("...................");
                
    //.............................START OF THE GAME.....................................
                while (gameContinue){
                    //dealing cards if player and computer hand is empty
                    if(computerHand[0]==null){
                        System.out.println("Dealing new cards.");
                        deckcardCounter = Cards.deal(deck,computerHand,playerHand,deckcardCounter);
                    }
                    //printing top card on the table and player playing
                    topofTable = Player.play(playerHand,table,topofTable,playerWonCards,playerpişti);
                    //scrolling player card to the null place
                    Player.scroll(playerHand);
                    System.out.println("...................");
    
                    //ai playing
                    topofTable = Ai.play(computerHand,table,topofTable,computerWonCards,computerpişti);
                    //scrolling ai card to the null place
                    Ai.scroll(computerHand);
                    
                    //writing ai play for player
                    if(table[topofTable]!=null){
                        System.out.println("Ai played "+table[topofTable].type +"-"+ table[topofTable].number);
                        } else{
                            System.out.println("table is empty after ai played");
                        }
                    
                    
                    System.out.println("...................");
                    //end game while finisher
                    if(deckcardCounter==52 && computerHand[0]==null ){
                        System.out.println("Game Over!");
                        gameContinue = false;
                    }
                }
    //.............................CALCULATING SCORE.....................................
                //Calculate player's pişti score 
                scoreOfPlayer = Player.pistiScore(playerpişti, scoreOfPlayer, playerwoncards);
                //Calculating player's won cards number
                playerwoncards = Player.woncardsnumber(playerWonCards, playerwoncards);
                //adding pişti cards number to player won cards number
                for(int i=0; i<52; i++){
                    if(playerpişti[i]==null) continue;
                    playerwoncards++;
                }
                
                
                //Calculate computer's pişti score 
                scoreOfComputer = Player.pistiScore(computerpişti, scoreOfComputer, computerwoncards);
                //Calculating computer's won cards number
                computerwoncards = Ai.woncardsnumberai(computerWonCards, computerwoncards);
                //adding pişti cards number to computer won cards number
                for(int i=0; i<52; i++){
                    if(computerpişti[i]==null) continue;
                    computerwoncards++;
                }
                //adding number of won cards to score of player and computer
                scoreOfPlayer = scoreOfPlayer + playerwoncards;
                scoreOfComputer = scoreOfComputer + computerwoncards;
                
                
                // adding score compare card number points
                if(playerwoncards>computerwoncards){
                    scoreOfPlayer = scoreOfPlayer +3;
                } else{
                    scoreOfComputer = scoreOfComputer +3;
                }
                
                //checking special cards
                scoreOfPlayer = Player.specialcards(playerWonCards, playerpişti, scoreOfPlayer);
                scoreOfComputer = Player.specialcards(computerWonCards, computerpişti, scoreOfComputer);
                
                
    //.............................END GAME STRINGS.....................................
                System.out.println("...................");
                System.out.println("You have:"+playerwoncards+" cards.");
                System.out.println("Computer has:"+computerwoncards+" cards.");
                System.out.println("...................");
                System.out.println("Your score is: "+scoreOfPlayer);
                System.out.println("Computer score is: "+scoreOfComputer);
                if(scoreOfPlayer>scoreOfComputer){
                    System.out.println("YOU WON!");
                } else if (scoreOfPlayer<scoreOfComputer){
                    System.out.println("YOU LOSE!");
                }else{
                    System.out.println("You are very lucky person, YOU AND THE COMPUTER IS TIE");
                }
        
    }
}       