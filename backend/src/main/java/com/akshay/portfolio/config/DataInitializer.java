package com.akshay.portfolio.config;

import com.akshay.portfolio.entity.Project;
import com.akshay.portfolio.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initProjects(ProjectRepository projectRepository) {
        return args -> {
            if (projectRepository.count() == 0) {
                // 1. E-Commerce Front-End
                Project p1 = new Project(
                        "E-Commerce Website Front-End",
                        "Responsive UI & cart interactions",
                        "SOFTWARE_ENGINEERING",
                        "High-performance e-commerce storefront with modular CSS architecture, responsive product grids, and accessible cart workflows.",
                        "https://github.com/37AKSHAYJAYANT",
                        "#",
                        "Assets/ecommerce-project.svg",
                        "dark",
                        1,
                        Arrays.asList("HTML5", "Modular CSS", "JavaScript", "Responsive Design")
                );

                // 2. Full-Stack CRUD Application
                Project p2 = new Project(
                        "Full-Stack CRUD Application",
                        "Spring Boot + React architecture",
                        "SOFTWARE_ENGINEERING",
                        "Enterprise-grade web application featuring Core Java / Spring Boot REST APIs, relational PostgreSQL persistence, and dynamic client-side rendering.",
                        "https://github.com/37AKSHAYJAYANT",
                        "#",
                        "Assets/fullstack-crud.svg",
                        "dark",
                        2,
                        Arrays.asList("Java", "Spring Boot", "React", "PostgreSQL", "REST API")
                );

                // 3. VLAN and Inter-VLAN Routing
                Project p3 = new Project(
                        "VLAN & Inter-VLAN Routing",
                        "Subnetting & switch fabric design",
                        "NETWORK_ENGINEERING",
                        "Enterprise multi-layer switching topology with segmented VLANs, 802.1Q trunking, and high-availability router-on-a-stick / SVI routing.",
                        "https://github.com/37AKSHAYJAYANT",
                        "#",
                        "Assets/vlan-network.svg",
                        "dark",
                        3,
                        Arrays.asList("Cisco IOS", "VLAN / 802.1Q", "Subnetting", "Packet Tracer")
                );

                // 4. BSNL BharatNet Telecom Infrastructure
                Project p4 = new Project(
                        "BSNL BharatNet Telecom Infrastructure",
                        "200+ network nodes & smart-racks",
                        "NETWORK_ENGINEERING",
                        "Production field engineering managing mission-critical optical backhaul, smart-rack telemetry, Linux remote troubleshooting, and high-uptime telecom nodes.",
                        "https://github.com/37AKSHAYJAYANT",
                        "#",
                        "Assets/bharatnet-telecom.svg",
                        "dark",
                        4,
                        Arrays.asList("Linux", "Optical Telecom", "Network Operations", "Production Debugging")
                );

                projectRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
                System.out.println("✅ Database initialized with 4 default portfolio projects.");
            }
        };
    }
}
