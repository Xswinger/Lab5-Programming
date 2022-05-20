package mainProgram.commandsClasses;

import mainProgram.interfaces.CommandManualNoParameters;

/**
 * Класс команды exit
 */
public class ExitCommand implements CommandManualNoParameters {
    /**
     * Метод execute команды exit
     */
    @Override
    public void executeManual()  {
        System.out.println("Exiting the program");
        System.exit(1);
    }
}
