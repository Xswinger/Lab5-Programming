package mainProgram.classes;

import mainProgram.Commands;
import mainProgram.commandsClasses.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

import static mainProgram.classes.History.history;

/**
 * Класс выборки команды
 */
public class Invoker {
    /**
     * Метод, вызывающий определенную команду (для исполнения скрипта)
     * @param nameCommand - команда
     * @param routes - коллекция элементов
     * @param dateOfInitialization - дата создания коллекции
     * @param filename - имя файла для сохранения данных
     * @param bufferedReader - объект класса BufferedReader для ввода параметров мз файла
     * @throws IOException - если в команде execute_script будет исключение
     */
    public void choiceCommandScript(String nameCommand, Collection<?> routes, Object[] dateOfInitialization, Object[] filename, BufferedReader bufferedReader) throws IOException {
        try {
            String[] commandStructure = nameCommand.split(" ");
            switch (commandStructure[0]) {
                case "help":
                    history.add(Commands.getNameCommand(Commands.HELP));
                    new HelpCommand().executeManual();
                    break;
                case "info":
                    history.add(Commands.getNameCommand(Commands.INFO));
                    new InfoCommand().executeManual(routes, dateOfInitialization);
                    break;
                case "show":
                    history.add(Commands.getNameCommand(Commands.SHOW));
                    new ShowCommand().executeManual(routes);
                    break;
                case "add":
                    history.add(Commands.getNameCommand(Commands.ADD));
                    new AddElementCommand().executeScript(routes, bufferedReader);
                    break;
                case "update":
                    history.add(Commands.getNameCommand(Commands.UPDATE_ID));
                    new UpdateIdCommand().executeScript(routes, Long.parseLong(commandStructure[commandStructure.length - 1]), bufferedReader);
                    break;
                case "remove_by_id":
                    history.add(Commands.getNameCommand(Commands.REMOVE_BY_ID));
                    new RemoveByIdCommand().executeManual(routes, Long.parseLong(commandStructure[commandStructure.length - 1]));
                    break;
                case "clear":
                    history.add(Commands.getNameCommand(Commands.CLEAR));
                    new ClearCommand().executeManual(routes);
                    break;
                case "save":
                    history.add(Commands.getNameCommand(Commands.SAVE));
                    new SaveCommand().executeManual(routes, filename);
                    break;
                case "execute_script":
                    history.add(Commands.getNameCommand(Commands.EXECUTE_SCRIPT));
                    new ExecuteScriptCommand().executeManual(routes, commandStructure[1], dateOfInitialization);
                    break;
                case "exit":
                    history.add(Commands.getNameCommand(Commands.EXIT));
                    new ExitCommand().executeManual();
                    break;
                case "add_if_max":
                    history.add(Commands.getNameCommand(Commands.ADD_IF_MAX));
                    new AddIfMaxCommand().executeScript(routes, bufferedReader);
                    break;
                case "remove_greater":
                    history.add(Commands.getNameCommand(Commands.REMOVE_GREATER));
                    new RemoveGreaterCommand().executeScript(routes, bufferedReader);
                    break;
                case "history":
                    history.add(Commands.getNameCommand(Commands.HISTORY));
                    new HistoryCommand().executeManual(history);
                    break;
                case "group_counting_by_name":
                    history.add(Commands.getNameCommand(Commands.GROUP_COUNTING_BY_NAME));
                    new GroupCountingByNameCommand().executeManual(routes);
                    break;
                case "filter_by_distance":
                    history.add(Commands.getNameCommand(Commands.FILTER_BY_DISTANCE));
                    new FilterByDistanceCommand().executeManual(routes, Long.parseLong(commandStructure[1]));
                    break;
                case "print_descending":
                    history.add(Commands.getNameCommand(Commands.PRINT_DESCENDING));
                    new PrintDescending().executeManual(routes);
                    break;
                default:
                    System.out.println("Unknown command");
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            System.out.println("Incorrect parameter of command");
        }
    }

    /**
     * Метод, вызывающий определенную команду (для ручного ввода)
     * @param nameCommand - команда
     * @param routes - коллекция элементов
     * @param dateOfInitialization - дата создания коллекции
     * @param filename - имя файла для сохранения данных
     * @throws IOException - если в команде execute_script будет исключение
     */
    public void choiceCommandManual(String nameCommand, HashSet<Route> routes, LocalDate
    dateOfInitialization, String filename) throws IOException {
        try {
            String[] commandStructure = nameCommand.split(" ");
            switch (commandStructure[0]) {
                case "help":
                    history.add(Commands.getNameCommand(Commands.HELP));
                    new HelpCommand().executeManual();
                    break;
                case "info":
                    history.add(Commands.getNameCommand(Commands.INFO));
                    new InfoCommand().executeManual(routes, dateOfInitialization);
                    break;
                    case "show":
                    history.add(Commands.getNameCommand(Commands.SHOW));
                    new ShowCommand().executeManual(routes);
                    break;
                case "add":
                    history.add(Commands.getNameCommand(Commands.ADD));
                    new AddElementCommand().executeManual(routes);
                    break;
                case "update":
                    history.add(Commands.getNameCommand(Commands.UPDATE_ID));
                    new UpdateIdCommand().executeManual(routes, Long.parseLong(commandStructure[commandStructure.length - 1]));
                    break;
                case "remove_by_id":
                    history.add(Commands.getNameCommand(Commands.REMOVE_BY_ID));
                    new RemoveByIdCommand().executeManual(routes, Long.parseLong(commandStructure[commandStructure.length - 1]));
                    break;
                case "clear":
                    history.add(Commands.getNameCommand(Commands.CLEAR));
                    new ClearCommand().executeManual(routes);
                    break;
                case "save":
                    history.add(Commands.getNameCommand(Commands.SAVE));
                    new SaveCommand().executeManual(routes, filename);
                    break;
                case "execute_script":
                    history.add(Commands.getNameCommand(Commands.EXECUTE_SCRIPT));
                    new ExecuteScriptCommand().executeManual(routes, commandStructure[1], dateOfInitialization);
                    break;
                case "exit":
                    history.add(Commands.getNameCommand(Commands.EXIT));
                    new ExitCommand().executeManual();
                    break;
                case "add_if_max":
                    history.add(Commands.getNameCommand(Commands.ADD_IF_MAX));
                    new AddIfMaxCommand().executeManual(routes);
                    break;
                case "remove_greater":
                    history.add(Commands.getNameCommand(Commands.REMOVE_GREATER));
                    new RemoveGreaterCommand().executeManual(routes);
                    break;
                case "history":
                    history.add(Commands.getNameCommand(Commands.HISTORY));
                    new HistoryCommand().executeManual(history);
                    break;
                case "group_counting_by_name":
                    history.add(Commands.getNameCommand(Commands.GROUP_COUNTING_BY_NAME));
                    new GroupCountingByNameCommand().executeManual(routes);
                    break;
                case "filter_by_distance":
                    history.add(Commands.getNameCommand(Commands.FILTER_BY_DISTANCE));
                    new FilterByDistanceCommand().executeManual(routes, Long.parseLong(commandStructure[1]));
                    break;
                case "print_descending":
                    history.add(Commands.getNameCommand(Commands.PRINT_DESCENDING));
                    new PrintDescending().executeManual(routes);
                    break;
                default:
                    System.out.println("Unknown command");
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            System.out.println("Incorrect parameter of command");
        }
    }
}
