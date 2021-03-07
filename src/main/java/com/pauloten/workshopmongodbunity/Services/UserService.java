package com.pauloten.workshopmongodbunity.Services;

import com.pauloten.workshopmongodbunity.DTO.UserDTO;
import com.pauloten.workshopmongodbunity.Domain.User;
import com.pauloten.workshopmongodbunity.Repository.UserRepository;
import com.pauloten.workshopmongodbunity.Services.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repos;

    public List<User> findAll(){
        return repos.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repos.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User obj){
        return repos.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
