package mainProgram.utils;

import mainProgram.classes.Coordinates;
import mainProgram.classes.Id;
import mainProgram.classes.locations.locationFrom.Location;
import mainProgram.classes.Route;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreatingElement {
    public static Route CreatingElementManual() {
        String name = Route.checkName(InputData.InputName());
        Coordinates coordinates = Route.checkCoordinate(new Coordinates(Coordinates.checkX(InputData.InputCoordinatesX()),
                Coordinates.checkY(InputData.InputCoordinatesY())));
        LocalDate creationDate = LocalDate.now();
        Location from = null;
        Object X = InputData.InputLocationFromX();
        if (!X.toString().equals("none")) {
            from = new Location(Float.parseFloat(X.toString()), InputData.InputLocationFromY(),
                    Location.checkZ(InputData.InputLocationFromZ()));
        }
        mainProgram.classes.locations.locationTo.Location to = Route.checkLocationTo(new
                mainProgram.classes.locations.locationTo.Location(mainProgram.classes.locations.locationTo.Location.checkX(InputData.InputLocationToX()),
                InputData.InputLocationToY(), InputData.InputLocationToZ(), Route.checkName(InputData.InputLocationName())));
        int distance = Route.checkDistance(InputData.InputDistance());
        Route addedRoute;
        if ("none".equals(X.toString())) {
            addedRoute = new Route(Id.addId(), name, coordinates, creationDate, to, distance);
        } else {
            addedRoute = new Route(Id.addId(), name, coordinates, creationDate, from, to, distance);
        }
        return addedRoute;
    }

    public static Route CreatingElementScript(BufferedReader bufferedReader) throws IOException {
            String bufferName = bufferedReader.readLine();
            String bufferCoordinateX = bufferedReader.readLine();
            String bufferCoordinateY = bufferedReader.readLine();
            String bufferFromX = bufferedReader.readLine();
            String bufferFromY = "";
            String bufferFromZ = "";
            Location from = null;
            Object X = bufferFromX;
            if (!X.toString().equals("")){
                bufferFromY = bufferedReader.readLine();
                bufferFromZ = bufferedReader.readLine();
            }
            String bufferToX = bufferedReader.readLine();
            String bufferToY = bufferedReader.readLine();
            String bufferToZ = bufferedReader.readLine();
            String bufferToName = bufferedReader.readLine();
            String bufferDistance = bufferedReader.readLine();
            String name = Route.checkName(bufferName);
            Coordinates coordinates = Route.checkCoordinate(new Coordinates(Coordinates.checkX(Long.parseLong(bufferCoordinateX)),
                    Coordinates.checkY(Integer.parseInt(bufferCoordinateY))));
            LocalDate creationDate = LocalDate.now();
            if (!X.toString().equals("")) {
                from = new Location(Float.parseFloat(X.toString()), Double.parseDouble(bufferFromY),
                        Location.checkZ(Integer.parseInt(bufferFromZ)));
            }
            mainProgram.classes.locations.locationTo.Location to = Route.checkLocationTo(new
                    mainProgram.classes.locations.locationTo.Location(mainProgram.classes.locations.locationTo.Location.checkX(Integer.parseInt(bufferToX)),
                    Long.parseLong(bufferToY), Float.parseFloat(bufferToZ), Route.checkName(bufferToName)));
            int distance = Route.checkDistance(Integer.parseInt(bufferDistance));
            Route addedRoute;
            if ("none".equals(X.toString())) {
                addedRoute = new Route(Id.addId(), name, coordinates, creationDate, to, distance);
            } else {
                addedRoute = new Route(Id.addId(), name, coordinates, creationDate, from, to, distance);
            }
            return addedRoute;
    }
}
