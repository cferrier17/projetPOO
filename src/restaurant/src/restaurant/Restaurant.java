package restaurant.src.restaurant;

import logger.src.logger.Logger;
import logger.src.logger.LoggerFactory;

import java.util.ArrayList;


public class Restaurant {
    private ArrayList<Produit> stock;
    private ArrayList<Client> clients;
    private Comptabilite compta ;
    private final Logger log = LoggerFactory.getLogger("log.txt");

    public Restaurant(){
        this.stock = new ArrayList<Produit>();
        this.clients = new ArrayList<Client>();
        this.compta = new Comptabilite();
        this.stock.add(new Produit(7, "Bagel", 20) );
        this.stock.add(new Produit(6, "Burger", 10) );
        this.stock.add(new Produit(4.50, "Smoothie", 30) );
        this.stock.add(new Produit(2, "Cafe", -1) );
    }

    public ArrayList<Produit> getStock() {
        return stock;
    }

    @Override
    public String toString(){
        String ret="";

        for (Produit P: stock) {
            if(P.getQuantite() != 0){ //Si il reste du produit
                if(P.getQuantite() < 0) //Si cafe
                    ret+="Nom :  "+ P.getNom() +" -- Quantite illimitee\n";
                else
                    ret+="Nom : " + P.getNom() + " -- Quantite restante : " + P.getQuantite()+"\n";
                }
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

    public boolean estUnClient(int id){
        boolean ret = false;

        for(Client c:this.clients){
            if(id == c.getId())
                ret = true;
        }

        return ret;
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


    public Comptabilite getCompta() {
        return compta;
    }

    public Logger getLogger(){
        return this.log;
    }


}
