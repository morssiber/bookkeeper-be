package org.morssiber.bookkeeper.service;

import lombok.AllArgsConstructor;
import org.morssiber.bookkeeper.model.Article;
import org.morssiber.bookkeeper.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArticleService {

    private ArticleRepository articleRepository;

    public List<Article> getArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticle(int id) {
        return articleRepository.findById(id);
    }

    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Article article) {
        Optional<Article> oArticle = articleRepository.findById(article.getId());
        // TODO update - get & save or create
        return articleRepository.save(article);
    }

    public void deleteArticle(int id) {
        Optional<Article> oArticle = articleRepository.findById(id);
        oArticle.ifPresent(article -> articleRepository.delete(article));
    }
}
