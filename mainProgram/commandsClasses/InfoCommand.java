package mainProgram.commandsClasses;

import mainProgram.interfaces.CommandManualWithParameters;

import java.util.Collection;

/**
 * Класс команды info
 */
public class InfoCommand implements CommandManualWithParameters {
    /**
     * Метод execute команды info
     */
    @Override
    public void executeManual(Collection<?> collection, Object ... args){
        System.out.println("Collection information:");
        System.out.println("Collection type: " + collection.getClass().getName()
                + "\nInitialization date: " + args[0]
                + "\nAmount of elements: " + collection.size());
    }
}
