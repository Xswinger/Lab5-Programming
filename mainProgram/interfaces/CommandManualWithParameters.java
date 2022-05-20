package mainProgram.interfaces;

import java.io.IOException;
import java.util.Collection;

public interface CommandManualWithParameters {
    void executeManual(Collection<?> collection, Object... args) throws IOException;
}
