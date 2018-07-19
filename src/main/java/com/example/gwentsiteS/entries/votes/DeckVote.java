package com.example.gwentsiteS.entries.votes;

import com.example.gwentsiteS.entries.Deck;
import com.example.gwentsiteS.entries.User;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
public class DeckVote {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private Boolean isPositive;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "deck_id")
    private Deck deck;
}
