package com.tvd12.ezyfoxserver.client.serialize;

import com.tvd12.ezyfox.entity.EzyArray;
import com.tvd12.ezyfox.entity.EzyObject;
import com.tvd12.ezyfoxserver.client.request.EzyRequest;

public interface EzyRequestSerializer {
	
	<T> T serialize(EzyRequest request, Class<T> outType);
	
	default EzyObject serializeToObject(EzyRequest request) {
		return serialize(request, EzyObject.class);
	}
	
	default EzyArray serializeToArray(EzyRequest request) {
		return serialize(request, EzyArray.class);
	}
	
}
