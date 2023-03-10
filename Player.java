import java.util.Scanner;
import java.util.Formatter;
import java.io.FileWriter;

public class Player{
    public static void scroll(Cards[] playerHand){
        //scrolling player hand for null places
        for(int i=0; i<4;){
            if(playerHand[i]==null){
                if(playerHand[i]==null && playerHand[i+1]==null){
                    break;
                }
                playerHand[i]=playerHand[i+1];
                playerHand[i+1]=null;
            }else{
                i++;
            }
        }
    }

//..........................................................................
    public static int play(Cards[] playerHand, Cards[] table, int topofTable, Cards[] playerWonCards, Cards[] playerpişti ){
        int playerwoncards = 0;
        int playcard = 0;
        
        //.............................SHOWING PLAYER TOP OF TABLE .....................................
        if(table[topofTable]==null){
            System.out.println("No card on the table");
        }else if (topofTable==1){
            System.out.println("One card on the table. You have chance to make PISTI");
            System.out.println(table[topofTable].type +"-"+ table[topofTable].number);
        }
        else{
            System.out.println("There are "+ topofTable+" cards on table.");
            System.out.println(table[topofTable].type +"-"+ table[topofTable].number);
        }
        System.out.println("...................");
        
        //showing player hand
        for(int i=0; i<4;){
            if(playerHand[i]==null) break;
            else {
                System.out.println(i+1 +"-"+ playerHand[i].type +"-"+ playerHand[i].number);
                i++;
            }
        }
        
        //.............................TAKING INPUT FOR PLAY.....................................
        for(;;){
            playcard = takeInput(); 
            if(playcard<4 && playcard>=0){
                if(playerHand[playcard]!=null){
                    //playcard -1;
                    break;
                } 
            } else {
            }
            System.out.println("Please write number near your cards.");
        }
        
        //.............................PLAYER PLAY TURN.....................................
            if (table[topofTable]==null){ 
                table[topofTable]=playerHand[playcard];
                playerHand[playcard]=null;
                
            }else if(table[topofTable].getNumber().equals(playerHand[playcard].getNumber()) || playerHand[playcard].getNumber().equals("Joker")){
                //if pişti
                if(topofTable==1 && playerHand[playcard].getNumber()!="Joker"){
                    System.out.println("You make PİSTİ");
                    table[topofTable+1]=playerHand[playcard];
                    playerHand[playcard]=null;
                    topofTable++;
                    for(int i=1; i<=topofTable;i++){
                        if(playerpişti[playerwoncards]!=null){
                            playerwoncards++;
                            i = i-1;
                        }else{
                        playerpişti[playerwoncards]=table[i];
                        table[i]= null;
                        }    
                    }
                }else{
                // if player played same card number
                System.out.println("You take table cards");
                table[topofTable+1]=playerHand[playcard];
                playerHand[playcard]=null;
                topofTable++;
                    for(int i=1; i<=topofTable;i++){
                        if(playerWonCards[playerwoncards]!=null){
                            playerwoncards++;
                            i = i-1;
                        }else{
                        playerWonCards[playerwoncards]=table[i];
                        table[i]= null;
                        }    
                    }
                }
                
                topofTable=1;
                
            }
            else {
                //player card adding to the top of table
                table[topofTable+1]=playerHand[playcard];
                playerHand[playcard]=null;
                topofTable++;    
            } 
        
        if(playerwoncards!=0){
        System.out.println("You won "+(playerwoncards+1)+" cards.");
        }
        return topofTable;
    }

//..........................................................................
    public static int pistiScore(Cards[] playerpişti, int scoreOfPlayer, int playerwoncards){
        // calculating pişti number 
        for(int i=0; i<51; i++){
            if(playerpişti[i]==null) continue;
            scoreOfPlayer = scoreOfPlayer +5;
            }
            return scoreOfPlayer;
        }

//..........................................................................
    public static int woncardsnumber(Cards[] playerWonCards, int playerwoncards){
        // calculating how many cards have in this array
        for(int i=0; i<52;i++){
            if(playerWonCards[i]!=null){
                playerwoncards++;
            } else{}
        }
        return playerwoncards;
    }

//..........................................................................
    public static int specialcards(Cards[] playerWonCards, Cards[] playerpişti, int scoreOfPlayer){
        //checking special cards for player won cards array
        for(int i=0; i<52; i++){
            if(playerWonCards[i]==null) continue;
            if(playerWonCards[i].getType().equals("Diamond") && playerWonCards[i].getNumber().equals("10")){
                scoreOfPlayer = scoreOfPlayer +3;
            }
            if(playerWonCards[i].getType().equals("Club") && playerWonCards[i].getNumber().equals("2")){
                scoreOfPlayer = scoreOfPlayer +2;
            }
        }
        //checking special cards for player won cards array
        for(int i=0; i<52; i++){
            if(playerpişti[i]==null) continue;
            if(playerpişti[i].getType().equals("Diamond") && playerpişti[i].getNumber().equals("10")){
                scoreOfPlayer = scoreOfPlayer +3;
            }
            if(playerpişti[i].getType().equals("Club") && playerpişti[i].getNumber().equals("2")){
                scoreOfPlayer = scoreOfPlayer +2;
            }
        }
        return scoreOfPlayer;
    }

//..........................................................................
    public static int takeInput (){
        Scanner sc = new Scanner(System.in);
        int input =0;
        //taking input for checking exception
        for(;;){
                System.out.print("Write number to play:");  
            try{
                input = Integer.parseInt(sc.nextLine()) -1;
                break;   
            } catch (Exception e){
                System.out.println("Please write a number:");
            } 
        }
        return input;
    }


}