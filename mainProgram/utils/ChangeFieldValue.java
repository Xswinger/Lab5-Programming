package mainProgram.utils;

import mainProgram.classes.Route;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class ChangeFieldValue {
    public static void ChangeFieldValueManual(Route route) {
        try {
            Scanner lineWithFieldName = new Scanner(System.in);
            if (route.getFrom() != null) {
                System.out.println("Names of the field:\nname" +
                        "\ncoordinate x\ncoordinate y\nlocation from x\nlocation from y\nlocation from z\nlocation to x" +
                        "\nlocation to y\nlocation to z\nlocation to name\ndistance\n" +
                        "Enter the name of the field whose value you want to change:");
            } else {
                System.out.println("Names of the field:\nname" +
                        "\ncoordinate x\ncoordinate y\nlocation to x\nlocation to y" +
                        "\nlocation to z\nlocation to name\ndistance\nEnter the " +
                        "name of the field whose value you want to change:");
            }
            switch (lineWithFieldName.nextLine()) {
                case "name":
                    route.setName(InputData.InputName());
                    break;
                case "coordinate x":
                    route.getCoordinates().setX(InputData.InputCoordinatesX());
                    break;
                case "coordinate y":
                    route.getCoordinates().setY(InputData.InputCoordinatesY());
                    break;
                case "location from x":
                    route.getFrom().setX((float) InputData.InputLocationFromX());
                    break;
                case "location from y":
                    route.getFrom().setY(InputData.InputLocationFromY());
                    break;
                case "location from z":
                    route.getFrom().setZ(InputData.InputLocationFromZ());
                    break;
                case "location to x":
                    route.getTo().setX(InputData.InputLocationToX());
                    break;
                case "location to y":
                    route.getTo().setY(InputData.InputLocationToY());
                    break;
                case "location to z":
                    route.getTo().setZ(InputData.InputLocationToZ());
                    break;
                case "location to name":
                    route.getTo().setName(InputData.InputLocationName());
                    break;
                case "distance":
                    route.setDistance(InputData.InputDistance());
                    break;
                default:
                    System.out.println("Unknown field");
                    ChangeFieldValueManual(route);
            }
            System.out.println("Field update successfully");
        }
        catch(NumberFormatException ex){
            System.out.println("Invalid input variable format");
        }
    }

    public static void ChangeFieldValueScript(Route route, BufferedReader bufferedReader) throws IOException {
        try {
            if (route.getFrom() != null) {
                System.out.println("Names of the field:\nname" +
                        "\ncoordinate x\ncoordinate y\nlocation from x\nlocation from y\nlocation from z\nlocation to x" +
                        "\nlocation to y\nlocation to z\nlocation to name\ndistance\n" +
                        "Entering the name of the field whose value you want to change");
            } else {
                System.out.println("Names of the field:\nname" +
                        "\ncoordinate x\ncoordinate y\nlocation to x\nlocation to y" +
                        "\nlocation to z\nlocation to name\ndistance\nEntering the " +
                        "name of the field whose value you want to change");
            }
            switch (bufferedReader.readLine()) {
                case "name":
                    route.setName(bufferedReader.readLine());
                    break;
                case "coordinate x":
                    route.getCoordinates().setX(Long.parseLong(bufferedReader.readLine()));
                    break;
                case "coordinate y":
                    route.getCoordinates().setY(Integer.parseInt(bufferedReader.readLine()));
                    break;
                case "location from x":
                    route.getFrom().setX((float) Integer.parseInt(bufferedReader.readLine()));
                    break;
                case "location from y":
                    route.getFrom().setY(Double.parseDouble(bufferedReader.readLine()));
                    break;
                case "location from z":
                    route.getFrom().setZ(Integer.parseInt(bufferedReader.readLine()));
                    break;
                case "location to x":
                    route.getTo().setX(Integer.parseInt(bufferedReader.readLine()));
                    break;
                case "location to y":
                    route.getTo().setY(Long.parseLong(bufferedReader.readLine()));
                    break;
                case "location to z":
                    route.getTo().setZ(Float.parseFloat(bufferedReader.readLine()));
                    break;
                case "location to name":
                    route.getTo().setName(bufferedReader.readLine());
                    break;
                case "distance":
                    route.setDistance(Integer.parseInt(bufferedReader.readLine()));
                    break;
                default:
                    System.out.println("Unknown field");
                    ChangeFieldValueManual(route);
            }
            System.out.println("Field update successfully");
        }
        catch(NumberFormatException ex){
            System.out.println("Invalid input variable format");
        }
    }
}
