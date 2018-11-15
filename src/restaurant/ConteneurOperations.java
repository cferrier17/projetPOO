package restaurant;

import java.util.ArrayList;

public class ConteneurOperations {
    private ArrayList<Operation> liste;

    public ArrayList<Operation> getListe() {
        return liste;
    }

    public ConteneurOperations(Restaurant restaurant){
        liste = new ArrayList<>();

        liste.add(new AjouterClient(restaurant));
        liste.add(new AfficherProduit(restaurant));
        liste.add(new AjouterProduit(restaurant));
        liste.add(new AchatProduit(restaurant));
        liste.add(new CloturerNote(restaurant));
        liste.add(new AfficherCompta(restaurant));
        liste.add(new AfficherAide(restaurant, this));
    }

    public Operation getOperationByRaccourci(String raccourci){
        for(Operation o : liste){
            if(o.getRaccourci().equals(raccourci))
                return o;
        }
        return getOperationByRaccourci("h"); //retourne l'aide
    }


}
