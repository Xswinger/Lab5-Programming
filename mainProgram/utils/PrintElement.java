package mainProgram.utils;

import mainProgram.classes.Route;

public class PrintElement {
    public static void fromNull(Route route){
        System.out.println(route.getId() + " " + route.getName() + " " + route.getCoordinates().getX() + " " +
                route.getCoordinates().getY() + " " + route.getCreationDate() + " " +  route.getTo().getX() + " " + route.getTo().getY() + " " +
                route.getTo().getZ() + " " + route.getTo().getName() + " " + route.getDistance());
    }

    public static void fromNotNull(Route route){
        System.out.println(route.getId() + " " + route.getName() + " " + route.getCoordinates().getX() + " " +
                route.getCoordinates().getY() + " " + route.getCreationDate() + " " + route.getFrom().getX() + " " +
                route.getFrom().getY() + " " + route.getFrom().getZ() + " " + route.getTo().getX() + " " + route.getTo().getY() + " " +
                route.getTo().getZ() + " " + route.getTo().getName() + " " + route.getDistance());
    }
}
