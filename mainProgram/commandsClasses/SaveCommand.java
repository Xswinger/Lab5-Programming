package mainProgram.commandsClasses;

import mainProgram.classes.Route;
import mainProgram.interfaces.CommandManualWithParameters;
import mainProgram.utils.Parser;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

/**
 * Класс команды save
 */
public class SaveCommand implements CommandManualWithParameters {
    /**
     * Метод execute команды add
     * @throws IOException - все ошибки, возникающие во время парсинга
     */
    @Override
    public void executeManual(Collection<?> collection, Object ... args) throws IOException {
        HashSet<Route> routes = (HashSet<Route>) collection;
        String filename = (String) args[0];
        System.out.println(Parser.InFile(routes, filename));
    }
}
