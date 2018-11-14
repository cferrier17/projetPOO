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

        resto.getLogger().info("OUTPUT","Entrez le numero du client ");
        int idClient = Integer.parseInt(scan.next());
        resto.getLogger().info("INPUT", ""+idClient);
        resto.getLogger().info("OUTPUT","Entrez le nom du produit desire");
        String nom = scan.next();
        resto.getLogger().info("INPUT", nom);
        if(!resto.getClientById(idClient).achatProduit(resto.getProductByName(nom))) //TODO : ici
            resto.getLogger().info("OUTPUT","Le produit demande n est plus disponible a la vente");
        resto.boughtProduct(nom);
    }
}
