package mainProgram.commandsClasses;

import mainProgram.classes.Route;
import mainProgram.interfaces.CommandManualWithParameters;
import mainProgram.utils.PrintElement;

import java.util.Collection;
import java.util.HashSet;

/**
 * Класс команды print_descending
 */
public class PrintDescending implements CommandManualWithParameters {
    /**
     * Метод execute команды print_descending
     */
    @Override
    public void executeManual(Collection<?> collection, Object ... args){
        HashSet<Route> routes = (HashSet<Route>) collection;
        String[] names = new String[routes.size()];
        Route[] routesOutput = new Route[routes.size()];
        int i = 0;
        for (Route route : routes){
            names[i] = route.getName();
            routesOutput[i] = route;
            i++;
        }
        boolean isSorted = false;
        String nameBuffer;
        Route routeBuffer;
        while(!isSorted) {
            isSorted = true;
            for (i = 0; i < names.length-1; i++) {
                if(names[i].compareTo(names[i+1]) > 0){
                    isSorted = false;
                    nameBuffer = names[i];
                    routeBuffer = routesOutput[i];
                    names[i] = names[i+1];
                    routesOutput[i] = routesOutput[i+1];
                    names[i+1] = nameBuffer;
                    routesOutput[i+1] = routeBuffer;
                }
            }
        }
        for (Route route : routesOutput) {
            if (route.getFrom() != null){
                PrintElement.fromNotNull(route);
            }
            else{
                PrintElement.fromNull(route);
            }
        }
    }
}
