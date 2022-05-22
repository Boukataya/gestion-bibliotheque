package com.eBiblio.services.user;

import com.eBiblio.models.domaine.dto.RoleDto;
import com.eBiblio.models.domaine.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    void saveUser(UserDto user);

    void saveRole(RoleDto role);

    List<UserDto> getAllUsers();

    List<RoleDto> getAllRoles();

    RoleDto getRoleByName(String role);

    void cleanDataBase();

    boolean existsByUsername(String username);

    UserDto findByUsername(String username);

}
