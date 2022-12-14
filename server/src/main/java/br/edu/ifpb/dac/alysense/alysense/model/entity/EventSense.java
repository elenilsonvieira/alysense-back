package br.edu.ifpb.dac.alysense.alysense.model.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class EventSense {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateEvent;
    private String local;
    private Integer peopleLimit;
    private Integer numberSample;
    private Integer minimunAge; 

    @Enumerated(EnumType.STRING)
    private TypeScale typeScale;
    
    @OneToMany
    @JoinColumn(name = "avaliation_id")
    private List<Avaliation> avaliations;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = false)
    private List<Product> items;

    private String admUser;

}
