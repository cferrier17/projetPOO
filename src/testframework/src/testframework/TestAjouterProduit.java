package testframework.src.testframework;

import restaurant.src.restaurant.AjouterProduit;
import restaurant.src.restaurant.Produit;
import restaurant.src.restaurant.Restaurant;

public class TestAjouterProduit {
    private final static Restaurant restaurant = new Restaurant();
    private final static Timer timer = new Timer();
    private final static AjouterProduit ajoutProduit = new AjouterProduit(restaurant);

    public void runTestAjouterProduit(){
        int cpt = 0, total = 0;
        String resume = "";
        long debut = System.currentTimeMillis();

        if("OK".equals(this.testEstUnInt())){
            cpt++;
        }
        total++;
        resume += "TestAjouterProduit- testEstUnInt- "+this.testEstUnInt()+" - Duréee : "+(System.currentTimeMillis()-debut)+"ms\n";


        if("OK".equals(this.testEstUnDouble())){
            cpt++;
        }

        total++;
        resume += "TestAjouterProduit- testEstUnDouble "+this.testEstUnDouble()+" - Duréee : "+(System.currentTimeMillis()-debut)+"ms.";


        if("OK".equals(this.testAddProduct())){
            cpt++;
        }

        total++;
        resume += "\nTestAjouterProduit- testAddProduct "+this.testAddProduct()+" - Duréee : "+(System.currentTimeMillis()-debut)+"ms.";

        double pourcentageReussite = cpt/total*100;
        double tempsEcoule = (System.currentTimeMillis()-debut);
        resume+="\nDurée totale : "+ tempsEcoule +"ms.\nPourcentage de réussite : "+pourcentageReussite+"%.";


        restaurant.getLogger().info("OUTPUT",resume);
    }

    private String testEstUnDouble(){
        String test = "OK";

        if(!ajoutProduit.estUnDouble("52.1"))
            test = "KO";

        return test;
    }


    private String testEstUnInt(){
        String test = "OK";

        if(!ajoutProduit.estUnInt("52"))
            test = "KO";

        return test;
    }


    private String testAddProduct(){
        String test = "OK";
        Produit p = new Produit(10,"Pizza", 30);
        ajoutProduit.addProduct(p, restaurant);

        if(restaurant.getStock().size()!=5 || restaurant.getProductByName("Pizza")==null)
            test="KO";


        ajoutProduit.addProduct(new Produit(7,"Bagel", 20), restaurant);


        if(restaurant.getStock().size()!=5 || restaurant.getProductByName("Bagel").getQuantite()<21)
            test="KO";

        return test;
    }
}
