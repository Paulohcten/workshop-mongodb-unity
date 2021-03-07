package com.pauloten.workshopmongodbunity.Services;

import com.pauloten.workshopmongodbunity.Domain.User;
import com.pauloten.workshopmongodbunity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repos;

    public List<User> findAll(){
        return repos.findAll();
    }
}
