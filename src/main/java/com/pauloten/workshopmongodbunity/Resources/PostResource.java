package com.pauloten.workshopmongodbunity.Resources;

import com.pauloten.workshopmongodbunity.Domain.Post;
import com.pauloten.workshopmongodbunity.Resources.util.URL;
import com.pauloten.workshopmongodbunity.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/Posts")
public class PostResource {

    @Autowired
    private PostService service;


    @RequestMapping(value = "/{id}/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text",defaultValue = "") String text){
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/{id}/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text",defaultValue = "") String text,
            @RequestParam(value = "minDate",defaultValue = "") String minDate,
            @RequestParam(value = "maxDate",defaultValue = "") String maxDate) {
        text = URL.decodeParameter(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<Post> list = service.fullSearch(text,min,max);
        return ResponseEntity.ok().body(list);
    }
}
