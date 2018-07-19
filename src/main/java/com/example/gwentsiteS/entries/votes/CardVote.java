package com.example.gwentsiteS.entries.votes;

import com.example.gwentsiteS.entries.Card;
import com.example.gwentsiteS.entries.User;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
public class CardVote {
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
    @JoinColumn(name = "card_id")
    private Card card;
}
