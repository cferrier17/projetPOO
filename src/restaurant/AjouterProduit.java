package restaurant;

import java.util.Scanner;

public class AjouterProduit implements Operation{
    private Restaurant resto;

    public AjouterProduit(Restaurant resto) {
        this.resto = resto;
    }

    @Override
    public void execute() {
        this.ajouterProduit(resto);
    }

    @Override
    public String getNom() {
        return "AjouterProduit";
    }

    @Override
    public String getDescription() {
        return "Permet d'ajouter un produit à la vente, ou ravitailler un déjà présent";
    }

    @Override
    public String getRaccourci() {
        return "a";
    }

    private void ajouterProduit(Restaurant resto){
        Scanner scan = new Scanner(System.in);

        resto.getLogger().info("OUTPUT", "Ajout d'un produit, veuillez rentrer le nom, le prix et la quantite");
        String nom = scan.next();
        Double prix = Double.parseDouble(scan.next());
        int quantite = Integer.parseInt(scan.next());

        if(prix>0 && nom != null && quantite>0){ //TODO : a verifier
            addProduct(new Produit(prix, nom, quantite), resto);
            resto.getLogger().info("INPUT", quantite + " "+nom+" ajoutés au prix de : " + prix+" €" );
        }
        else
            resto.getLogger().info("OUTPUT","Erreur dans les donnees rentrees");
    }


    private void addProduct(Produit P, Restaurant resto){
        boolean inStock = false;
        for(Produit p : resto.getStock()){
            if( p.getNom().equals(P.getNom()))
                inStock = true;
        }

        if(inStock)
            resto.getProductByName(P.getNom()).addQuantite( P.getQuantite());
        else
            resto.getStock().add(P);
    }
}

