package com.example.start_interface;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

public class RPCClientHandler extends ChannelInboundHandlerAdapter implements Callable {
    private ChannelHandlerContext context;
    //结果
    private Object result;
    //参数
    private RPCParam rpcParam;

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        context = ctx;
    }

    /**
     * 收到服务端数据，唤醒等待线程
     */
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) {
        result = msg;
        notify();
    }

    /**
     * 写出数据，开始等待唤醒
     */
    @Override
    public synchronized Object call() throws InterruptedException {
        System.out.println("sadas");
        context.writeAndFlush(rpcParam);
        //context.writeAndFlush("as");
        wait();
        return result;
    }

    public RPCParam getRpcParam() {
        return rpcParam;
    }

    public void setRpcParam(RPCParam rpcParam) {
        this.rpcParam = rpcParam;
    }
}
