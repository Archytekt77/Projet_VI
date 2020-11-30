package com.loicmaria.repositories;

import com.loicmaria.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByClimbingSite_Id(int id);
}
