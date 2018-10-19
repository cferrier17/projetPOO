package restaurant;
import java.util.ArrayList;

public class Restaurant {
    private ArrayList<Produit> stock;
    private ArrayList<Client> clients;
    private Comptabilite compta ;

    public Restaurant(){
        this.stock = new ArrayList<Produit>();
        this.clients = new ArrayList<Client>();
        this.compta = new Comptabilite();
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

    public ArrayList<Client> getClients(){
        return this.clients;
    }

    public Client getClientById(int id){
        for(Client C: clients){
            if(C.getId() == id)
              return C;
        }
        return null;
    }

    public Client getClientByIndex(int index){
        if(index > stock.size())
            return null;
        else
            return clients.get(index);
    }

    public Produit getProductByName(String name){
        for(Produit P: stock){
            if(P.getNom().equals(name))
                return P;
        }
        return null;
    }

    public void boughtProduct(String name){
        this.getProductByName(name).setQuantite( this.getProductByName(name).getQuantite()-1 );
    }

    public boolean removeClient(int id){
        double totalHT = 0;

        for(Produit P: this.getClientById(id).getNote().getListeDesProduits() ){
            System.out.printf(P.getNom()+" - prix HT : "+P.getPrix()+"€ -- TVA : %.3f€\n", P.getPrix()/10);
            this.compta.moneyIn(P.getPrix());
            totalHT += P.getPrix();
        }
        System.out.printf("Total HT : "+totalHT+"€ -- Total TTC : %.2f", totalHT/10 + totalHT);
        return this.clients.remove( this.getClientById(id) );
    }

    public Comptabilite getCompta() {
        return compta;
    }
}
