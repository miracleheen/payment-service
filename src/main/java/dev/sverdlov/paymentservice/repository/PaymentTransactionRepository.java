package dev.sverdlov.paymentservice.repository;

import dev.sverdlov.paymentservice.model.entity.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long> {
}
