package com.pauloten.workshopmongodbunity.Services;

import com.pauloten.workshopmongodbunity.Domain.Post;
import com.pauloten.workshopmongodbunity.Repository.PostRepository;
import com.pauloten.workshopmongodbunity.Services.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repos;

    public Post findById(String id) {
        Optional<Post> obj = repos.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text){
        return repos.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime()+24*60*60*1000);
        return repos.fullSearch(text, minDate, maxDate);
    }
}
