package com.example.springboot_ms.site_service.repositories;

import com.example.springboot_ms.site_service.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
}
