package mainProgram.utils;

import java.util.Scanner;

/**
 * класс возврата имени файла с данными
 */
public class FileNameTaker {
    /**
     * метод, возвращающий имя файла с данными из переменной окружения
     * @return filename
     */
    public String getFileNameFromEnvironment() {
        System.out.println("Write the name of the environment variable containing the file name:");
        String lineWithName = new Scanner(System.in).nextLine();
        String fileName = System.getenv(lineWithName);
        if (fileName == null) {
            return getFileNameFromEnvironment();
        } else return fileName;
    }
}
