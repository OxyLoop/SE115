import java.util.Scanner;
import java.util.Random;


public class Pisti4{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random r = new Random(System.currentTimeMillis());
/////////////////////////////////////////////////////////
        Cards Card = new Cards();
        Cards[] deck = new Cards[52];
        Cards[] playerHand = new Cards[5];
        Cards[] computerHand = new Cards[5];
        Cards[] table = new Cards[52];
        Cards[] playerWonCards = new Cards[52];
        Cards[] computerWonCards = new Cards[52];


        int playerwoncards=0;
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
        for(int i=0; i<52; i++){
            int n1 = r.nextInt(52);
            int n2 = r.nextInt(52);
            Cards yedekd ;
            yedekd = deck[n1];
            deck[n1]= deck[n2];
            deck[n2] = yedekd; 
        }
/////////////////////////////////////////////////////////////////////////////
            int cutvalue = sc.nextInt();
            int cutCounter=0;

            Cards[] yedekDeck = new Cards[52];
            for (int i = 0; i<52; i++) {
                if(cutvalue+i==52) break;
                yedekDeck[i] = deck[cutvalue+i];
                cutCounter++;
            }
            for (int i=0; i<cutvalue; i++){
                yedekDeck[cutCounter] =  deck[i];
                cutCounter++;
            }
            for(int i=0; i<52; i++){
                deck[i]= yedekDeck[i];
            }
/////////////////////////////////////////////////////////////////////////////////
            for(int i=0; i<52; i++){
                System.out.println(deck[i].type +"-"+ deck[i].number);
                
            }
            System.out.println("...................");
////////////////////////////////////////////////////////////////////////////////
            
            for(int i=0; i<4;i++){
                computerHand[i]=deck[2*i];
                playerHand[i]=deck[2*i+1]; 
                deckcardCounter = deckcardCounter+2;
            }
            

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
            for(int i=0; i<4;i++){
                table[i] = deck[deckcardCounter];
                deckcardCounter++;
                topofTable=i;
            }
            System.out.println("...................");
            
///////////////////////////////////////////////////////////////////////////////////////
//player turn;
            while (gameContinue){
                
                if(table[topofTable]==null){
                    System.out.println("No card on the table");
                }else{
                    System.out.println(table[topofTable].type +"-"+ table[topofTable].number);
                }
                    System.out.println("...................");
                    for(int i=0; i<4;){
                        if(playerHand[i]==null){
                            if(playerHand[i]==null && playerHand[i+1]==null){
                                break;
                            }
                            playerHand[i]=playerHand[i+1];
                            playerHand[i+1]=null;
                        }else{
                            System.out.println(playerHand[i].type +"-"+ playerHand[i].number);
                            i++;
                        }
                    }
                    ///////////////////////////////////////////////////////////////////////////////////
                    System.out.print("Write number 1-4 to play:");
                    int playcard = sc.nextInt()-1;
                    if(playerHand[playcard]!=null){
                        if (table[topofTable]==null){ 
                            table[topofTable]=playerHand[playcard];
                            playerHand[playcard]=null;
                            topofTable++;
                        }
                        else if(table[topofTable].getNumber().equals(playerHand[playcard].getNumber())){
                            System.out.println("You make PİSTİ");
                            table[topofTable+1]=playerHand[playcard];
                            playerHand[playcard]=null;
                            topofTable++;
                                for(int i=0; i<=topofTable;i++){
                                    playerWonCards[i]=table[i];
                                    table[i]= null;
                                    playerwoncards++;
                                }
                            topofTable=0;
                            
                        }
                        else {
                            table[topofTable+1]=playerHand[playcard];
                            playerHand[playcard]=null;
                            topofTable++;    
                            } 
                        
                        System.out.println(playerwoncards);
                    }else{
                        continue;
                    }
             
            }
            
            
            
            
    
    










    }
}       