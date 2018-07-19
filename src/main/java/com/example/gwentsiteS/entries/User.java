package com.example.gwentsiteS.entries;

import com.example.gwentsiteS.entries.comments.CardComment;
import com.example.gwentsiteS.entries.comments.DeckComment;
import com.example.gwentsiteS.entries.votes.CardVote;
import com.example.gwentsiteS.entries.votes.DeckVote;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String password;

    @NonNull
    private String email;

    @NonNull
    private String avatarLocation;

    @NonNull
    private Boolean isActive;

    @OneToMany(mappedBy = "user")
    private List<Deck> decks;

    @OneToMany(mappedBy = "user")
    private List<DeckComment> deckComments;

    @OneToMany(mappedBy = "user")
    private List<CardComment> cardComments;

    @OneToMany(mappedBy = "user")
    private List<CardVote> cardVotes;

    @OneToMany(mappedBy = "user")
    private List<DeckVote> deckVotes;
}
