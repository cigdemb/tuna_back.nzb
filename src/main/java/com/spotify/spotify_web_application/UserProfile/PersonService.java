package com.spotify.spotify_web_application.UserProfile;

import com.spotify.spotify_web_application.entity.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepo personRepo;
}
