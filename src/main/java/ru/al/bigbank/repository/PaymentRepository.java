package ru.al.bigbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.al.bigbank.model.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
