package mainProgram;

/**
 * Enum для хранения команды и ее описания
 */
//#TODO Переименовать переменные
public enum Commands {
    HELP("help", "вывести справку по доступным командам"),
    INFO("info", "вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)"),
    SHOW("show", "вывести в стандартный поток вывода все элементы коллекции в строковом представлении"),
    ADD("add", "добавить новый элемент в коллекцию"),
    UPDATE_ID("update id {element}", "обновить значение элемента коллекции, id которого равен заданному"),
    REMOVE_BY_ID("remove_by_id id", "удалить элемент из коллекции по его id"),
    CLEAR("clear" ,"очистить коллекцию"),
    SAVE("save", "сохранить коллекцию в файл"),
    EXECUTE_SCRIPT("execute_script file_name", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме."),
    EXIT("exit", "завершить программу (без сохранения в файл)"),
    ADD_IF_MAX("add_if_max {element}", "добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции"),
    REMOVE_GREATER("remove_greater {element}", "удалить из коллекции все элементы, превышающие заданный"),
    HISTORY("history", "вывести последние 12 команд (без их аргументов)"),
    GROUP_COUNTING_BY_NAME("group_counting_by_name", "сгруппировать элементы коллекции по значению поля name, вывести количество элементов в каждой группе"),
    FILTER_BY_DISTANCE("filter_by_distance distance", "вывести элементы, значение поля distance которых равно заданному"),
    PRINT_DESCENDING("print_descending", "вывести элементы коллекции в порядке убывания");

    private final String commandName;
    private final String commandsDescription;

    /**
     * Конструктор Commands
     * @param commandName - имя команды
     * @param commandsDescription - описание команды
     */
    Commands(String commandName, String commandsDescription) {
        this.commandName = commandName;
        this.commandsDescription = commandsDescription;
    }

    /**
     * Метод для получения имени команды
     * @param nameCommand - имя команды
     * @return Имя команды
     */
    public static String getNameCommand(Commands nameCommand){
        return nameCommand.commandName;
    }

    /**
     * Метод для получения описания команды
     * @param command - описание команды
     * @return Описание команды
     */
    public static String getDescription(Commands command) {
        return command.commandsDescription;
    }
}
