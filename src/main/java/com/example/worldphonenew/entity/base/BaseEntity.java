package com.example.worldphonenew.entity.base;

import jakarta.persistence.Column;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

/**
 * Description:
 *
 * @author: hieu
 * @since: 19/01/2024
 * Project_name: com.example.worldphonenew.entity.base
 */

public abstract class BaseEntity {
    @CreatedDate
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @LastModifiedDate
    @Column(name = "MODIFIER_DATE")
    private Date modifierDate;

    @CreatedBy
    @Column(name = "CREATE_BY")
    private String createBy = "ADMIN";

    @LastModifiedDate
    @Column(name = "MODIFIER_BY")
    private String modifierBy = "ADMIN";

    @Column(name = "DELETE_FLAG")
    private boolean deleteFlag = false;
}
