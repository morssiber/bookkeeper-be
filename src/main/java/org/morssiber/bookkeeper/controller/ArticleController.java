package org.morssiber.bookkeeper.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.morssiber.bookkeeper.model.Article;
import org.morssiber.bookkeeper.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RestController(value = "Article Controller")
@RequestMapping("/api/rest/v1/articles")
public class ArticleController {
    private final ArticleService articleService;

    @Operation(summary = "Get articles",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            })
    @GetMapping("/")
    public ResponseEntity<List<Article>> getArticles() {
        return ResponseEntity.ok(articleService.getArticles());
    }

    @Operation(summary = "Get article by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            })
    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable int id) {
        return ResponseEntity.of(articleService.getArticle(id));
    }

    @Operation(summary = "Save new article",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "201", description = "Created"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            })
    @PutMapping("/save")
    public ResponseEntity<Article> saveArticle(@RequestBody Article article) {
        Article savedArticle = articleService.saveArticle(article);
        if (savedArticle == null) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(savedArticle);
    }

    @Operation(summary = "Update article details",
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            })
    @PatchMapping("/update")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        Article updatedArticle = articleService.updateArticle(article);
        if (updatedArticle == null) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(updatedArticle);
    }

    @Operation(summary = "Delete article",
            responses = {
                    @ApiResponse(responseCode = "204", description = "No Content"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            })
    @DeleteMapping("/delete")
    public ResponseEntity<List<Article>> getArticleSample(@RequestParam int id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}
