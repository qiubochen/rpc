package com.example.start_rpc_provider;

import com.example.start_interface.RPCServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartRpcProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartRpcProviderApplication.class, args);
        //UserServiceImpl.startServer("localhost", 8990);
        RPCServer.startServer("localhost", 8888);
    }

}
