package com.eBiblio.models.domaine.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
    private List<RoleDto> roles = new ArrayList<>();

    public UserDto(String username, String password, List<RoleDto> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

}
