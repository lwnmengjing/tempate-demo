package com.<no value>.<no value>.controller;

import com.<no value>.<no value>.model.EmailServiceGrpc;
import com.<no value>.<no value>.model.MailRequestDTO;
import com.<no value>.<no value>.model.MailResponseDTO;
import io.grpc.stub.StreamObserver;
import lombok.extern.log4j.Log4j2;
import net.devh.boot.grpc.server.service.GrpcService;

@Log4j2
@GrpcService
public class <no value>Controller extends EmailServiceGrpc.EmailServiceImplBase {

  @Override
  public void sendFormattedMail(MailRequestDTO request,
      StreamObserver<MailResponseDTO> responseObserver) {
    responseObserver.onNext(MailResponseDTO.newBuilder().setResponse("ok").build());
    responseObserver.onCompleted();
  }
}
