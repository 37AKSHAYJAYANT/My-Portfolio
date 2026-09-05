package com.akshay.portfolio.controller;

import com.akshay.portfolio.dto.ApiResponse;
import com.akshay.portfolio.entity.Project;
import com.akshay.portfolio.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Project>>> getProjects(
            @RequestParam(required = false) String category) {
        List<Project> projects;
        if (category != null && !category.isBlank()) {
            projects = projectService.getProjectsByCategory(category);
        } else {
            projects = projectService.getAllPublishedProjects();
        }
        return ResponseEntity.ok(ApiResponse.success("Projects retrieved successfully", projects));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Project>> createProject(@RequestBody Project project) {
        Project saved = projectService.saveProject(project);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Project created successfully", saved));
    }
}
