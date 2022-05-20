package mainProgram.commandsClasses;

import mainProgram.classes.Route;
import mainProgram.interfaces.CommandManualWithParameters;
import mainProgram.interfaces.CommandScript;
import mainProgram.utils.ChangeFieldValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * Класс команды update_id
 */
public class UpdateIdCommand implements CommandManualWithParameters, CommandScript {
    /**
     * Метод execute команды update_id
     */
    @Override
    public void executeManual(Collection<?> collection, Object... args){
        HashSet<Route> routes = (HashSet<Route>) collection;
        int id = Integer.parseInt(Arrays.toString(args));
        boolean i = false;
        for (Route route : routes) {
            if (id == route.getId()) {
                System.out.println("Element with id " + id + " found");
                ChangeFieldValue.ChangeFieldValueManual(route);
                i = true;
                break;
            }
        }
        if (!i) {
            System.out.println("Element with id " + id + " not found");
        }
    }

    /**
     * Метод execute команды update_id
     */
    @Override
    public void executeScript(Collection<?> collection, Object... args) throws IOException {
        HashSet<Route> routes = (HashSet<Route>) collection;
        Integer id = (Integer) args[0];
        BufferedReader bufferedReader = (BufferedReader) args[1];
        boolean i = false;
        for (Route route : routes) {
            if (id == route.getId()) {
                System.out.println("Element with id " + id + " found");
                ChangeFieldValue.ChangeFieldValueScript(route, bufferedReader);
                i = true;
                break;
            }
        }
        if (!i) {
            System.out.println("Element with id " + id + " not found");
        }
    }
}
