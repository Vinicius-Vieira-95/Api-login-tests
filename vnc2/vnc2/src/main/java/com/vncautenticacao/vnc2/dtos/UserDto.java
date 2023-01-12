package com.vncautenticacao.vnc2.dtos;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDto implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private String password;
    private String role;
}
