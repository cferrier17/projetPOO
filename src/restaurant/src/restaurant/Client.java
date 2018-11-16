package restaurant.src.restaurant;


public class Client {
    private int id;
    private Note note;

    private static int client_id = 0;

    public Client() {
        this.id = client_id++;
        this.note = new Note();
    }

    public boolean achatProduit(Produit p){
        if( p.getQuantite() != 0)
            return note.addProduit(p);
        else
            return false;
    }

    public int getId() {
        return id;
    }

    public Note getNote() {
        return note;
    }


}
