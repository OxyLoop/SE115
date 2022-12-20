import java.util.Random;

public class Ai{
    public static void scroll(Cards[] computerHand){
        for(int i=0; i<4;){
            if(computerHand[i]==null){
                if(computerHand[i]==null && computerHand[i+1]==null){
                    break;
                }
                computerHand[i]=computerHand[i+1];
                computerHand[i+1]=null;
            }else{
                i++;
            }
        }
    }
    
    
    public static int play(Cards[] computerHand, Cards[] table, int topofTable, int computerwoncards, Cards[] computerWonCards){
        if(table[topofTable]==null){
            Random r = new Random(System.currentTimeMillis());
            int airandom = r.nextInt(4);
            System.out.println(airandom+1);
            table[topofTable+1]=computerHand[airandom];
            computerHand[airandom] = null;
            topofTable++;
        }
        for(int i=0; i<4;){
            if(computerHand[i]==null) break;
            else {
                int a = i+1;
                System.out.println("ai "+ a +"-"+ computerHand[i].type +"-"+ computerHand[i].number);
                i++;
            }
        }
        for(int i=0; i<4; i++){
            if(computerHand[i]==null) break;    
            else if(table[topofTable].getNumber().equals(computerHand[i].getNumber())){
                System.out.println("Computer take table cards");
                table[topofTable+1] = computerHand[i];
                computerHand[i] = null;
                topofTable++;
                for(int j=0; j<=topofTable;j++){
                    computerWonCards[j]=table[j];
                    table[j]= null;
                    computerwoncards++;
                }
                return topofTable;
            }
            
        }
        for(int i=0; i<4; i++){
            if(computerHand[i]==null){
                break;
            }
            if(computerHand[i].number=="Joker"){
                System.out.println("Computer uses it's joker cards");
                table[topofTable] = computerHand[i];
                computerHand[i] = null;
                topofTable++;
                for(int j=0; i<=topofTable;j++){
                    computerWonCards[j]=table[j];
                    table[j]= null;
                    computerwoncards++;
                }
                return topofTable;
            } 
        }

        Random r = new Random(System.currentTimeMillis());
        int aiselect = r.nextInt(4);
        System.out.println(aiselect+1);
        table[topofTable+1] = computerHand[aiselect];
        computerHand[aiselect] = null;
        topofTable++;

        return topofTable;
    }  
}
