package com.spotify.spotify_web_application.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    UserDetails findByRefId(String refId);

}
