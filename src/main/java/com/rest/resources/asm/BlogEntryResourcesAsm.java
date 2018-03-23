package com.rest.resources.asm;

import com.mvc.BlogEntryController;
import com.rest.core.entities.BlogEntry;
import com.rest.resources.BlogEntryResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
/**
 * Created by ANTON on 22.03.2018.
 */
public class BlogEntryResourcesAsm extends ResourceAssemblerSupport<BlogEntry, BlogEntryResource> {
    public BlogEntryResourcesAsm() {
        super(BlogEntryController.class,BlogEntryResource.class);
    }

    @Override
    public BlogEntryResource toResource(BlogEntry blogEntry) {
        BlogEntryResource res = new BlogEntryResource();
        res.setTitle(blogEntry.getTitle());
        Link link = linkTo(methodOn(BlogEntryController.class).getBlogEntry(blogEntry.getId())).withSelfRel();
        res.add(link.withSelfRel());
        return res;

    }
}
