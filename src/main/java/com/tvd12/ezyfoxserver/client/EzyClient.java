package com.tvd12.ezyfoxserver.client;

import com.tvd12.ezyfoxserver.client.config.EzyClientConfig;
import com.tvd12.ezyfoxserver.client.constant.EzyConstant;
import com.tvd12.ezyfoxserver.client.entity.EzyUser;
import com.tvd12.ezyfoxserver.client.entity.EzyZone;
import com.tvd12.ezyfoxserver.client.manager.EzyAppByIdGroup;
import com.tvd12.ezyfoxserver.client.manager.EzyHandlerManager;
import com.tvd12.ezyfoxserver.client.manager.EzyPingManager;
import com.tvd12.ezyfoxserver.client.socket.EzyPingSchedule;
import com.tvd12.ezyfoxserver.client.socket.EzySender;
import com.tvd12.ezyfoxserver.client.util.EzyInstanceFetcher;

/**
 * Created by tavandung12 on 9/20/18.
 */

public interface EzyClient extends
        EzySender,
        EzyAppByIdGroup, EzyInstanceFetcher {

    void connect(String host, int port);

    void connect();

    boolean reconnect();

    void disconnect();
    
    void processEvents();

    String getName();

    EzyClientConfig getConfig();

    EzyZone getZone();

    String getZoneName();

    EzyUser getMe();

    EzyConstant getStatus();

    void setStatus(EzyConstant status);

    EzyPingManager getPingManager();

    EzyPingSchedule getPingSchedule();

    EzyHandlerManager getHandlerManager();

}
