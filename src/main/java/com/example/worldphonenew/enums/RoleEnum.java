package com.example.worldphonenew.enums;

/**
 * Description:
 *
 * @author: hieu
 * @since: 22/01/2024
 * Project_name: com.example.worldphonenew.enums
 */
public enum RoleEnum {
    ADMIN("ADMIN"),
    IT("IT"),
    SELL("SELL"),
    WAREHOUSE("WAREHOUSE");

    private String value;

    RoleEnum(String value) {
        this.value = value;
    }
}
