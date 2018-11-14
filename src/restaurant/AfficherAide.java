package restaurant;

public class AfficherAide implements Operation {
    private Restaurant resto;

    public AfficherAide(Restaurant resto) {
        this.resto = resto;
    }

    @Override
    public void execute() {

    }

    @Override
    public String getNom() {
        return "Aide";
    }

    @Override
    public String getDescription() {
        return "Affiche l'aide";
    }

    @Override
    public String getRaccourci() {
        return "h";
    }
}
