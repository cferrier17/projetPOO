package restaurant.src.restaurant;


public class AjouterClient implements Operation {
    private Restaurant resto;

    public AjouterClient(Restaurant resto) {
        this.resto = resto;
    }

    @Override
    public void execute() {
        Client c = new Client();
        resto.getLogger().info("OUTPUT","Vous avez cree un nouveau client, son id est : "+ c.getId());
    }

    @Override
    public String getNom() {
        return "AjouterClient";
    }

    @Override
    public String getDescription() {
        return "Permet d'ajouter un client au restaurant";
    }

    @Override
    public String getRaccourci() {
        return "n";
    }

}
