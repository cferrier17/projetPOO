package restaurant.src.restaurant;


public class AfficherProduit implements Operation{
    private Restaurant resto;

    public AfficherProduit(Restaurant resto) {
        this.resto = resto;
    }

    @Override
    public void execute() {
        resto.getLogger().info("OUTPUT", "Liste des produits disponibles à la vente : \n"+resto.toString());
    }

    @Override
    public String getNom() {
        return "AfficherProduit";
    }

    @Override
    public String getDescription() {
        return "Affiche la liste des produits disponibles à la vente";
    }

    @Override
    public String getRaccourci() {
        return "p";
    }

}
