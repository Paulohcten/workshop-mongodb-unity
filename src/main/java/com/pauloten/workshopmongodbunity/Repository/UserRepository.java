package com.pauloten.workshopmongodbunity.Repository;

import com.pauloten.workshopmongodbunity.Domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
