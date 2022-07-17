package com.<no value>.<no value>.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.<no value>.<no value>.model.EmailServiceGrpc;
import com.<no value>.<no value>.model.EmailServiceGrpc.EmailServiceBlockingStub;
import com.<no value>.<no value>.model.MailRequestDTO;
import com.<no value>.<no value>.model.MailResponseDTO;
import io.grpc.inprocess.InProcessChannelBuilder;
import io.grpc.inprocess.InProcessServerBuilder;
import io.grpc.testing.GrpcCleanupRule;
import java.io.IOException;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class <no value>ControllerUnitTest {
  @Rule
  public final GrpcCleanupRule grpcCleanup = new GrpcCleanupRule();

  <no value>Controller controller;

  @BeforeEach
  void setUp() {
    controller = new <no value>Controller();
  }

  @Test
  void test() throws IOException {
    // Generate a unique in-process server name.
    String serverName = InProcessServerBuilder.generateName();

    // Create a server, add service, start, and register for automatic graceful shutdown.
    grpcCleanup.register(
        InProcessServerBuilder.forName(serverName)
            .directExecutor()
            .addService(controller)
            .build()
            .start());

    EmailServiceBlockingStub blockingStub = EmailServiceGrpc.newBlockingStub(
        // Create a client channel and register for automatic graceful shutdown.
        grpcCleanup.register(
            InProcessChannelBuilder.forName(serverName).directExecutor().build()));

    MailResponseDTO reply =
        blockingStub.sendFormattedMail(
            MailRequestDTO.newBuilder()
                .setEmail("test@qq.com")
                .setType("verification-code")
                .build());

    assertEquals("ok", reply.getResponse());
  }
}
