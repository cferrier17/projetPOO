package restaurant;

import java.util.ArrayList;

public class Restaurant {
    private ArrayList<Produit> stock;

    public Restaurant(){
        this.stock = new ArrayList<Produit>();
        this.stock.add(new Produit(7, "Bagel", 20) );
        this.stock.add(new Produit(6, "Burger", 10) );
        this.stock.add(new Produit(4.50, "Smoothie", 30) );
        this.stock.add(new Produit(2, "Cafe", -1) );
    }



    public boolean addProduct(Produit P){
        return this.stock.add(P);
    }

    public void printProducts(){
        for (Produit P: stock) {
            if(P.getQuantite() != -1)
                System.out.println("Nom : " + P.getNom() + " -- Quantite restante : " + P.getQuantite());
            else
                System.out.println("Nom :  "+ P.getNom() +" -- Quantite illimitee");
        }
    }

}
