package com.example.worldphonenew.service;

import com.example.worldphonenew.dto.LoginDto;
import com.example.worldphonenew.entity.RoleEntity;
import com.example.worldphonenew.entity.UsersEntity;
import org.springframework.http.ResponseEntity;

/**
 * Description:
 *
 * @author: hieu1
 * @since: 23/01/2024
 * Project_name: com.example.worldphonenew.service
 */
public interface UserService {

    String login(LoginDto loginDto);

    UsersEntity addOrUpdateUser (UsersEntity usersEntity);


}
