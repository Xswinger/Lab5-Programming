package mainProgram.commandsClasses;

import mainProgram.interfaces.CommandManualWithParameters;

import java.util.Collection;

/**
 * Класс команды clear
 */
public class ClearCommand implements CommandManualWithParameters {
    /**
     * Метод execute команды clear
     */
    @Override
    public void executeManual(Collection<?> collection, Object ... args){
        collection.clear();
        System.out.println("Collection cleared");
    }
}
