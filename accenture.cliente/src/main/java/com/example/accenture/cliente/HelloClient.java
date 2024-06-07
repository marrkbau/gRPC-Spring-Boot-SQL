package com.example.accenture.cliente;



import com.example.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.example.grpc.HelloProto.HelloRequest;
import com.example.grpc.HelloProto.HelloResponse;
import com.example.grpc.HelloServiceGrpc.HelloServiceBlockingStub;

public class HelloClient {

  private final HelloServiceBlockingStub blockingStub;

  public HelloClient(String host, int port) {
    ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
        .usePlaintext()
        .build();
    blockingStub = HelloServiceGrpc.newBlockingStub(channel);
  }

  public void greet(String name) {
    HelloRequest request = HelloRequest.newBuilder().setName(name).build();
    HelloResponse response = blockingStub.sayHello(request);
    System.out.println(response.getMessage());
  }

}
