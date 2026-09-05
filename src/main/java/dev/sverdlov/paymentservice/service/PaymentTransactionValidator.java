package dev.sverdlov.paymentservice.service;

import dev.sverdlov.paymentservice.exceptions.PaymentTransactionValidationException;
import dev.sverdlov.paymentservice.model.dto.CreatePaymentTransactionRequest;
import dev.sverdlov.paymentservice.model.entity.BankAccount;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentTransactionValidator {
    private final Validator validator;
    private final BankAccountService bankAccountService;

    public void validateCreatePaymentTransactionRequest(
            CreatePaymentTransactionRequest request
    ) {
        var violations = validator.validate(request);

        List<String> errors = new ArrayList<>(violations.stream()
                .map(ConstraintViolation::getMessage)
                .toList()
        );

        Optional<BankAccount> sourceBank = Optional.empty();

        if (request.getSourceBankAccountId() != null) {
            sourceBank = bankAccountService.findById(request.getSourceBankAccountId());

            if (sourceBank.isEmpty()) {
                errors.add("Source bank account not found, source account id: " + request.getSourceBankAccountId());
            }
        }

        if (request.getDestinationBankAccountId() != null) {
            var destinationBank = bankAccountService.findById(request.getDestinationBankAccountId());

            if (destinationBank.isEmpty()) {
                errors.add("Destination bank account not found,  destination account id: " + request.getDestinationBankAccountId());
            }
        }

        if (request.getAmount() != null && sourceBank.isPresent()) {
            if (sourceBank.get().getBalance().compareTo(request.getAmount()) < 0) {
                errors.add("Source bank account balance is less then requested amount, source account id: " + request.getSourceBankAccountId());
            }
        }

        if (!errors.isEmpty()) {
            throw new PaymentTransactionValidationException(errors);
        }
    }
}
