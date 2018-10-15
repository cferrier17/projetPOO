package restaurant;
import java.util.ArrayList;

public class Client {
    private int id;
    private Note note;

    private static int client_id = 0;

    public Client() {
        this.id = client_id++;
        this.note = new Note();
    }

    public boolean achatProduit(Produit p){
        return note.addProduit(p);
    }

}
