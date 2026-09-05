package dev.sverdlov.paymentservice.config;

import dev.sverdlov.paymentservice.model.enums.PaymentTransactionCommand;
import dev.sverdlov.paymentservice.service.handler.CancelPaymentTransactionHandler;
import dev.sverdlov.paymentservice.service.handler.CreatePaymentTransactionHandler;
import dev.sverdlov.paymentservice.service.handler.PaymentTransactionCommandHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class PaymentTransactionCommandConfig {
    @Bean
    public Map<PaymentTransactionCommand, PaymentTransactionCommandHandler> commandHandlers(
            CreatePaymentTransactionHandler createPaymentTransactionHandler,
            CancelPaymentTransactionHandler cancelPaymentTransactionHandler
    ) {
        Map<PaymentTransactionCommand, PaymentTransactionCommandHandler> commandHandlers = new HashMap<>();
        commandHandlers.put(PaymentTransactionCommand.CREATE, createPaymentTransactionHandler);
        commandHandlers.put(PaymentTransactionCommand.REFUND, cancelPaymentTransactionHandler);

        return commandHandlers;
    }
}
