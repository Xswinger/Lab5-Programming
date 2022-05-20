package mainProgram;

import mainProgram.classes.Route;
import mainProgram.utils.FileNameTaker;
import mainProgram.utils.Parser;
import mainProgram.classes.Invoker;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.time.LocalDate;
import java.util.*;

/**
 * Класс запуска работы программы
 */
public class Manager {
    /**
     * Класс Manager
     * @param args - аргументы командной строки
     * @throws IOException - все исключения(в том числе не найденная переменная окружения)
     */
    public static void main(String[] args) throws IOException {
        try {
            LocalDate dateOfInitialization = LocalDate.now();
            String filename = new FileNameTaker().getFileNameFromEnvironment();
            FileInputStream fileInputStream = new FileInputStream(Parser.filePath(filename));
            HashSet<Route> routes = Parser.outFile(fileInputStream);
            while (true) {
                System.out.println("Enter command:");
                Scanner lineWithCommand = new Scanner(System.in);
                String Line = lineWithCommand.nextLine();
                Invoker inputCommand = new Invoker();
                inputCommand.choiceCommandManual(Line, routes, dateOfInitialization, filename);
            }
        }
        catch(NoSuchElementException ex){
            System.out.println("Incorrect command");
        }
        catch(AccessDeniedException ex){
            System.out.println("No file permissions");
        }
    }
}

