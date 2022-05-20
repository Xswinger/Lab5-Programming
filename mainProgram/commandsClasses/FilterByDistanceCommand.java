package mainProgram.commandsClasses;

import mainProgram.classes.Route;
import mainProgram.interfaces.CommandManualWithParameters;
import mainProgram.utils.PrintElement;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Класс команды filter_by_distance
 */
public class FilterByDistanceCommand implements CommandManualWithParameters {
    /**
     * Метод execute команды add
     * @param routes - коллекция элементов
     * @param distance - значение distance
     */
    @Override
    public void executeManual(Collection<?> collection, Object ...args){
        HashSet<Route> routes = (HashSet<Route>) collection;
        boolean i = false;
        for (Route route: routes){
            if (route.getDistance() == Integer.parseInt(Arrays.toString(args)) && route.getFrom() != null){
                i = true;
                PrintElement.fromNotNull(route);
            }
            if ((route.getDistance() == Integer.parseInt(String.valueOf(args))) && (route.getFrom() == null)){
                i = true;
                PrintElement.fromNull(route);
            }
        }
        if (!i){
            System.out.println("No collection elements found with this distance value");
        }
    }
}
