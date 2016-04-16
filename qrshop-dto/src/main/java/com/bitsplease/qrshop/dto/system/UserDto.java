package com.bitsplease.qrshop.dto.system;

import com.bitsplease.qrshop.dto.AbstractDto;
import com.bitsplease.qrshop.dto.embeddable.NameDto;

/**
 * @author Chrisostomos Bakouras
 */
public class UserDto extends AbstractDto {

    private String username;
    private String password;
    private NameDto name;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public NameDto getName() {
        return name;
    }

    public void setName(NameDto name) {
        this.name = name;
    }
}
