package mainProgram.commandsClasses;

import mainProgram.interfaces.CommandManualWithParameters;

import java.util.Collection;
import java.util.List;

/**
 * Класс команды history
 */
public class HistoryCommand implements CommandManualWithParameters {
    /**
     * Метод execute команды collection
     * @param collection - список выполненных команд
     */
    @Override
    public void executeManual(Collection<?> collection, Object ...args){
        List<String> listWithCommands = (List<String>) collection;
        System.out.println("History of commands:");
        if (listWithCommands.size() > 12) {
            for (int i = listWithCommands.size() - 1; i > (listWithCommands.size()-13); i--)
                System.out.println(listWithCommands.get(i));
        }
        else{
            for (String command: listWithCommands){
                System.out.println(command);
            }
        }
    }
}
