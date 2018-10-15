package restaurant;
import java.util.ArrayList;

public class Restaurant {
    private ArrayList<Produit> stock;
    private ArrayList<Client> clients;

    public Restaurant(){
        this.stock = new ArrayList<Produit>();
        this.clients = new ArrayList<Client>();
        this.stock.add(new Produit(7, "Bagel", 20) );
        this.stock.add(new Produit(6, "Burger", 10) );
        this.stock.add(new Produit(4.50, "Smoothie", 30) );
        this.stock.add(new Produit(2, "Cafe", -1) );
    }

    public boolean addProduct(Produit P){
        return this.stock.add(P);
    }

    public boolean addClient(){ //Ouvre la note d'un client & ajoute un client au restaurant
        Client c = new Client();
        return this.clients.add(c);
    }

    @Override
    public String toString(){
        String ret="";

        for (Produit P: stock) {
            if(P.getQuantite() != -1)
                ret+="Nom : " + P.getNom() + " -- Quantite restante : " + P.getQuantite()+"\n";
            else
                ret+="Nom :  "+ P.getNom() +" -- Quantite illimitee\n";
        }

        return ret;
    }

}
