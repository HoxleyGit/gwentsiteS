package com.example.gwentsiteS.entries.comments;

import com.example.gwentsiteS.entries.Card;
import com.example.gwentsiteS.entries.User;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@RequiredArgsConstructor
public class CardComment {
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
    @JoinColumn(name = "card_id")
    private Card card;
}
