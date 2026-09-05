package dev.sverdlov.paymentservice.service.handler;

import dev.sverdlov.paymentservice.model.dto.CreatePaymentTransactionRequest;
import dev.sverdlov.paymentservice.service.BankAccountService;
import dev.sverdlov.paymentservice.service.PaymentTransactionValidator;
import dev.sverdlov.paymentservice.util.JsonConverter;
import jdk.security.jarsigner.JarSigner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CreatePaymentTransactionHandler implements PaymentTransactionCommandHandler {
    private final PaymentTransactionValidator paymentTransactionValidator;
    private final BankAccountService bankAccountService;

    @Transactional
    @Override
    public void process(String requestId, String message) {
        var request = JsonConverter.toObject(message, CreatePaymentTransactionRequest.class);
        paymentTransactionValidator.validateCreatePaymentTransactionRequest(request);

        var sourceBankAccount = bankAccountService.findById(request.getSourceBankAccountId()).get();// валидатор должен проверить на null
        sourceBankAccount.setBalance(
                sourceBankAccount.getBalance().subtract(request.getAmount())
        );


        if (request.getDestinationBankAccountId() != null) {
            var destinationBankAccount = bankAccountService.findById(request.getDestinationBankAccountId()).get();
            destinationBankAccount.setBalance(
                    destinationBankAccount.getBalance().add(request.getAmount())
            );
        }
    }
}
