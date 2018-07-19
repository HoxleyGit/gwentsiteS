package com.example.gwentsiteS.entries;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Faction {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String description;

    @OneToMany(mappedBy = "faction")
    private Set<Card> cards;
}
