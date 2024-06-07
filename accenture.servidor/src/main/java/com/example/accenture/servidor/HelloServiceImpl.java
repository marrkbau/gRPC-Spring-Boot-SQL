package com.example.accenture.servidor;

import com.example.grpc.HelloProto;
import com.example.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloProto.BookRequest request, StreamObserver<HelloProto.BookResponse> responseObserver) {

        Book book = bookRepository.findById(request.getIdBook()).get();
        HelloProto.BookResponse response = HelloProto.BookResponse.newBuilder()
                .setIdBook(book.getId())
                .setAuthor(book.getAuthor())
                .setGenre(book.getGenre())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}