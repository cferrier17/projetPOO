package restaurant;

public class AfficherProduit implements Operation{
    private Restaurant resto;

    public AfficherProduit(Restaurant resto) {
        this.resto = resto;
    }

    @Override
    public void execute() {
        this.AfficherProduit(resto);
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

    private void AfficherProduit(Restaurant resto){
        resto.getLogger().info("OUTPUT", resto.toString());
    }
}
