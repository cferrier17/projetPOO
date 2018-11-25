package testframework.src.testframework;

import logger.src.logger.Logger;
import logger.src.logger.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class LaunchTest {
    private final Logger log = LoggerFactory.getLogger("log.txt");

    public LaunchTest(String[] args) {
        if(args.length == 0){
            log.error("OUTPUT","Veuillez rentrez une classe à tester");
        }
        else{
            for(String classToTest : args){     //On boucle sur toutes les classes entrées en arg
                try{

                    Class<?> clazz = Class.forName(classToTest);
                    Object instance = null;
                    try{
                        instance = clazz.newInstance();
                    } catch (IllegalAccessException |InstantiationException e) {
                        log.error("OUTPUT", "Erreur dans l'instanciation");
                    }

                    for(Method method : clazz.getDeclaredMethods()){    //On parcourt toutes les methodes de la class
                        try{
                            method.invoke(instance);
                        } catch (IllegalAccessException | InvocationTargetException e) {
//                            log.error("OUTPUT", "Erreur dans l'invocation");
                        }
                    }
                }
                catch (ClassNotFoundException e) {
                    log.error("OUTPUT","La classe renseignée n'existe pas");
                }


            }
        }
    }
}
