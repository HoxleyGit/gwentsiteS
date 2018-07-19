package com.example.gwentsiteS.entries;

import com.example.gwentsiteS.entries.comments.DeckComment;
import com.example.gwentsiteS.entries.votes.DeckVote;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Deck {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @ManyToMany
    @JoinTable(
            name = "Deck_Card",
            joinColumns = {@JoinColumn(name = "deck_id")},
            inverseJoinColumns = {@JoinColumn(name="card_id")}
    )
    private List<Card> cards;

    @OneToMany(mappedBy = "deck")
    private List<DeckComment> deckComments;

    @OneToMany(mappedBy = "deck")
    private List<DeckVote> deckVotes;

    @NonNull
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
