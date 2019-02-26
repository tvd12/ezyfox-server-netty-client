package com.tvd12.ezyfoxserver.client.handler;

import com.tvd12.ezyfoxserver.client.EzyClient;
import com.tvd12.ezyfoxserver.client.socket.EzyPingSchedule;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tavandung12 on 9/30/18.
 */

public class EzyDataHandlers extends EzyAbstractHandlers {

    private final Map<Object, EzyDataHandler> handlers;

    public EzyDataHandlers(EzyClient client, EzyPingSchedule pingSchedule) {
        super(client, pingSchedule);
        this.handlers = new HashMap<>();
    }

    public void addHandler(Object cmd, EzyDataHandler handler) {
        this.configHandler(handler);
        this.handlers.put(cmd, handler);
    }

    public EzyDataHandler getHandler(Object cmd) {
        EzyDataHandler handler = handlers.get(cmd);
        return handler;
    }

}
