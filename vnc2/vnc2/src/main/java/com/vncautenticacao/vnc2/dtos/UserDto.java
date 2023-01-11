package com.vncautenticacao.vnc2.dtos;

import java.util.List;

import lombok.Data;

@Data
public class UserDto {
    
    private Long idUser;
    private List<Long> idsRoles;
}
