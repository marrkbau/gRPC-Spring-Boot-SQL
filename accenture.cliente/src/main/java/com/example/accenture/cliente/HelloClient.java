package com.example.accenture.cliente;


import com.example.grpc.HelloProto;
import com.example.grpc.BookServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.example.grpc.HelloProto.BookRequest;
import com.example.grpc.HelloProto.BookResponse;
import com.example.grpc.BookServiceGrpc;
import io.grpc.StatusRuntimeException;

public class HelloClient {

    private final BookServiceGrpc.BookServiceBlockingStub blockingStub;

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

//ES en server
// el metodo que dice sayHello es de server
// Fijate cambiar el sayHello, me tira gpt algo asi
/*
@Override
public void sayHello(BookRequest request, StreamObserver<BookResponse> responseObserver) {
    String author = "Author Name"; // Datos de ejemplo
    String genre = "Genre Name";   // Datos de ejemplo
    BookResponse response = BookResponse.newBuilder()
            .setAuthor(author)
            .setGenre(genre)
            .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
}
*/
// funca? solo dios sabe. Tobi no responde jsajsja por whatsapp noma