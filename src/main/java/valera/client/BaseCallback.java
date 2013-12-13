package valera.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseCallback<T> implements AsyncCallback<T>{

    Logger logger = Logger.getLogger("Logger");

    public void onFailure(Throwable ignored) {
        logger.log(Level.SEVERE, ignored.getMessage());
    }
}
