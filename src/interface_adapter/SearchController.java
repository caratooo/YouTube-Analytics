package interface_adapter;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface SearchController {
    void callExecute(String data, String username) throws GeneralSecurityException, IOException;
}
