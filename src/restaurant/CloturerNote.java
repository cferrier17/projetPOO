package restaurant;

import java.util.Scanner;

public class CloturerNote implements Operation{
    private Restaurant resto;

    public CloturerNote(Restaurant resto) {
        this.resto = resto;
    }

    @Override
    public void execute() {
        this.cloturerNote(resto);
    }

    @Override
    public String getNom() {
        return "CloturerNote";
    }

    @Override
    public String getDescription() {
        return "Permet de cloturer la note d'un client, le supprime également du restaurant";
    }

    @Override
    public String getRaccourci() {
        return "f";
    }

    private void cloturerNote(Restaurant resto){
        Scanner scan = new Scanner(System.in);
        resto.getLogger().info("OUTPUT","Entrez le numero du client dont vous voulez cloturer la note");
        int idClient = Integer.parseInt(scan.next());;
        double reduction;

        resto.getLogger().info("OUTPUT", "Voulez vous offrir une reduction de 10% sur la note du client ? (o/n)");
        String choice = scan.next();
        resto.getLogger().info("INPUT", choice);

        if("o".equals(choice)) //reduction appliquee
            reduction = 0.90;
        else
            reduction = 1;

        removeClient(idClient, reduction, resto);
    }

    public boolean removeClient(int id, double reduction, Restaurant resto){
        double totalHT = 0;

        for(Produit P: resto.getClientById(id).getNote().getListeDesProduits() ){
            resto.getLogger().info("OUTPUT", "" + P.getNom()+" - prix HT : "+P.getPrix()+"€ -- TVA :" + P.getPrix()/10);
            totalHT += P.getPrix();
        }
        double totalTTCSansReduc = (totalHT/10 + totalHT);
        resto.getLogger().info("OUTPUT", "Total HT : "+totalHT * reduction +"€ -- Total TTC : "+ totalTTCSansReduc * reduction );
        return resto.getClients().remove( resto.getClientById(id) );
    }
}
