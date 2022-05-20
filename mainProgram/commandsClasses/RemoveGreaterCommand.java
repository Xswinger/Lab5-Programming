package mainProgram.commandsClasses;

import mainProgram.classes.Route;
import mainProgram.interfaces.CommandManualWithParameters;
import mainProgram.interfaces.CommandScript;
import mainProgram.utils.CreatingElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Класс команды remove_greater
 */
public class RemoveGreaterCommand implements CommandManualWithParameters, CommandScript {
    /**
     * Метод execute команды remove_greater
     */
    @Override
    public void executeManual(Collection<?> collection, Object ... args) {
        HashSet<Route> routes = (HashSet<Route>) collection;
        Route addedRoute = CreatingElement.CreatingElementManual();
        Set<Route> setToRemove = new HashSet<>();
        for (Route route : routes) {
            if ((addedRoute.getName()).compareTo(route.getName()) < 0) {
                setToRemove.add(route);
            }
        }
        boolean i = false;
        for (Route route: setToRemove){
            i = true;
            routes.remove(route);
        }
        if (i) {
            System.out.println("Removal completed successfully");
        }
        else{
            System.out.println("No element removed");
        }
    }

    /**
     * Метод execute команды remove_greater
     * @throws IOException
     */
    @Override
    public void executeScript(Collection<?> collection, Object... args) throws IOException {
        HashSet<Route> routes = (HashSet<Route>) collection;
        BufferedReader bufferedReader = (BufferedReader) args[0];
        Route addedRoute = CreatingElement.CreatingElementScript(bufferedReader);
        Set<Route> setToRemove = new HashSet<>();
        for (Route route : routes) {
            if ((addedRoute.getName()).compareTo(route.getName()) < 0) {
                setToRemove.add(route);
            }
        }
        boolean i = false;
        for (Route route: setToRemove){
            i = true;
            routes.remove(route);
        }
        if (i) {
            System.out.println("Removal completed successfully");
        }
        else{
            System.out.println("No element removed");
        }
    }
}
