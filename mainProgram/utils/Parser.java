package mainProgram.utils;

import mainProgram.classes.Coordinates;
import mainProgram.classes.locations.locationTo.Location;
import mainProgram.classes.Route;
import mainProgram.exceptions.WrongInputDataException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 *
 */
public class Parser {
    /**
     * Метод для чтения данных из файла
     *
     * @param fileInputStream
     * @return Коллекция элементов
     * @throws IOException
     */
    public static HashSet<Route> outFile(FileInputStream fileInputStream) throws IOException {
        try {
            HashSet<Route> routes = new HashSet<>();
            BufferedInputStream file = new BufferedInputStream(fileInputStream);
            String str = "";
            int i;
            List<String> list = new ArrayList<>();
            boolean check = true;
            while (check == true) {
                i = file.read();
                if (i != 10 && i != -1 && i != 13) {
                    str += (char) i;
                }
                if (i == 10) {
                    list.add(str);
                    str = "";
                }
                if (i == -1) {
                    list.add(str);
                    str = "";
                    check = false;
                }
            }
            boolean sizeIsNull = false;
            if (Objects.equals(list.get(0), "") && list.size() == 1) {
                list.clear();
                sizeIsNull = true;
            }
            for (i = 0; i < list.size(); i++) {
                String[] data = list.get(i).split(",");
                if (data.length == 13) {
                    routes.add(new Route(Route.checkId(Long.parseLong(data[0])), Route.checkName(data[1]),
                            Route.checkCoordinate(new Coordinates(Coordinates.checkX(Long.parseLong(data[2])),
                                    Coordinates.checkY(Integer.parseInt(data[3])))), Route.checkData(LocalDate.parse(data[4])),
                            new mainProgram.classes.locations.locationFrom.Location(Float.parseFloat(data[5]),
                                    Double.parseDouble(data[6]),
                                    mainProgram.classes.locations.locationFrom.Location.checkZ(Integer.parseInt(data[7]))),
                            Route.checkLocationTo(new Location(Location.checkX(Integer.parseInt(data[8])),
                                    Long.parseLong(data[9]), Float.parseFloat(data[10]), Location.checkName(data[11]))),
                            Route.checkDistance(Integer.parseInt(data[12]))));
                } else if (data.length == 10) {
                    routes.add(new Route(Route.checkId(Long.parseLong(data[0])), Route.checkName(data[1]),
                            Route.checkCoordinate(new Coordinates(Coordinates.checkX(Long.parseLong(data[2])),
                                    Coordinates.checkY(Integer.parseInt(data[3])))), Route.checkData(LocalDate.parse(data[4])),
                            null,
                            new Location(Location.checkX(Integer.parseInt(data[5])),
                                    Long.parseLong(data[6]), Float.parseFloat(data[7]), Location.checkName(data[8])),
                            Route.checkDistance(Integer.parseInt(data[9]))));
                } else {
                    throw new WrongInputDataException(String.valueOf(i + 1));
                }
            }
            file.close();
            if (sizeIsNull) {
                System.out.println("File empty");
            } else {
                System.out.println("Input data uploaded successfully");
            }
            return routes;

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
            return null;
        } catch (NumberFormatException ex) {
            System.out.println("Invalid input variable format");
            System.exit(1);
            return null;
        } catch (WrongInputDataException | IndexOutOfBoundsException | DateTimeParseException ex) {
            System.out.println("Invalid input string format (change input data in your file)");
            System.exit(1);
            return null;
        }
    }

    /**
     * Метод для записи данных в файл
     *
     * @param routes
     * @param filename
     * @return
     * @throws IOException
     */
    public static String InFile(HashSet<Route> routes, String filename) throws IOException {
        try {
            List<String> list = new ArrayList<>();
            for (Route route : routes) {
                String strData;
                String valueZ;
                if (route.getFrom() == null) {
                    strData = route.getId() + "," + route.getName() + "," + route.getCoordinates().getX() + ","
                            + route.getCoordinates().getY() + "," + route.getCreationDate() + ","
                            + route.getTo().getX() + "," + route.getTo().getY() + "," + (int) route.getTo().getZ()
                            + "," + route.getTo().getName() + "," + route.getDistance();
                } else {
                    valueZ = String.valueOf(route.getFrom().getZ());
                    strData = route.getId() + "," + route.getName() + "," + route.getCoordinates().getX() + ","
                            + route.getCoordinates().getY() + ","
                            + route.getCreationDate() + "," + (int) route.getFrom().getX() + ","
                            + (int) route.getFrom().getY() + "," + valueZ + ","
                            + route.getTo().getX() + "," + route.getTo().getY() + "," + (int) route.getTo().getZ() + ","
                            + route.getTo().getName() + "," + route.getDistance();
                }
                list.add(strData);

            }
            int i = 0;
            BufferedOutputStream file = new BufferedOutputStream(new FileOutputStream(filePath(filename)));
            for (String data : list) {
                file.write(data.getBytes());
                if (i != (list.size() - 1)) {
                    file.write(10);
                }
                i++;
            }
            file.close();
            return "Collection saved successfully";
        } catch (FileNotFoundException ex) {
            System.out.println("File with that name not found");
            System.exit(1);
            return null;
        }
    }

    /**
     * Метод, возвращающий полный путь файла
     *
     * @param filename
     * @return
     */
    public static String filePath(String filename) {
        File path = new File(Parser.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        String propertiesPath = path.getParentFile().getAbsolutePath();
        return (propertiesPath + "/" + filename);
    }
}

