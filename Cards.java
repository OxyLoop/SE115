public class Cards{
    public String type;
    public String number;

    public Cards(){}
    public Cards(String type, String number){
        this.type=type;
        this.number=number;
    }
    
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    
}