package com.tvd12.ezyfoxserver.client.handler;

import com.tvd12.ezyfoxserver.client.event.EzyConnectionSuccessEvent;
import com.tvd12.ezyfoxserver.client.event.EzyEvent;
import com.tvd12.ezyfoxserver.client.socket.EzySimpleSocketEvent;
import com.tvd12.ezyfoxserver.client.socket.EzySocketEvent;
import com.tvd12.ezyfoxserver.client.socket.EzySocketEventType;

import io.netty.channel.ChannelHandlerContext;

public class EzySocketChannelHandler extends EzyChannelHandler {
	
	public EzySocketChannelHandler(Builder builder) {
		super(builder);
	}
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		EzyEvent event = new EzyConnectionSuccessEvent();
		EzySocketEvent socketEvent = new EzySimpleSocketEvent(EzySocketEventType.EVENT, event);
		socketEventQueue.add(socketEvent);
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder extends EzyChannelHandler.Builder<Builder> {

		@Override
		public EzyChannelHandler build() {
			return new EzySocketChannelHandler(this);
		}
		
	}
}
