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


    public static int play(Cards[] playerHand, Cards[] table, int topofTable, int playerwoncards, Cards[] playerWonCards ){
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
        if(playerHand[playcard]!=null){
            if (table[topofTable]==null){ 
                table[topofTable+1]=playerHand[playcard];
                playerHand[playcard]=null;
                topofTable++;
                
            }
            else if(table[topofTable].getNumber().equals(playerHand[playcard].getNumber()) || playerHand[playcard].number=="Joker"){
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
            
            System.out.println(playerwoncards-1);//ortadaki array 0dan başlamıyor.
        }else{
        }
        return topofTable;
    }


}