package mainProgram.commandsClasses;

import mainProgram.classes.Route;
import mainProgram.interfaces.CommandManualWithParameters;
import mainProgram.utils.PrintElement;

import java.util.Collection;
import java.util.HashSet;

/**
 * Класс команды show
 */
public class ShowCommand implements CommandManualWithParameters {
    /**
     * Метод execute команды show
     */
    @Override
    public void executeManual(Collection<?> collection, Object ... args){
        HashSet<Route> routes = (HashSet<Route>) collection;
        if (routes.size() != 0) {
            System.out.println("Collection elements:");
            for (Route route: routes) {
                if (route.getFrom() != null) {
                    PrintElement.fromNotNull(route);
                }
                else{
                    PrintElement.fromNull(route);
                }
            }
        }
        else{
            System.out.println("The collection has no elements");
        }
    }
}
