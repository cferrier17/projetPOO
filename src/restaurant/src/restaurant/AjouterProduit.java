package restaurant.src.restaurant;


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
        String prix = scan.next();
        String quantite = scan.next();

        if(estUnDouble(prix) && Double.parseDouble(prix)>0 &&  nom != null && estUnInt(quantite) && Integer.parseInt(quantite)>0){ //TODO : a verifier
            if( addProduct(new Produit(Double.parseDouble(prix), nom, Integer.parseInt(quantite)), resto) )
                resto.getLogger().info("OUTPUT", quantite + " "+nom+" ajoutés au prix de : " + prix+" €" );

        }
        else
            resto.getLogger().error("OUTPUT","Erreur dans les donnees rentrees");
    }


    public boolean addProduct(Produit P, Restaurant resto){
        boolean inStock = false;
        Produit tmp = null;
        for(Produit p : resto.getStock()){
            if( p.getNom().equals(P.getNom())){
                inStock = true;
                tmp = p;
            }
        }
        if(inStock && tmp.getPrix() == P.getPrix()){
            resto.getProductByName(P.getNom()).addQuantite( P.getQuantite());
            return true;
        }
        else if(!inStock)
            return resto.getStock().add(P);
        else{
            this.resto.getLogger().error("OUTPUT", "Le produit rentré a le même nom qu'un produit déjà existant, mais pas le même prix.");
            return false;
        }
    }

    public boolean estUnDouble(String chaine){
        try {
            Double.parseDouble(chaine);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean estUnInt(String chaine){
        try {
            Integer.parseInt(chaine);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

