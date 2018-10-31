package restaurant;
import java.util.Scanner;

public class Main {     //TODO : implemanter le logger dans le reste du code

    public static void main(String[] args) {
	// write your code here
    Scanner scan = new Scanner(System.in);

    Restaurant resto = new Restaurant();
    String choice;


    System.out.println("Que voulez-vous faire ? ('o' pour voir les operations disponibles)");
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

                if(prix>0 && nom != null && quantite>0)
                    System.out.println(resto.addProduct(new Produit(prix, nom, quantite)));
                else
                    System.out.println("Erreur dans les donnees rentrees");

                break; //ajout produit a la vente
            case "n":
                resto.addClient();
                System.out.printf("Vous avez cree un nouveau client, son id est : %d\n", resto.getClientByIndex( resto.getClients().size() - 1).getId());
                break; //ouvrir note client
            case "e" : //achat produit
                System.out.println("Entrez le numero du client ");
                idClient = Integer.parseInt(scan.next());
                System.out.println("Entrez le nom du produit desire");
                nom = scan.next();
                resto.getClientById(idClient).achatProduit(resto.getProductByName(nom)) ;
                resto.boughtProduct(nom);

                break;
            case "f" :  //cloturer la note
                System.out.println("Entrez le numero du client dont vous voulez cloturer la note");
                idClient = Integer.parseInt(scan.next());
                System.out.println((resto.removeClient(idClient)));
                break;
            case "c" :
                System.out.println(resto.getCompta());
                break; //afficher donnee compta
        }
    }while( !"q".equals(choice));

    System.out.println("Fin du programme.");
    }
}
