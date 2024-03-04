package com.example.worldphonenew.service.impl;

import com.example.worldphonenew.dto.LoginDto;
import com.example.worldphonenew.entity.UsersEntity;
import com.example.worldphonenew.repository.UsersRepository;
import com.example.worldphonenew.security.JwtUtilities;
import com.example.worldphonenew.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author: hieu
 * @since: 23/01/2024
 * Project_name: com.example.worldphonenew.service.impl
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthenticationManager authenticationManager ;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private JwtUtilities jwtUtilities;

    @Override
    public String login(LoginDto loginDto) {
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UsersEntity user = usersRepository.findByEmail(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<String> rolesNames = new ArrayList<>();
        user.getRoles().forEach(r-> rolesNames.add(r.getName()));
        String token = jwtUtilities.generateToken(user.getUsername(),rolesNames);
        return token;
    }

    @Override
    @Transactional
    public UsersEntity addOrUpdateUser(UsersEntity usersEntity) {
        if (usersEntity != null) {
            if (usersEntity.getId() != null) {

            } else {

            }
        }
        return null;
    }
}
