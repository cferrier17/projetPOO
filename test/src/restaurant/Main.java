package restaurant;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Scanner scan = new Scanner(System.in);

    Restaurant resto = new Restaurant();
    String choice;

    System.out.println("Que voulez-vous faire ? (\"o\" pour voir les operations disponibles)");


    do{
        choice = scan.next();
        switch (choice){
            case "o" : break; //affiche operations dispo
            case "q" : break; //quitter
            case "p" :
                resto.printProducts();
                break; //affiche produits dispo
            case "a" : break; //ajout produit a la vente
            case "n":  break; //ouvrir note client
            case "e" : break; //enregistrer vente d un produit sur note
            case "f" : break; //cloturer la note
            case "c" : break; //afficher donnee compta
        }
    }while( !"q".equals(choice));

    System.out.println("Fin du programme.");
    }
}
