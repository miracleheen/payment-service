package dev.sverdlov.paymentservice.service;

import dev.sverdlov.paymentservice.model.dto.CreatePaymentTransactionRequest;
import dev.sverdlov.paymentservice.model.entity.PaymentTransaction;
import dev.sverdlov.paymentservice.repository.PaymentTransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentTransactionService {
    private final PaymentTransactionRepository paymentTransactionRepository;

    public PaymentTransaction save(CreatePaymentTransactionRequest createPaymentTransactionRequest) {
        //TODO: реализовать MapStruct
    }
}
