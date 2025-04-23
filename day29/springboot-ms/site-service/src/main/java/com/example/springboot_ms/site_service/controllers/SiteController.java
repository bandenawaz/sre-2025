package com.example.springboot_ms.site_service.controllers;

import com.example.springboot_ms.site_service.model.Site;
import com.example.springboot_ms.site_service.repositories.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/sites")
public class SiteController {

    private SiteRepository siteRepository;

    @Autowired
    public SiteController(SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    //get all sites
    @RequestMapping
    public List<Site> getAllSites(){
        return siteRepository.findAll();
    }

    //add a site
    @PostMapping
    public Site addSite(@RequestBody Site site){
        return siteRepository.save(site);
    }
}
