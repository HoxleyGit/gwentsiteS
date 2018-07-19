package com.example.gwentsiteS.repositories;

import com.example.gwentsiteS.entries.comments.CardComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardCommentRepository extends JpaRepository<CardComment, Long> {
}
