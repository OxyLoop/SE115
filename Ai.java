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
    
    
    public static int play(Cards[] computerHand, Cards[] table, int topofTable, Cards[] computerWonCards){
        int computerwoncards = 0;
        if(table[topofTable]==null){
            Random r = new Random(System.currentTimeMillis());
            int aiselect = 0;
            for(;;){
                aiselect = r.nextInt(4);
                if(computerHand[aiselect]!=null) break;
            }
            table[topofTable]=computerHand[aiselect];
            computerHand[aiselect] = null;
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
                    if(computerWonCards[computerwoncards]!=null){
                        computerwoncards++;
                        j = j-1;
                    } else {
                    computerWonCards[computerwoncards]=table[j];
                    table[j]= null;
                    }
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
                table[topofTable+1] = computerHand[i];
                computerHand[i] = null;
                topofTable++;
                for(int j=1; j<=topofTable;j++){
                    if(computerWonCards[computerwoncards]!=null){
                        computerwoncards++;
                        j = j-1;
                    } else{
                    computerWonCards[computerwoncards]=table[j];
                    table[j]= null;
                    }
                }
                topofTable=1;
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
        table[topofTable+1] = computerHand[aiselect];
        computerHand[aiselect] = null;
        topofTable++;

        return topofTable;
    }  


    public static int Score(Cards[] computerWonCards, int scoreOfComputer){
        for(int i=0; i<52;i++){
            if(computerWonCards[i]!=null){
                scoreOfComputer++;
            } else {}
        }
        return scoreOfComputer;
    }


    public static int woncardsnumberai(Cards[] computerWonCards, int computerwoncards){
        for(int i=0; i<52;i++){
            if(computerWonCards[i]!=null){
                computerwoncards++;
            } else{}
        }
        return computerwoncards;
    }
}
