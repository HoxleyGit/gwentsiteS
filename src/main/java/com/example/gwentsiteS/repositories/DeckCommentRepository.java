package com.example.gwentsiteS.repositories;

import com.example.gwentsiteS.entries.comments.DeckComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeckCommentRepository extends JpaRepository<DeckComment, Long> {
}
