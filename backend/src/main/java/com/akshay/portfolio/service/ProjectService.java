package com.akshay.portfolio.service;

import com.akshay.portfolio.entity.Project;
import com.akshay.portfolio.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllPublishedProjects() {
        return projectRepository.findByIsPublishedTrueOrderByDisplayOrderAsc();
    }

    public List<Project> getProjectsByCategory(String category) {
        return projectRepository.findByCategoryAndIsPublishedTrueOrderByDisplayOrderAsc(category.toUpperCase());
    }

    @Transactional
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }
}
