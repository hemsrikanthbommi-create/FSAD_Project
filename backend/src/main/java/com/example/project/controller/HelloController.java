package com.example.project.controller;

import com.example.project.model.Article;
import com.example.project.model.User;
import com.example.project.model.Video;
import com.example.project.service.ContentService;
import com.example.project.service.UserService;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    private final UserService userService;
    private final ContentService contentService;

    public HelloController(UserService userService, ContentService contentService) {
        this.userService = userService;
        this.contentService = contentService;
    }

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", "Hello from Spring Boot backend!");
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/users")
    public User createUser(@RequestBody Map<String, String> payload) {
        String name = payload.getOrDefault("name", "Unknown");
        String email = payload.getOrDefault("email", "unknown@example.com");
        return userService.createUser(name, email);
    }

    @GetMapping("/articles")
    public List<Article> getArticles() {
        return contentService.getAllArticles();
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable Long id) {
        return contentService.getArticleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/articles")
    public Article createArticle(@RequestBody Article article) {
        return contentService.createArticle(article);
    }

    @GetMapping("/videos")
    public List<Video> getVideos() {
        return contentService.getAllVideos();
    }

    @GetMapping("/videos/{id}")
    public ResponseEntity<Video> getVideo(@PathVariable Long id) {
        return contentService.getVideoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/videos")
    public Video createVideo(@RequestBody Video video) {
        return contentService.createVideo(video);
    }

    @GetMapping("/echo")
    public Map<String, String> echo(@RequestParam(required = false) String message) {
        return userService.echo(message);
    }
}
