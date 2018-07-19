package com.example.gwentsiteS.entries.comments;

import com.example.gwentsiteS.entries.Deck;
import com.example.gwentsiteS.entries.User;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
public class DeckComment{
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String date;

    @NonNull
    private String text;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "deck_id")
    private Deck deck;
}
