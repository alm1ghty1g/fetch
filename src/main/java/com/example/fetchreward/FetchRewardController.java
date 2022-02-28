package com.example.fetchreward;

import com.example.fetchreward.model.Payer;
import com.example.fetchreward.model.Points;
import com.example.fetchreward.model.Transaction;
import com.example.fetchreward.service.RewardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FetchRewardController {

    @Autowired
    private RewardService fetchRewardsService;

    @GetMapping("/payer/balances")
    List<Payer> allPayerBalances() {
        return fetchRewardsService.getAllPayerBalances();
    }

    @PostMapping(path = "/payer/transaction", consumes = "application/json", produces = "application/json")
    Transaction addPoints(@RequestBody Transaction newTransaction) {
        return fetchRewardsService.addPoints(newTransaction);
    }

    @PostMapping(path = "/consumer/points", consumes = "application/json", produces = "application/json")
    List<Payer> spendPoints(@RequestBody Points points) {
        return fetchRewardsService.spendPoints(points);
    }
}
