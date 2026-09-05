package dev.sverdlov.paymentservice.model.dto.enums;

import lombok.Getter;

@Getter
public enum CommandResultStatus {
    SUCCESS,
    FAILED;


    public static CommandResultStatus fromString(String value) {
        for (var commandResultStatus : CommandResultStatus.values()) {
            if (commandResultStatus.name().equalsIgnoreCase(value)) {
                return commandResultStatus;
            }
        }
        throw new IllegalArgumentException("Invalid RefundStatus: " + value);
    }
}
