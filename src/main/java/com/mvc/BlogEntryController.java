package com.mvc;

import com.core.services.BlogEntryService;
import com.rest.core.entities.BlogEntry;
import com.rest.resources.BlogEntryResource;
import com.rest.resources.asm.BlogEntryResourcesAsm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogEntryController {
    private BlogEntryService service;

    public BlogEntryController(BlogEntryService service) {
        this.service = service;
    }

    @RequestMapping(value = "/rest/blog-entries/{blogEntryId}", method = RequestMethod.GET)
    public ResponseEntity<BlogEntryResource> getBlogEntry(@PathVariable Long blogEntryId) {

        BlogEntry entry = service.find(blogEntryId);
        BlogEntryResource res = new BlogEntryResourcesAsm().toResource(entry);
        return new ResponseEntity<BlogEntryResource>(res, HttpStatus.OK);
    }
}
