package mainProgram.commandsClasses;

import mainProgram.classes.Route;
import mainProgram.interfaces.CommandManualWithParameters;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс команды group_counting_by_name
 */
public class GroupCountingByNameCommand implements CommandManualWithParameters {
    /**
     * Метод execute команды group_counting_by_name
     */
    @Override
    public void executeManual(Collection<?> collection, Object ... args){
        HashSet<Route> routes = (HashSet<Route>) collection;
        if (routes.size() != 0) {
            List<Route> listOfRoute = new ArrayList<>(routes);
            Map routesByName = listOfRoute.stream().collect(Collectors.groupingBy(Route::getName, Collectors.counting()));
            System.out.println(routesByName);
        }
        else{
            System.out.println("Cannot group collection items");
        }
    }
}
