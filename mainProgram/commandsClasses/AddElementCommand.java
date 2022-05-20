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
 * Класс команды add
 */
public class AddElementCommand implements CommandManualWithParameters, CommandScript {
    /**
     * Метод execute команды add(ручной ввод)
     */
    @Override
    public void executeManual(Collection<?> collection, Object ... args){
        try {
            HashSet<Route> routes = (HashSet<Route>) collection;
            routes.add(CreatingElement.CreatingElementManual());
            System.out.println("Element added successfully");
        }
        catch (NumberFormatException ex){
            System.out.println(ex.getMessage() + " - Invalid input variable format");
        }
    }

    /**
     * Метод execute команды add(исполнение скрипта)
     */
    @Override
    public void executeScript(Collection<?> collection, Object... args){
        try {
            HashSet<Route> routes = (HashSet<Route>) collection;
            BufferedReader bufferedReader = (BufferedReader) args[0];
            routes.add(CreatingElement.CreatingElementScript(bufferedReader));
            System.out.println("Element added successfully");
        }
        catch (NumberFormatException | IOException ex){
            System.out.println(ex.getMessage() + " - Invalid input variable format for creating element");
        }
    }
}
