package mainProgram.classes;

import java.util.HashSet;
import java.util.Set;

public class Id {
    private static long id = 1;
    private static Set<Long> idSet = new HashSet<>();

    public static long addId(){
        while (!idSet.add(id)){
            Id.increaseId(id);
        }
        return id;
    }

    public static void increaseId(long id){
        Id.id += 1;
    }

    public static long getId() {
        return id;
    }

    public static Set<Long> getIdSet() {
        return idSet;
    }
}
