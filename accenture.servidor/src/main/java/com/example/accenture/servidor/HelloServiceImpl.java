package com.example.accenture.servidor;

import com.example.grpc.HelloProto;
import com.example.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

  @Override
  public void sayHello(HelloProto.HelloRequest request, StreamObserver<HelloProto.HelloResponse> responseObserver) {
    String greeting = "Bauti, " + request.getName();
    HelloProto.HelloResponse response = HelloProto.HelloResponse.newBuilder().setMessage(greeting).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}