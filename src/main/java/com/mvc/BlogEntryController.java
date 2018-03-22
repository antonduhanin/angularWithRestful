package com.mvc;

import com.entities.BlogEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlogEntryController {
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public @ResponseBody
    BlogEntry test(@RequestBody BlogEntry entry) {
        return entry;
    }
}
