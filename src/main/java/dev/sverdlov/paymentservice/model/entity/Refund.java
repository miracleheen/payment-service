package dev.sverdlov.paymentservice.model.entity;

import dev.sverdlov.paymentservice.model.enums.PaymentTransactionStatus;
import dev.sverdlov.paymentservice.model.enums.RefundStatus;
import dev.sverdlov.paymentservice.model.enums.converter.RefundStatusConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Refund extends BaseEntity {
    private BigDecimal refundedAmount;

    private String reason;

    @Convert(converter = RefundStatusConverter.class)
    private RefundStatus status;

    @ManyToOne()
    @JoinColumn(name = "paymentTransactionId", referencedColumnName = "id")
    private PaymentTransactionStatus paymentTransaction;
}
