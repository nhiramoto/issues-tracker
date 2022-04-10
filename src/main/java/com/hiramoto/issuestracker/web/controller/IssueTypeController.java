package com.hiramoto.issuestracker.web.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/types", produces = MediaType.APPLICATION_JSON_VALUE)
public class IssueTypeController extends ApiController {
    
}
