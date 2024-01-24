package com.example.worldphonenew.repository;

import com.example.worldphonenew.entity.UsersEntity;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * Description:
 *
 * @author: hieu
 * @since: 20/01/2024
 * Project_name: com.example.worldphonenew.repository
 */
public interface UsersRepository extends Repository<UsersEntity, Long> {
    Boolean existsByEmail(String email);
    Optional<UsersEntity> findByEmail(String email);
}
