package com.hiramoto.issuestracker.web.controller;

import com.hiramoto.issuestracker.utils.ApplicationUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.micrometer.core.instrument.util.StringUtils;

@Controller
public class StatusController {

    @Autowired
    private ApplicationUtils applicationUtils;

    @GetMapping("/status")
    public String status(Model model) {
        String version = applicationUtils.getVersion();
        String name = applicationUtils.getName();
        if (StringUtils.isBlank(version)) {
            version = "<unknownVersion>";
        }
        if (StringUtils.isBlank(name)) {
            name = "<unknownName>";
        }
        model.addAttribute("name", name);
        model.addAttribute("version", version);
        return "status";
    }
    
}
