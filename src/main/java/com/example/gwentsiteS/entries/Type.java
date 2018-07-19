package com.example.gwentsiteS.entries;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Type {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @ManyToMany
    @JoinTable(
            name = "Type_Card",
            joinColumns = {@JoinColumn(name = "type_id")},
            inverseJoinColumns = {@JoinColumn(name="card_id")}
    )
    private Set<Card> cards;
}
