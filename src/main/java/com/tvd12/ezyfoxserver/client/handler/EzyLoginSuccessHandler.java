package com.tvd12.ezyfoxserver.client.handler;

import com.tvd12.ezyfox.entity.EzyArray;
import com.tvd12.ezyfox.entity.EzyData;
import com.tvd12.ezyfoxserver.client.entity.EzyMeAware;
import com.tvd12.ezyfoxserver.client.entity.EzySimpleUser;
import com.tvd12.ezyfoxserver.client.entity.EzySimpleZone;
import com.tvd12.ezyfoxserver.client.entity.EzyUser;
import com.tvd12.ezyfoxserver.client.entity.EzyZone;
import com.tvd12.ezyfoxserver.client.entity.EzyZoneAware;

/**
 * Created by tavandung12 on 10/1/18.
 */

public class EzyLoginSuccessHandler extends EzyAbstractDataHandler {

    @Override
    public void handle(EzyArray data) {
        EzyArray joinedApps = data.get(4, EzyArray.class);
        EzyData responseData = data.get(5, EzyData.class);
        EzyUser user = newUser(data);
        EzyZone zone = newZone(data);
        ((EzyMeAware)client).setMe(user);
        ((EzyZoneAware)client).setZone(zone);
        handleLoginSuccess(joinedApps, responseData);
        logger.debug("user: {} logged in successfully", user);
    }
    
    protected void handleLoginSuccess(EzyArray joinedApps, EzyData responseData) {}

    protected EzyUser newUser(EzyArray data) {
        long userId = data.get(2, long.class);
        String username = data.get(3, String.class);
        EzySimpleUser user = new EzySimpleUser(userId, username);
        return user;
    }

    protected EzyZone newZone(EzyArray data) {
        int zoneId = data.get(0, int.class);
        String zoneName = data.get(1, String.class);
        EzySimpleZone zone = new EzySimpleZone(client, zoneId, zoneName);
        return zone;
    }

}
