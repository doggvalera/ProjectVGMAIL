package valera.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class BaseCallback<T> implements AsyncCallback<T> {

    public void onFailure(Throwable ignored) {
        GWT.log(ignored.getLocalizedMessage());
    }
}
