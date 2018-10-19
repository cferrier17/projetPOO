package restaurant;

public class Comptabilite {
    private double rentreesArgent;
    private double TVA;

    public void moneyIn(double money){
        this.rentreesArgent += money;
        this.TVA += money/10;
    }

    @Override
    public String toString(){
        return "Etat de la comptabilite -- Rentree d argent : "+ this.rentreesArgent + "€ -- TVA facturee :"+ TVA + "€";
    }
}
