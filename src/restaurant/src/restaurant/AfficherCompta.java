package restaurant.src.restaurant;


public class AfficherCompta implements Operation {
    private Restaurant resto;

    public AfficherCompta(Restaurant resto) {
        this.resto = resto;
    }

    @Override
    public void execute() {
        resto.getLogger().info("OUTPUT",""+resto.getCompta());
    }

    @Override
    public String getNom() {
        return "AfficherCompta";
    }

    @Override
    public String getDescription() {
        return "Affiche les données comptables";
    }

    @Override
    public String getRaccourci() {
        return "c";
    }

}
