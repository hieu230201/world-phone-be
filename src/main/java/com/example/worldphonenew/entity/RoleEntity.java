package com.example.worldphonenew.entity;

import com.example.worldphonenew.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Description:
 *
 * @author: hieu
 * @since: 20/01/2024
 * Project_name: com.example.worldphonenew.entity
 */
@Entity
@Table(name = "role")
@Data
public class RoleEntity extends BaseEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "NAME")
    private String name;
}
