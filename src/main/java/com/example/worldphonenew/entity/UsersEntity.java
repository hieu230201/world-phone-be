package com.example.worldphonenew.entity;

import com.example.worldphonenew.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Description:
 *
 * @author: hieu
 * @since: 19/01/2024
 * Project_name: com.example.worldphonenew.entity
 */

@Entity
@Table(name = "users", schema = "new_world_phone")
@Data
public class UsersEntity extends BaseEntity implements UserDetails {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    @Column(name = "FULL_NAME")
    private String fullName;

    @Basic
    @Column(name = "USERNAME")
    private String username;

    @Basic
    @Column(name = "PASSWORD")
    private String password;

    @Basic
    @Column(name = "LDAP_FLAG")
    private String ldapFlag;

    @Basic
    @Column(name = "IMAGE")
    private String image;

    @Basic
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;

    @Basic
    @Column(name = "PHONE")
    private String phoneNumber;

    @Basic
    @Column(name = "EMAIL")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER  , cascade = CascadeType.PERSIST)
    List <RoleEntity> roles ;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        this.roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
