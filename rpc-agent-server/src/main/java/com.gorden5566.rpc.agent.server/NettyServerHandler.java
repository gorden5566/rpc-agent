package com.gorden5566.rpc.agent.server;

import com.alibaba.fastjson.JSON;
import com.gorden5566.rpc.agent.core.Agent;
import com.gorden5566.rpc.agent.core.internal.RpcRequestConfig;
import com.gorden5566.rpc.agent.core.internal.RpcResponse;
import com.gorden5566.rpc.agent.core.util.JsonUtils;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.netty.handler.codec.http.HttpHeaderNames.*;
import static io.netty.handler.codec.http.HttpHeaderNames.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaderValues.*;
import static io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;

/**
 * @author gorden5566
 * @date 2021/07/06
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    private static final byte[] DEFAULT_CONTENT =
        "Wrong url, please use '/agent' as path!!!".getBytes(StandardCharsets.UTF_8);

    private final Agent agent = Agent.newInstance();

    private FullHttpRequest request;

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        this.request = request;
        FullHttpResponse response = null;
        String uri = request.uri();
        switch (uri) {
            case "/agent":
                response = invoke(request.content().toString(CharsetUtil.UTF_8));
                break;
            default:
                response = getDefaultResponse();
        }

        setKeepAlive(response);

        HttpUtil.setContentLength(response, response.content().readableBytes());

        ctx.writeAndFlush(response);
    }

    private FullHttpResponse getDefaultResponse() {
        FullHttpResponse response =
            new DefaultFullHttpResponse(request.protocolVersion(), OK, Unpooled.wrappedBuffer(DEFAULT_CONTENT));
        response.headers().set(CONTENT_TYPE, TEXT_PLAIN);
        return response;
    }

    private void setKeepAlive(FullHttpResponse response) {
        boolean keepAlive = HttpUtil.isKeepAlive(request);
        if (keepAlive) {
            if (!request.protocolVersion().isKeepAliveDefault()) {
                response.headers().set(CONNECTION, KEEP_ALIVE);
            }
        } else {
            response.headers().set(CONNECTION, CLOSE);
        }
    }

    private FullHttpResponse invoke(String request) {
        try {
            // parse request
            RpcRequestConfig config = buildRpcRequestConfig(request);

            // invoke
            String result = agent.invoke(config);

            // write result
            FullHttpResponse response = new DefaultFullHttpResponse(this.request.protocolVersion(), OK,
                Unpooled.copiedBuffer(result.getBytes()));

            response.headers().set(CONTENT_TYPE, "application/json;charset=UTF-8").set("reqId", agent.getReqId());

            return response;
        } catch (Exception e) {
            RpcResponse error = RpcResponse.newThrowableError("remote call failed: [" + request + "]", e);
            FullHttpResponse response = new DefaultFullHttpResponse(this.request.protocolVersion(), OK,
                Unpooled.copiedBuffer(JsonUtils.toPrettyJson(error).getBytes()));
            response.headers().set(CONTENT_TYPE, "application/json;charset=UTF-8");
            return response;
        } finally {
            agent.finishInvoke();
        }
    }

    private RpcRequestConfig buildRpcRequestConfig(String content) throws IOException {
        return JSON.parseObject(content, RpcRequestConfig.class);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
