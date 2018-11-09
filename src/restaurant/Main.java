package restaurant;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Scanner scan = new Scanner(System.in);

    Restaurant resto = new Restaurant();
    String choice;

    double reduction;

        resto.getLogger().info("OUTPUT","Que voulez-vous faire ? ('o' pour voir les operations disponibles)");
        String nom;
        int idClient;

        do{
        choice = scan.next();
        switch (choice){
            case "o" :
                resto.getLogger().info("OUTPUT", "Opérations disponibles :\n-Afficher la liste des produits disponibles :'p'\n-Ajouter un produit a la vente : 'a'\n-Ouvrir la note d'un client :'n'\n-Enregistrer la vente d un produit sur une note :'e'\n-Cloturer une note :'f'\n-Afficher les donnees comptables :'c'\n-Quitter :q");
                break; //affiche operations dispo
            case "p" :
                resto.getLogger().info("OUTPUT", resto.toString());
                break; //affiche produits dispo
            case "a" :
                resto.getLogger().info("OUTPUT", "Ajout d'un produit, veuillez rentrer le prix, le nom, et la quantite");
                Double prix = Double.parseDouble(scan.next());
                nom = scan.next();
                int quantite = Integer.parseInt(scan.next());


                if(prix>0 && nom != null && quantite>0){ //TODO : a verifier
                }
                    //System.out.println(resto.addProduct(new Produit(prix, nom, quantite)));
                else
                    resto.getLogger().info("OUTPUT","Erreur dans les donnees rentrees");

                break; //ajout produit a la vente
            case "n":
                resto.addClient();
                resto.getLogger().info("OUTPUT","Vous avez cree un nouveau client, son id est : "+ resto.getClientByIndex( resto.getClients().size() - 1).getId());
                break; //ouvrir note client
            case "e" : //achat produit
                resto.getLogger().info("OUTPUT","Entrez le numero du client ");
                idClient = Integer.parseInt(scan.next());
                resto.getLogger().info("OUTPUT","Entrez le nom du produit desire");
                nom = scan.next();
                if(!resto.getClientById(idClient).achatProduit(resto.getProductByName(nom)))
                    resto.getLogger().info("OUTPUT","Le produit demande n est plus disponible a la vente");
                resto.boughtProduct(nom);

                break;
            case "f" :  //cloturer la note
                resto.getLogger().info("OUTPUT","Entrez le numero du client dont vous voulez cloturer la note");
                idClient = Integer.parseInt(scan.next());

                resto.getLogger().info("OUTPUT", "Voulez vous offrir une reduction de 10% sur la note du client ? (o/n)");
                choice = scan.next();

                if("o".equals(choice)) //reduction appliquee
                    reduction = 0.90;
                else
                    reduction = 1;

                resto.removeClient(idClient, reduction);

                break;
            case "c" :
                resto.getLogger().info("OUTPUT",""+resto.getCompta());
                break; //afficher donnee compta
        }
    }while( !"q".equals(choice));

    resto.getLogger().info("OUTPUT", "Fin du programme.");
    }
}
