package com.danilojakob.warehousemanagement.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/resources")
@RequiredArgsConstructor
public class ResourceController {

    private Logger LOGGER = LoggerFactory.getLogger(ResourceController.class);

    //@PreAuthorize("hasAnyRole('USER', 'ADMINISTRATOR')")
    @GetMapping(value = "/file")
    public String getResourceByFileName(@RequestParam("filename") String filename, Principal principal) {
        LOGGER.info("User: {} requested File: {}", principal.getName(), filename);
        return "Your requested Source is: " + filename;
    }
}
