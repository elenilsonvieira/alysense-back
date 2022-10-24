package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Avaliation{

    public enum answerAvaliation {
        VERYGOOD,
        GOOD,
        NEITHERLIKEORDISLIKE,
        BAD,
        VERYBAD
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private answerAvaliation answer;
    
    private String titleEvent;

    private User evaluator;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    private List<EvalueteItem> evalueteItems;
    
    
}