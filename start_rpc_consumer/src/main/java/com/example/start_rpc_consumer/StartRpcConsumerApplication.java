package com.example.start_rpc_consumer;

        import com.example.start_interface.RPCClient;
        import com.example.start_interface.RPCClientHandler;
        import com.example.start_interface.UserService;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartRpcConsumerApplication {

    public static final String providerName = "com.example.start_rpc_provider.UserServiceImpl#test#";


    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(StartRpcConsumerApplication.class, args);

        RPCClient rpcClient = new RPCClient();
        UserService userService = (UserService) rpcClient.createProxy(UserService.class,providerName
                ,new RPCClientHandler(),"localhost", 8888);
        for (;;) {
            System.out.println("ok???");
            Thread.sleep(1000);
            System.out.println(userService.test(12));
            System.out.println("ok");
        }
    }

}
