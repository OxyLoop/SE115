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
            System.out.println("ai select for null "+airandom);
            table[topofTable]=computerHand[airandom];
            computerHand[airandom] = null;
            return topofTable;
        }
        for(int i=0; i<4; i++){
            if(computerHand[i]==null) break;    
            if(table[topofTable].getNumber().equals(computerHand[i].getNumber())){
                System.out.println("Computer take table cards");
                table[topofTable+1] = computerHand[i];
                computerHand[i] = null;
                topofTable++;
                for(int j=1; j<=topofTable;j++){
                    computerWonCards[j]=table[j];
                    table[j]= null;
                    computerwoncards++;
                }
                topofTable=1;
                return topofTable;
            }
            
        }
        for(int i=0; i<4; i++){
            if(computerHand[i]==null) break;
            if(table[topofTable]!=null){
            if(computerHand[i].number=="Joker"){
                System.out.println("Computer uses it's joker cards");
                table[topofTable] = computerHand[i];
                computerHand[i] = null;
                topofTable++;
                for(int j=1; j<=topofTable;j++){
                    computerWonCards[j]=table[j];
                    table[j]= null;
                    computerwoncards++;
                }
                return topofTable;
            }
        } 
        }

        Random r = new Random(System.currentTimeMillis());
        int aiselect = 0;
        for(;;){
        aiselect = r.nextInt(4);
        if(computerHand[aiselect]!=null) break;
        }
        System.out.println("ai select for not null"+aiselect);
        table[topofTable+1] = computerHand[aiselect];
        computerHand[aiselect] = null;
        topofTable++;

        return topofTable;
    }  
}
