package restaurant;

import java.util.ArrayList;

public class Note {
    private ArrayList<Produit> listeDesProduits;

    public Note(){
        this.listeDesProduits = new ArrayList<Produit>();
    }

    public boolean addProduit(Produit p) {
        return this.listeDesProduits.add(p);
    }
}
