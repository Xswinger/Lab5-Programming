package mainProgram.commandsClasses;

import mainProgram.Commands;
import mainProgram.interfaces.CommandManualNoParameters;

/**
 * Класс команды help
 */
public class HelpCommand implements CommandManualNoParameters {
    /**
     * Метод execute команды help
     */
    @Override
    public void executeManual(){
        for (Commands command: Commands.values())
            System.out.println(Commands.getNameCommand(command) + " : " + Commands.getDescription(command));
    }
}
