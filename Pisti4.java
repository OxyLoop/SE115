import java.util.Scanner;
import java.util.Random;


public class Pisti4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random r = new Random(System.currentTimeMillis());
/////////////////////////////////////////////////////////
        Cards Cards = new Cards();
        Cards[] deck = new Cards[52];
        Cards[] playerHand = new Cards[5];
        Cards[] computerHand = new Cards[5];
        Cards[] table = new Cards[53];
        Cards[] playerWonCards = new Cards[52];
        Cards[] computerWonCards = new Cards[52];


        int computerwoncards=0;
        int deckcardCounter=0;
        int topofTable = 0;
        boolean gameContinue = true;
        
        
//////////////////////////////////////////////////////////// 
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
//////////////////////////////////////////////////////////////////
        Cards.shuffle(deck);
        System.out.print("Write number to cut:");
        int cutvalue = sc.nextInt();
        Cards.cut(deck,cutvalue);      
/////////////////////////////////////////////////////////////////////////////////
        for(int i=0; i<52; i++){
            System.out.println(deck[i].type +"-"+ deck[i].number);
            
        }
////////////////////////////////////////////////////////////////////////////////
        System.out.println("...................");
        deckcardCounter = Cards.deal(deck,computerHand,playerHand,deckcardCounter);
            
            

////////////////////////////////////////////////////////////////////////////////////////
            for(int i=0; i<4; i++){
                System.out.println(computerHand[i].type +"-"+ computerHand[i].number);
            }
            System.out.println("...................");
            for(int i=0; i<4; i++){
                System.out.println(playerHand[i].type +"-"+ playerHand[i].number);
            }
////////////////////////////////////////////////////////////////////////////////////////////
    // writing top card on board;
            for(int i=1; i<5;i++){
                table[i] = deck[deckcardCounter];
                deckcardCounter++;
                topofTable=i;
            }
            System.out.println("...................");
            
///////////////////////////////////////////////////////////////////////////////////////
//player turn;
            while (gameContinue){
                if(computerHand[0]==null){
                    System.out.println("Dealing new cards.");
                    deckcardCounter = Cards.deal(deck,computerHand,playerHand,deckcardCounter);
                }

                topofTable = Player.play(playerHand,table,topofTable,playerWonCards);
                Player.scroll(playerHand);
                
                if(table[topofTable]!=null){
                System.out.println(table[topofTable].type +"-"+ table[topofTable].number);
                } else{
                    System.out.println("table is empty");
                }
                System.out.println("top of table is "+topofTable);


                topofTable = Ai.play(computerHand,table,topofTable,computerwoncards,computerWonCards);
                Ai.scroll(computerHand);
                for(int i=0; i<4;){
                    if(computerHand[i]==null) break;
                    else {
                        int a = i+1;
                        System.out.println("ai "+ a +"-"+ computerHand[i].type +"-"+ computerHand[i].number);
                        i++;
                    }
                }
                System.out.println("...................");
                System.out.println("deckcardcounter is "+deckcardCounter);
                
                if(deckcardCounter==51){
                    System.out.println("Game Over!");
                    gameContinue = false;
                }
            }

            
            
            
            
            
    
    










    }
}       