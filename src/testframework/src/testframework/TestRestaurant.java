package testframework.src.testframework;

import restaurant.src.restaurant.Restaurant;

public class TestRestaurant {
    private final static Restaurant restaurant = new Restaurant();
    private final static Timer timer = new Timer();


    public void runTestRestaurant(){
        int cpt = 0, total = 0;
        String resume = "";
        long debut = System.currentTimeMillis();

        if("OK".equals(this.testInit())){
            cpt++;
        }
        total++;
        resume += "TestRestaurant - testInit - "+this.testInit()+" - Duréee : "+(System.currentTimeMillis()-debut)+"ms\n";


        if("OK".equals(this.testBoughtProduct())){
            cpt++;
        }

        total++;
        resume += "TestRestaurant - testBoughtProduct - "+this.testBoughtProduct()+" - Duréee : "+(System.currentTimeMillis()-debut)+"ms.";

        resume+="\nDurée totale : "+ (System.currentTimeMillis()-debut) +"ms.\nPourcentage de réussite : "+cpt/total*100+"%.";


        restaurant.getLogger().info("OUTPUT",resume);
    }

    private String testInit(){
        String test = "OK";

        if(restaurant.getStock().size()!=4){
            test = "KO";
            restaurant.getLogger().error("OUTPUT","Mauvais nombre de produit dans le stock à l'initialisation");
        }

        return test;
    }

    private String testBoughtProduct(){
        String test = "OK";
        restaurant.boughtProduct("Burger");

        if(restaurant.getProductByName("Burger").getQuantite()==10){
            test = "KO";
            restaurant.getLogger().error("OUTPUT","L'achat d'un produit n'est pas fonctionnel");
        }


        return test;
    }


    private void test(){
        System.out.println("test");
    }
}
