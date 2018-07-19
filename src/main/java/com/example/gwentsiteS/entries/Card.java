package com.example.gwentsiteS.entries;

import com.example.gwentsiteS.entries.comments.CardComment;
import com.example.gwentsiteS.entries.votes.CardVote;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Card {
    public static final int CRAFTING_COMMON_COST_IN_SCRAPS = 30;
    public static final int CRAFTING_COMMON_PREMIUM_COST_IN_SCRAPS = 200;
    public static final int CRAFTING_RARE_COST_IN_SCRAPS = 80;
    public static final int CRAFTING_RARE_PREMIUM_COST_IN_SCRAPS = 400;
    public static final int CRAFTING_EPIC_COST_IN_SCRAPS = 200;
    public static final int CRAFTING_EPIC_PREMIUM_COST_IN_SCRAPS = 800;
    public static final int CRAFTING_LEGENDARY_COST_IN_SCRAPS = 800;
    public static final int CRAFTING_LEGENDARY_PREMIUM_COST_IN_SCRAPS = 1600;

    public static final int MILLING_COMMON_OUTCOME_IN_SCRAPS = 30;
    public static final int MILLING_COMMON_PREMIUM_OUTCOME_IN_SCRAPS = 5;
    public static final int MILLING_COMMON_PREMIUM_OUTCOME_IN_METEORITE_POWDER = 20;
    public static final int MILLING_RARE_OUTCOME_IN_SCRAPS = 20;
    public static final int MILLING_RARE_PREMIUM_OUTCOME_IN_SCRAPS = 10;
    public static final int MILLING_RARE_PREMIUM_OUTCOME_IN_METEORITE_POWDER = 50;
    public static final int MILLING_EPIC_OUTCOME_IN_SCRAPS = 50;
    public static final int MILLING_EPIC_PREMIUM_OUTCOME_IN_SCRAPS = 50;
    public static final int MILLING_EPIC_PREMIUM_OUTCOME_IN_METEORITE_POWDER = 80;
    public static final int MILLING_LEGENDARY_OUTCOME_IN_SCRAPS = 200;
    public static final int MILLING_LEGENDARY_PREMIUM_OUTCOME_IN_SCRAPS = 200;
    public static final int MILLING_LEGENDARY_PREMIUM_OUTCOME_IN_METEORITE_POWDER = 120;
    public static final int MILLING_ANY_NON_PREMIUM_OUTCOME_IN_METEORITE_POWDER = 0;

    public static final int TRANSMUTE_TO_COMMON_PREMIUM_COST_IN_METEORITE_POWDER = 100;
    public static final int TRANSMUTE_TO_RARE_PREMIUM_COST_IN_METEORITE_POWDER = 200;
    public static final int TRANSMUTE_TO_EPIC_PREMIUM_COST_IN_METEORITE_POWDER = 300;
    public static final int TRANSMUTE_TO_LEGENDARY_PREMIUM_COST_IN_METEORITE_POWDER = 400;
    public static final int CANNOT_TRANSMUTE_ANY_PREMIUM_CARD_TO_PREMIUM_CARD = -1;

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    @NonNull
    @Enumerated
    private Category category;

    @NonNull
    private Boolean isPremium;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "faction_id")
    private Faction faction;

    @NonNull
    private Integer power;

    @NonNull
    @Enumerated
    private Rarity rarity;

    @NonNull
    @Enumerated
    private Row row;

    @NonNull
    private String description;

    @NonNull
    private String flavourText;

    @NonNull
    private String imageLocation;

    @NonNull
    @ManyToMany(mappedBy = "cards")
    private Set<Type> types;

    @NonNull
    private Boolean isSpy;

    @NonNull
    private int craftingNonPremiumCostInScraps;
    @NonNull
    private int millingOutcomeInScraps;
    @NonNull
    private int millingOutcomeInMeteoritePowder;
    @NonNull
    private int transmuteCostInMeteoritePowder;

    @ManyToMany(mappedBy = "cards")
    private List<Deck> decks;

    @OneToMany(mappedBy = "card")
    private List<CardComment> cardComments;

    @OneToMany(mappedBy = "card")
    private List<CardVote> cardVotes;

    public Card() {
    }

    @java.beans.ConstructorProperties({"name", "category", "isPremium", "faction", "power", "rarity", "row", "description", "flavourText", "imageLocation", "types", "isSpy"})
    public Card(String name, Category category, Boolean isPremium, Faction faction, Integer power, Rarity rarity, Row row, String description, String flavourText, String imageLocation, Set<Type> types, Boolean isSpy) {
        this.name = name;
        this.category = category;
        this.isPremium = isPremium;
        this.faction = faction;
        this.power = power;
        this.rarity = rarity;
        this.row = row;
        this.description = description;
        this.flavourText = flavourText;
        this.imageLocation = imageLocation;
        this.types = types;
        this.isSpy = isSpy;
        switch(rarity){
            case LEGENDARY: {
                if(isPremium) {
                    craftingNonPremiumCostInScraps = CRAFTING_LEGENDARY_PREMIUM_COST_IN_SCRAPS;
                    millingOutcomeInScraps = MILLING_LEGENDARY_PREMIUM_OUTCOME_IN_SCRAPS;
                    millingOutcomeInMeteoritePowder = MILLING_LEGENDARY_PREMIUM_OUTCOME_IN_METEORITE_POWDER;
                    transmuteCostInMeteoritePowder = CANNOT_TRANSMUTE_ANY_PREMIUM_CARD_TO_PREMIUM_CARD;
                } else {
                    craftingNonPremiumCostInScraps = CRAFTING_LEGENDARY_COST_IN_SCRAPS;
                    millingOutcomeInScraps = MILLING_LEGENDARY_OUTCOME_IN_SCRAPS;
                    millingOutcomeInMeteoritePowder = MILLING_LEGENDARY_PREMIUM_OUTCOME_IN_METEORITE_POWDER;
                    transmuteCostInMeteoritePowder = TRANSMUTE_TO_LEGENDARY_PREMIUM_COST_IN_METEORITE_POWDER;
                }
            }
            break;
            case EPIC: {
                if(isPremium){
                    craftingNonPremiumCostInScraps = CRAFTING_EPIC_PREMIUM_COST_IN_SCRAPS;
                    millingOutcomeInScraps = MILLING_EPIC_PREMIUM_OUTCOME_IN_SCRAPS;
                    millingOutcomeInMeteoritePowder = MILLING_EPIC_PREMIUM_OUTCOME_IN_METEORITE_POWDER;
                    transmuteCostInMeteoritePowder = CANNOT_TRANSMUTE_ANY_PREMIUM_CARD_TO_PREMIUM_CARD;
                } else {
                    craftingNonPremiumCostInScraps = CRAFTING_EPIC_COST_IN_SCRAPS;
                    millingOutcomeInScraps = MILLING_EPIC_OUTCOME_IN_SCRAPS;
                    millingOutcomeInMeteoritePowder = MILLING_EPIC_PREMIUM_OUTCOME_IN_METEORITE_POWDER;
                    transmuteCostInMeteoritePowder = TRANSMUTE_TO_EPIC_PREMIUM_COST_IN_METEORITE_POWDER;
                }
            }
            break;
            case RARE: {
                if(isPremium){
                    craftingNonPremiumCostInScraps = CRAFTING_RARE_PREMIUM_COST_IN_SCRAPS;
                    millingOutcomeInScraps = MILLING_RARE_PREMIUM_OUTCOME_IN_SCRAPS;
                    millingOutcomeInMeteoritePowder = MILLING_RARE_PREMIUM_OUTCOME_IN_METEORITE_POWDER;
                    transmuteCostInMeteoritePowder = CANNOT_TRANSMUTE_ANY_PREMIUM_CARD_TO_PREMIUM_CARD;
                } else {
                    craftingNonPremiumCostInScraps = CRAFTING_RARE_COST_IN_SCRAPS;
                    millingOutcomeInScraps = MILLING_RARE_OUTCOME_IN_SCRAPS;
                    millingOutcomeInMeteoritePowder = MILLING_RARE_PREMIUM_OUTCOME_IN_METEORITE_POWDER;
                    transmuteCostInMeteoritePowder = TRANSMUTE_TO_RARE_PREMIUM_COST_IN_METEORITE_POWDER;
                }
            }
            break;
            case COMMON: {
                if(isPremium){
                    craftingNonPremiumCostInScraps = CRAFTING_COMMON_PREMIUM_COST_IN_SCRAPS;
                    millingOutcomeInScraps = MILLING_COMMON_PREMIUM_OUTCOME_IN_SCRAPS;
                    millingOutcomeInMeteoritePowder = MILLING_COMMON_PREMIUM_OUTCOME_IN_METEORITE_POWDER;
                    transmuteCostInMeteoritePowder = CANNOT_TRANSMUTE_ANY_PREMIUM_CARD_TO_PREMIUM_CARD;
                } else {
                    craftingNonPremiumCostInScraps = CRAFTING_COMMON_COST_IN_SCRAPS;
                    millingOutcomeInScraps = MILLING_COMMON_OUTCOME_IN_SCRAPS;
                    millingOutcomeInMeteoritePowder = MILLING_COMMON_PREMIUM_OUTCOME_IN_METEORITE_POWDER;
                    transmuteCostInMeteoritePowder = TRANSMUTE_TO_COMMON_PREMIUM_COST_IN_METEORITE_POWDER;
                }
            }
            break;
        }
    }


    public enum Category {
        LEADER,
        GOLD,
        SILVER,
        BRONZE
    }

    public enum Rarity {
        LEGENDARY,
        EPIC,
        RARE,
        COMMON
    }

    public enum Row {
        MELEE,
        RANGE,
        SIEGE,
        AGILE,
        SPECIAL
    }
}
