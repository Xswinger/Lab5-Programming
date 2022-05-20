package mainProgram.commandsClasses;

import mainProgram.classes.Invoker;
import mainProgram.interfaces.CommandManualWithParameters;

import java.io.*;
import java.util.Collection;

import static mainProgram.utils.Parser.filePath;

/**
 * Класс команды execute_script
 */
public class ExecuteScriptCommand implements CommandManualWithParameters {
    /**
     * Метод execute команды execute_script
     * @throws IOException - все ошибки, возможные при исполнении скрипта
     */
    @Override
    public void executeManual(Collection<?> collection, Object ... args) throws IOException {
        try {
            File file = new File(filePath(String.valueOf(args)));
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean i = true;
            while (i) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                new Invoker().choiceCommandScript(line, collection, args, args, bufferedReader);
            }
            System.out.println("Script execute completed");
        } catch (FileNotFoundException ex){
            System.out.println("The specified file cannot be found");
        }
    }
}
