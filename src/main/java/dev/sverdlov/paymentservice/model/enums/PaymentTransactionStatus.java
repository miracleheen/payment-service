package dev.sverdlov.paymentservice.model.enums;

import lombok.Getter;

@Getter
public enum PaymentTransactionStatus {
    PROCESSING,
    SUCCESS,
    FAILED;

    public static PaymentTransactionStatus fromString(String value) {
        for (var paymentTransactionStatus : PaymentTransactionStatus.values()) {
            if (paymentTransactionStatus.name().equalsIgnoreCase(value)) {
                return paymentTransactionStatus;
            }
        }
        throw new IllegalArgumentException("Invalid PaymentTransactionStatus value: " + value);
    }
}
