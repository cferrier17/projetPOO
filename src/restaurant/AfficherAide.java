package restaurant;

public class AfficherAide implements Operation {
    private ConteneurOperations co;
    private Restaurant resto;
    public AfficherAide(Restaurant resto, ConteneurOperations co) {
        this.resto = resto;
        this.co = co;
    }

    @Override
    public void execute() {
        this.aide();
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

    private void aide(){
        for (Operation o: this.co.getListe()) {
            this.resto.getLogger().info("OUTPUT","'" + o.getRaccourci() + "' : " + o.getDescription());
        }
    }
}
