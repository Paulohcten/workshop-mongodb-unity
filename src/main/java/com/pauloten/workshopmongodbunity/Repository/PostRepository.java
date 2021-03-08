package com.pauloten.workshopmongodbunity.Repository;

import com.pauloten.workshopmongodbunity.Domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
