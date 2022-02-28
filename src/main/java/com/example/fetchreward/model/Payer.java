package com.example.fetchreward.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"id"})
public class Payer {

    private @Id
    @GeneratedValue
    Long id;
    private String payer;
    private int points;

    public Payer(String payer, int points) {
        this.payer = payer;
        this.points = points;
    }
}
