package com.example.fetchreward.service;

import com.example.fetchreward.model.Payer;
import com.example.fetchreward.model.Points;
import com.example.fetchreward.model.Transaction;

import java.util.List;

public interface RewardService {

    List<Payer> spendPoints(Points points);

    Transaction addPoints(Transaction newTransaction);

    List<Transaction> getAllTransactions();

    List<Payer> getAllPayerBalances();
}
