package com.demo.upimesh.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTop20ByOrderByIdDesc();
    boolean existsByPacketHash(String packetHash);

    /** Most recent settled payment — the target the "try to break it" attacks replay/tamper with. */
    Optional<Transaction> findFirstByStatusOrderByIdDesc(Transaction.Status status);
}
