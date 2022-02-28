package com.example.fetchreward.repository;

import com.example.fetchreward.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("SELECT u FROM Transaction u WHERE u.payer = :payer")
    List<Transaction> findByPayer(@Param("payer") String payer);

    @Query("SELECT u FROM Transaction u ORDER BY u.timestamp ASC")
    List<Transaction> getMostRecentPoints();

    @Transactional
    @Modifying
    @Query("UPDATE Transaction u SET u.points = :updatePoints WHERE u.id = :id")
    void updateTransactionsPoints(@Param("updatePoints") int updatedPoints,
                                  @Param("id") Long id);

    @Transactional
    @Modifying
    @Query("DELETE Transaction u WHERE u.id = :id")
    void removeTransaction(@Param("id") Long id);
}
