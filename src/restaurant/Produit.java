package restaurant;

public class Produit {
    private double prix;
    private String nom;
    private int quantite;

    public Produit(double prix, String nom, int quantite) {
        this.prix = prix;
        this.nom = nom;
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public String getNom() {
        return nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void addQuantite(int q){
        this.quantite += q;
    }

}
