import java.util.Random;

public class Cards{
    public String type;
    public String number;

    public Cards(){}
    public Cards(String type, String number){
        this.type=type;
        this.number=number;
    }

    public void shuffle(Cards[] deck){
        Random r = new Random(System.currentTimeMillis());
        for(int i=0; i<52; i++){
            int n1 = r.nextInt(52);
            int n2 = r.nextInt(52);
            Cards yedekd ;
            yedekd = deck[n1];
            deck[n1]= deck[n2];
            deck[n2] = yedekd; 
        }
    }

    public void cut(Cards[] deck,int cutvalue){
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
    }

    public int deal (Cards[] deck, Cards[] computerHand, Cards[] playerHand, int deckcardCounter){
        for(int i=0; i<4;i++){
            computerHand[i]=deck[deckcardCounter];
            deckcardCounter = deckcardCounter +1;
            playerHand[i]=deck[deckcardCounter]; 
            deckcardCounter = deckcardCounter +1;
        }
        return deckcardCounter;
    }
    
    public String getNumber() {
        return number;
    }
    
    
}