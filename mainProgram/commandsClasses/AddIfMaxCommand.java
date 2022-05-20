package mainProgram.commandsClasses;

import mainProgram.classes.Route;
import mainProgram.interfaces.CommandManualWithParameters;
import mainProgram.interfaces.CommandScript;
import mainProgram.utils.CreatingElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

/**
 * Класс команды add_if_max
 */
public class AddIfMaxCommand implements CommandManualWithParameters, CommandScript {
    /**
     * Метод execute команды add_if_max
     */
    @Override
    public void executeManual(Collection<?> collection, Object ... args){
        HashSet<Route> routes = (HashSet<Route>) collection;
        Route addedRoute = CreatingElement.CreatingElementManual();
        int i = 0;
        for (Route route : routes) {
            if ((addedRoute.getName()).compareTo(route.getName()) > 0) {
                i += 1;
            }
        }
        if (i == routes.size()) {
            routes.add(addedRoute);
            System.out.println("Element added successfully");
        }
        else{
            System.out.println("The element was not added to the collection");
        }
    }

    @Override
    public void executeScript(Collection<?> collection, Object... args) throws IOException {
        HashSet<Route> routes = (HashSet<Route>) collection;
        BufferedReader bufferedReader = (BufferedReader) args[0];
        Route addedRoute = CreatingElement.CreatingElementScript(bufferedReader);
        int i = 0;
        for (Route route : routes) {
            if ((addedRoute.getName()).compareTo(route.getName()) > 0) {
                i += 1;
            }
        }
        if (i == routes.size()) {
            routes.add(addedRoute);
            System.out.println("Element added successfully");
        }
        else{
            System.out.println("The element was not added to the collection");
        }
    }
}
