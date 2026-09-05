package dev.sverdlov.paymentservice.service.handler;

import dev.sverdlov.paymentservice.util.JsonConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CancelPaymentTransactionHandler implements PaymentTransactionCommandHandler {

    @Override
    public void process(String requestId, String message) {
        var request = JsonConverter.toObject(message, CancelPaymentTransactionHandler.class);

    }
}
