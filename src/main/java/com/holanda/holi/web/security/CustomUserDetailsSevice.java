package com.holanda.holi.web.security;

import com.holanda.holi.domain.repository.AuthRepository;
import com.holanda.holi.persistence.mapper.AuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsSevice implements UserDetailsService {

    @Autowired
    private AuthRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return AuthMapper.toUserDetails(repository.findByEmail(username));
    }
}
