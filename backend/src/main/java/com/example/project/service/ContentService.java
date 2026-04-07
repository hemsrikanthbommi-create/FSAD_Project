package com.example.project.service;

import com.example.project.model.Article;
import com.example.project.model.Video;
import com.example.project.repository.ArticleRepository;
import com.example.project.repository.VideoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ContentService {

    private final ArticleRepository articleRepository;
    private final VideoRepository videoRepository;

    public ContentService(ArticleRepository articleRepository, VideoRepository videoRepository) {
        this.articleRepository = articleRepository;
        this.videoRepository = videoRepository;
    }

    @PostConstruct
    public void initContent() {
        if (articleRepository.count() == 0) {
            articleRepository.save(new Article("Spring Boot Integration", "Learn how to connect React with Spring Boot.", "Admin", LocalDateTime.now()));
            articleRepository.save(new Article("Working with H2 Database", "This article shows how to use an in-memory database for development.", "Admin", LocalDateTime.now()));
        }
        if (videoRepository.count() == 0) {
            videoRepository.save(new Video("React + Spring Boot Tutorial", "A quick start video for full-stack development.", "https://example.com/video1", 420, LocalDateTime.now()));
            videoRepository.save(new Video("H2 Database Explained", "Intro to using H2 with Spring Boot.", "https://example.com/video2", 360, LocalDateTime.now()));
        }
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(Long id) {
        return articleRepository.findById(id);
    }

    public Article createArticle(Article article) {
        article.setPublishedAt(LocalDateTime.now());
        return articleRepository.save(article);
    }

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);
    }

    public Video createVideo(Video video) {
        video.setPublishedAt(LocalDateTime.now());
        return videoRepository.save(video);
    }
}
