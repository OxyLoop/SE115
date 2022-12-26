import java.util.Scanner;

public class Player{
    public static void scroll(Cards[] playerHand){
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


    public static int play(Cards[] playerHand, Cards[] table, int topofTable, Cards[] playerWonCards, Cards[] playerpişti ){
        int playerwoncards = 0;
        boolean valid = true;
        Scanner sc = new Scanner(System.in);
        
        
        if(table[topofTable]==null){
            System.out.println("No card on the table");
        }else if (topofTable==1){
            System.out.println("One card on the table. You have chance to make PISTI");
            System.out.println(table[topofTable].type +"-"+ table[topofTable].number);
        }
        else{
            System.out.println(table[topofTable].type +"-"+ table[topofTable].number);
        }
        System.out.println("...................");
        
        for(int i=0; i<4;){
            if(playerHand[i]==null) break;
            else {
                System.out.println(i+1 +"-"+ playerHand[i].type +"-"+ playerHand[i].number);
                i++;
            }
        }
        
        System.out.print("Write number to play:");
        int playcard = sc.nextInt()-1;
        
        while(valid){
                if(playerHand[playcard]!=null) break;
                else{
                    System.out.println("Please write valid number");
                    System.out.print("Write number to play:");
                    playcard = sc.nextInt()-1;
                }            
            }
        
            if (table[topofTable]==null){ 
                table[topofTable]=playerHand[playcard];
                playerHand[playcard]=null;
                
            }else if(table[topofTable].getNumber().equals(playerHand[playcard].getNumber()) || playerHand[playcard].getNumber().equals("Joker")){
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
                table[topofTable+1]=playerHand[playcard];
                playerHand[playcard]=null;
                topofTable++;    
            } 
        
        if(playerwoncards!=0){
        System.out.println("You won "+(playerwoncards+1)+" cards.");
        }
        return topofTable;
    }


    public static int pistiScore(Cards[] playerpişti, int scoreOfPlayer, int playerwoncards){
        for(int i=0; i<51; i++){
            if(playerpişti[i]==null) continue;
            scoreOfPlayer = scoreOfPlayer +5;
            }
            return scoreOfPlayer;
        }


    public static int woncardsnumber(Cards[] playerWonCards, int playerwoncards){
        for(int i=0; i<52;i++){
            if(playerWonCards[i]!=null){
                playerwoncards++;
            } else{}
        }
        return playerwoncards;
    }


}