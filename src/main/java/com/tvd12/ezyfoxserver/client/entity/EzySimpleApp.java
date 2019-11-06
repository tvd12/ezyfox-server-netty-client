package com.tvd12.ezyfoxserver.client.entity;

import com.tvd12.ezyfox.builder.EzyArrayBuilder;
import com.tvd12.ezyfox.entity.EzyArray;
import com.tvd12.ezyfox.entity.EzyData;
import com.tvd12.ezyfox.entity.EzyEntity;
import com.tvd12.ezyfox.factory.EzyEntityFactory;
import com.tvd12.ezyfoxserver.client.EzyClient;
import com.tvd12.ezyfoxserver.client.constant.EzyCommand;
import com.tvd12.ezyfoxserver.client.handler.EzyAppDataHandler;
import com.tvd12.ezyfoxserver.client.handler.EzyAppDataHandlers;
import com.tvd12.ezyfoxserver.client.request.EzyRequest;

/**
 * Created by tavandung12 on 10/2/18.
 */

public class EzySimpleApp extends EzyEntity implements EzyApp {
    protected final int id;
    protected final String name;
    protected final EzyZone zone;
    protected final EzyClient client;
    protected final EzyAppDataHandlers dataHandlers;

    public EzySimpleApp(EzyZone zone, int id, String name) {
        this.client = zone.getClient();
        this.zone = zone;
        this.id = id;
        this.name = name;
        this.dataHandlers = client.getHandlerManager().getAppDataHandlers(name);
    }

    public void send(EzyRequest request) {
        String cmd = (String) request.getCommand();
        EzyData data = request.serialize();
        send(cmd, data);
    }

    public void send(String cmd) {
        send(cmd, EzyEntityFactory.EMPTY_OBJECT);
    }

    public void send(String cmd, EzyData data) {
        EzyArrayBuilder commandData = EzyEntityFactory.newArrayBuilder()
                .append(cmd)
                .append(data);
        EzyArray requestData = EzyEntityFactory.newArrayBuilder()
                .append(id)
                .append(commandData.build())
                .build();
        client.send(EzyCommand.APP_REQUEST, requestData);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public EzyClient getClient() {
        return client;
    }

    public EzyZone getZone() {
        return zone;
    }

    public EzyAppDataHandler<?> getDataHandler(Object cmd) {
        EzyAppDataHandler<?> handler = dataHandlers.getHandler(cmd);
        return handler;
    }
    
    @Override
    public String toString() {
    	return new StringBuilder()
    			.append("App(")
    			.append("id: ").append(id).append(", ")
    			.append("name: ").append(name)
    			.append(")")
    			.toString();
    }
}
