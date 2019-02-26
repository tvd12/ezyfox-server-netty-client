package com.tvd12.ezyfoxserver.client.manager;

import com.tvd12.ezyfoxserver.client.constant.EzyConstant;
import com.tvd12.ezyfoxserver.client.handler.EzyAppDataHandlers;
import com.tvd12.ezyfoxserver.client.handler.EzyDataHandler;
import com.tvd12.ezyfoxserver.client.handler.EzyEventHandler;

/**
 * Created by tavandung12 on 10/9/18.
 */

@SuppressWarnings("rawtypes")
public interface EzyHandlerManager {

    EzyDataHandler getDataHandler(Object cmd);

	EzyEventHandler getEventHandler(EzyConstant eventType);

    void addDataHandler(Object cmd, EzyDataHandler dataHandler);

    void addEventHandler(EzyConstant eventType, EzyEventHandler eventHandler);

    EzyAppDataHandlers getAppDataHandlers(String appName);
}
