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


    public static int play(Cards[] playerHand, Cards[] table, int topofTable, Cards[] playerWonCards ){
        int playerwoncards = 0;
        boolean valid = true;
        Scanner sc = new Scanner(System.in);
        
        if(table[topofTable]==null){
            System.out.println("No card on the table");
        }else{
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
                if(topofTable==1){
                    System.out.println("You make PİSTİ");
                }else{
                System.out.println("You take table cards");
                }
                table[topofTable+1]=playerHand[playcard];
                playerHand[playcard]=null;
                topofTable++;
                    for(int i=1; i<=topofTable;i++){
                        playerWonCards[playerwoncards]=table[i];
                        table[i]= null;
                        playerwoncards++;
                    }
                topofTable=1;
                
            }
            else {
                table[topofTable+1]=playerHand[playcard];
                playerHand[playcard]=null;
                topofTable++;    
            } 
        
        
        System.out.println("You won "+playerwoncards+" cards.");
        return topofTable;
    }


}