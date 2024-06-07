package com.example.accenture.servidor;

import com.example.accenture.servidor.Book.Book;
import com.example.accenture.servidor.repositories.BookRepository;
import com.example.grpc.BookServiceGrpc;
import com.example.grpc.HelloProto;
import com.example.grpc.BookServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl extends BookServiceGrpc.BookServiceImplBase {

    @Autowired
    BookRepository bookRepository;

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