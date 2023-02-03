package org.morssiber.bookkeeper.repository;

import org.morssiber.bookkeeper.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Optional<Article> findById(int id);
}
