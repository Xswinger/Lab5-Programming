package mainProgram.interfaces;

import java.io.IOException;
import java.util.Collection;

public interface CommandScript {
    void executeScript(Collection<?> collection, Object... args) throws IOException;
}
