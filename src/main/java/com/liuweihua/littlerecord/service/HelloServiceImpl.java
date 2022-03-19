package com.liuweihua.littlerecord.service;

import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GrpcService
public class HelloServiceImpl extends com.liuweihua.littlerecord.grpc.HelloServiceGrpc.HelloServiceImplBase{
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceImpl.class);

    @Override
    public void hello(com.liuweihua.littlerecord.grpc.HelloRequest request, StreamObserver<com.liuweihua.littlerecord.grpc.HelloResponse> responseObserver) {
        LOGGER.info("server received {}", request);

        String greeting = "Hi " + request.getName() + " you are " + request.getAge() + " years old" +
                " your hoby is " + (request.getHobbiesList()) + " your tags " + request.getTagsMap();

        com.liuweihua.littlerecord.grpc.HelloResponse response = com.liuweihua.littlerecord.grpc.HelloResponse.newBuilder().setGreeting( greeting ).build();
        responseObserver.onNext( response );
        responseObserver.onCompleted();
    }
}
