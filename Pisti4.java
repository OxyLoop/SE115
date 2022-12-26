import java.util.Scanner;
import java.util.Random;


public class Pisti4{
    public static void main(String[] args){
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


        int scoreOfPlayer=0;
        int playerwoncards = 0;
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
//.............................CUTTING THE DECK........................................
        System.out.print("Write number to cut:");
        int cutvalue = sc.nextInt();
        Cards.cut(deck,cutvalue);   
        for(int i=0; i<52; i++){
            System.out.println(deck[i].type +"-"+ deck[i].number);
        }   
//............................DEALİNG CARDS................................................
        System.out.println("...................");
        deckcardCounter = Cards.deal(deck,computerHand,playerHand,deckcardCounter);
            
            

//.................................PRİNTİNG COMPUTER AND PLAYER HAND FOR TESTİNG......SİLİNCEK.
            for(int i=0; i<4; i++){
                System.out.println(computerHand[i].type +"-"+ computerHand[i].number);
            }
            System.out.println("...................");
            for(int i=0; i<4; i++){
                System.out.println(playerHand[i].type +"-"+ playerHand[i].number);
            }
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

                //ai playing
                topofTable = Ai.play(computerHand,table,topofTable,computerWonCards);
                //scrolling ai card to the null place
                Ai.scroll(computerHand);

                if(table[topofTable]!=null){
                    System.out.println("Ai played "+table[topofTable].type +"-"+ table[topofTable].number);
                    } else{
                        System.out.println("table is empty after ai played");
                    }
                
                
                System.out.println("...................");
                
                if(deckcardCounter==52 && computerHand[0]==null ){
                    System.out.println("Game Over!");
                    gameContinue = false;
                }
            }
            
            scoreOfPlayer = Player.pistiScore(playerpişti, scoreOfPlayer, playerwoncards);
            playerwoncards = Player.woncardsnumber(playerWonCards, playerwoncards);
            for(int i=0; i<52; i++){
                if(playerpişti[i]==null) continue;
                playerwoncards++;
            }
            computerwoncards = Ai.woncardsnumberai(computerWonCards, computerwoncards);

            if(playerwoncards>computerwoncards){
                scoreOfPlayer = scoreOfPlayer +3;
            }

            System.out.println("masadaki kartlar"+topofTable);
            System.out.println("COMPUTER CARDS"+computerwoncards);
            System.out.println("PLAYER CARDS"+playerwoncards);
            System.out.println("Your score is"+scoreOfPlayer);
        




            
            
            
            
            
    
    










    }
}       