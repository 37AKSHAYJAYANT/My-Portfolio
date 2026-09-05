package com.akshay.portfolio.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(length = 200)
    private String subtitle;

    @Column(nullable = false, length = 50)
    private String category; // "SOFTWARE_ENGINEERING" or "NETWORK_ENGINEERING"

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "repo_url")
    private String repoUrl;

    @Column(name = "live_url")
    private String liveUrl;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "card_tone", length = 20)
    private String cardTone = "dark";

    @Column(name = "display_order")
    private Integer displayOrder = 0;

    @ElementCollection
    @CollectionTable(name = "project_tags", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "tag")
    private List<String> tags = new ArrayList<>();

    @Column(name = "is_published")
    private Boolean isPublished = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Project() {}

    public Project(String title, String subtitle, String category, String description,
                   String repoUrl, String liveUrl, String imageUrl, String cardTone,
                   Integer displayOrder, List<String> tags) {
        this.title = title;
        this.subtitle = subtitle;
        this.category = category;
        this.description = description;
        this.repoUrl = repoUrl;
        this.liveUrl = liveUrl;
        this.imageUrl = imageUrl;
        this.cardTone = cardTone;
        this.displayOrder = displayOrder;
        this.tags = tags != null ? tags : new ArrayList<>();
        this.isPublished = true;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getSubtitle() { return subtitle; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getRepoUrl() { return repoUrl; }
    public void setRepoUrl(String repoUrl) { this.repoUrl = repoUrl; }

    public String getLiveUrl() { return liveUrl; }
    public void setLiveUrl(String liveUrl) { this.liveUrl = liveUrl; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getCardTone() { return cardTone; }
    public void setCardTone(String cardTone) { this.cardTone = cardTone; }

    public Integer getDisplayOrder() { return displayOrder; }
    public void setDisplayOrder(Integer displayOrder) { this.displayOrder = displayOrder; }

    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public Boolean getIsPublished() { return isPublished; }
    public void setIsPublished(Boolean isPublished) { this.isPublished = isPublished; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
