package restaurant;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Scanner scan = new Scanner(System.in);

    Restaurant resto = new Restaurant();
    String choice;

    System.out.println("Que voulez-vous faire ? ('o' pour voir les operations disponibles)");


    do{
        choice = scan.next();
        switch (choice){
            case "o" :
                System.out.println("Opérations disponibles :\n-Afficher la liste des produits disponibles :'p'\n-Ajouter un produit a la vente : 'a'\n-Ouvrir la note d'un client :'n'\n-Enregistrer la vente d un produit sur une note :'e'\n-Cloturer une note :'f'\n-Afficher les donnees comptables :'c'\n-Quitter :q");
                break; //affiche operations dispo
            case "p" :
                System.out.println(resto);;
                break; //affiche produits dispo
            case "a" :
                System.out.println("Ajout d'un produit, veuillez rentrer le prix, le nom, et la quantite");
                Double prix = Double.parseDouble(scan.next());
                String nom = scan.next();
                int quantite = Integer.parseInt(scan.next());

                if(prix>0 && nom != null && quantite>0)
                    System.out.println(resto.addProduct(new Produit(prix, nom, quantite)));
                else
                    System.out.println("Erreur dans les donnees rentrees");

                break; //ajout produit a la vente
            case "n":
                System.out.println(resto.addClient());
                break; //ouvrir note client
            case "e" :

                break; //enregistrer vente d un produit sur note
            case "f" : break; //cloturer la note
            case "c" : break; //afficher donnee compta
        }
    }while( !"q".equals(choice));

    System.out.println("Fin du programme.");
    }
}
