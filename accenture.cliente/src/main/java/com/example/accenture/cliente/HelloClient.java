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
        blockingStub = BookServiceGrpc.newBlockingStub(channel);
    }


    public void greet(Long id_book) {
        try {
            HelloProto.BookRequest request = BookRequest.newBuilder().setIdBook(id_book).build();
            HelloProto.BookResponse response = blockingStub.sayHello(request);
            System.out.println("Author: " + response.getAuthor() + ", Genre: " + response.getGenre());
        } catch (StatusRuntimeException e) {
            System.out.println("gRPC failed: " + e.getStatus());
        }
    }
}
// que hacemos que rompe? no se el sayHello proba si funca con postman @tobi
// toy viendo jeje
