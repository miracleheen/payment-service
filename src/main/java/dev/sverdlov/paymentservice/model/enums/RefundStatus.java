package dev.sverdlov.paymentservice.model.enums;
import lombok.Getter;

@Getter
public enum RefundStatus {
    COMPLETED,
    SUCCESS,
    FAILED;

    public static RefundStatus fromString(String value) {
        for (var refundStatus : RefundStatus.values()) {
            if (refundStatus.name().equalsIgnoreCase(value)) {
                return refundStatus;
            }
        }
        throw new IllegalArgumentException("Invalid RefundStatus: " + value);
    }
}
