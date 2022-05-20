package mainProgram.commandsClasses;

import mainProgram.classes.Route;
import mainProgram.interfaces.CommandManualWithParameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Класс команды remove_by_id
 */
public class RemoveByIdCommand implements CommandManualWithParameters {/**
     * Метод execute команды remove_by_id
     */
    @Override
    public void executeManual(Collection<?> collection, Object... args){
        boolean i = false;
        HashSet<Route> routes = (HashSet<Route>) collection;
        for (Route route : routes) {
            if (route.getId() == Integer.parseInt(Arrays.toString(args))) {
                i = true;
                routes.remove(route);
                System.out.println("Element deleted successfully");
                break;
            }
        }
        if (!i){
            System.out.println("Element with this id was not found");
        }
    }
}
