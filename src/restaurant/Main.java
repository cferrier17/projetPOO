package restaurant;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Restaurant resto = new Restaurant();
        String choice;

    ConteneurOperations operationsDispo = new ConteneurOperations(resto);

        resto.getLogger().info("OUTPUT","Que voulez-vous faire ? ('h') pour voir les operations disponibles)");
        do{
        choice = scan.next();
        resto.getLogger().info("INPUT", choice);
        operationsDispo.getOperationByRaccourci(choice).execute();
    }while( !"q".equals(choice));

    resto.getLogger().info("OUTPUT", "Fin du programme.");
    }


}