package restaurant;

import java.util.Scanner;

public class AchatProduit implements Operation {
    private Restaurant resto;

    public AchatProduit(Restaurant resto) {
        this.resto = resto;
    }

    @Override
    public void execute() {
        this.achatProduit(resto);
    }

    @Override
    public String getNom() {
        return "Achat produit";
    }

    @Override
    public String getDescription() {
        return "Achète un produit";
    }

    @Override
    public String getRaccourci() {
        return "e";
    }

    private void achatProduit(Restaurant resto){
        Scanner scan = new Scanner(System.in);

        resto.getLogger().info("OUTPUT","Entrez le numero du client et le nom du produit désiré");
        String idClient = scan.next();
        resto.getLogger().info("INPUT", ""+idClient);

        String nom = scan.next();
        resto.getLogger().info("INPUT", nom);


        if(!estALaVente(nom) /*&& !resto.getClientById(idClient).achatProduit(resto.getProductByName(nom))*/) //TODO : ici
            resto.getLogger().info("OUTPUT","Le produit demande n est plus disponible a la vente");
        else if(estUnInt(idClient) && resto.estUnClient( Integer.parseInt(idClient))){
            resto.boughtProduct(nom);   //on décrémente le produit dans le stock
            resto.getClientById(Integer.parseInt(idClient)).achatProduit(resto.getProductByName(nom));    //on modifie la note du client
            resto.getCompta().moneyIn( resto.getProductByName(nom).getPrix() );     //on modifie la comptabilité du resto
        }
        else{
            resto.getLogger().error("OUTPUT","L'id client rentré n'est pas valide.");
        }

    }

    private boolean estALaVente(String nomProduit){
        boolean ret = false;

        for (Produit p:this.resto.getStock()) {
            if(p.getNom().equals(nomProduit))
                ret = true;
        }

        return ret;
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
