package storage;

import java.io.IOException;

public interface Loadable {
    public String load(String s) throws IOException;
}
