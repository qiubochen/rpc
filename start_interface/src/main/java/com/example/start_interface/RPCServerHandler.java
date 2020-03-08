package com.example.start_interface;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RPCServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("test1");
        System.out.println(msg.toString());
        RPCParam rpcParam = (RPCParam) msg;
        String className =  rpcParam.getClazzName();
        String methodName = rpcParam.getMethodName();

        try {
            Class clazz = Class.forName(className);
            Object object = clazz.newInstance();

            Method method = object.getClass().getDeclaredMethod(methodName,rpcParam.getParamTypes());

            Object result = method.invoke(object,rpcParam.getParams());
            ctx.writeAndFlush(result);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
