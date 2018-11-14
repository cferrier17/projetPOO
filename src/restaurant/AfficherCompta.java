package restaurant;

public class AfficherCompta implements Operation {
    private Restaurant resto;

    public AfficherCompta(Restaurant resto) {
        this.resto = resto;
    }

    @Override
    public void execute() {
        this.afficherCompta(resto);
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

    private void afficherCompta(Restaurant resto){
        resto.getLogger().info("OUTPUT",""+resto.getCompta());
    }
}
