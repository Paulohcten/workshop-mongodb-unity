package com.pauloten.workshopmongodbunity.Resources;

import com.pauloten.workshopmongodbunity.Domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/Users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User jack = new User("1","Jack Black","jack@gmail.com");
        User walter = new User("2","Walter White","walter@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(jack,walter));
        return ResponseEntity.ok().body(list);
    }
}
