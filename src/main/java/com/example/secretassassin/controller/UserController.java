package com.example.secretassassin.controller;

import com.example.secretassassin.model.User;
import com.example.secretassassin.repository.UserRepository;
import io.fusionauth.jwt.Signer;
import io.fusionauth.jwt.domain.JWT;
import io.fusionauth.jwt.hmac.HMACSigner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    public UserRepository userRepository;

    @GetMapping(value = "/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping(value = "/create")
    public String createUser(@RequestBody User user) {
        User newUser = userRepository.insert(user);


        return "User Created " + newUser.getUsername();
    }


    @PostMapping(value = "/getUser")
    @CrossOrigin
    public User getUserInformation(@RequestBody User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());

        return foundUser;
    }


    /**
     * Check if user password correct
     * @param user
     * @return jwt token if user is authenticated.
     */
    @PostMapping(value = "/login")
    @CrossOrigin
    public Map<String, String> loginUser(@RequestBody User user) {

        //TODO internal server error when there is no user matching from database

        User foundUser = userRepository.findByUsername(user.getUsername());
        Map<String,String> map = new HashMap<>();

        if (foundUser.getPassword().equals(user.getPassword())) {

            Signer signer = HMACSigner.newSHA256Signer("too many secrets");

            JWT jwt = new JWT().setIssuer("www.acme.com")
                    .setIssuedAt(ZonedDateTime.now(ZoneOffset.UTC))
                    .setSubject("f1e33ab3-027f-47c5-bb07-8dd8ab37a2d3")
                    .setExpiration(ZonedDateTime.now(ZoneOffset.UTC).plusMinutes(60));

            String encodedJWT = JWT.getEncoder().encode(jwt, signer);

            map.put("token", encodedJWT);
            map.put("username", foundUser.getUsername());

            return map;
        }else {
            map.put("token", "Wrong password");

            return map;
        }
    }

}