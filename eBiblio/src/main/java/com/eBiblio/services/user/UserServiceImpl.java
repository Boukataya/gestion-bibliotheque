package com.eBiblio.services.user;

import com.eBiblio.exceptions.BusinessException;
import com.eBiblio.models.Role;
import com.eBiblio.models.User;
import com.eBiblio.models.domaine.dto.RoleDto;
import com.eBiblio.models.domaine.dto.UserDto;
import com.eBiblio.models.domaine.mappers.RoleConverter;
import com.eBiblio.models.domaine.mappers.UserConverter;
import com.eBiblio.repsitories.MemberRepository;
import com.eBiblio.repsitories.RoleRepository;
import com.eBiblio.repsitories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), enabled,
                accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
        List<GrantedAuthority> springSecurityAuthorities = new ArrayList<>();
        roles.forEach(r -> springSecurityAuthorities.add(new SimpleGrantedAuthority(r.getRole())));
        return springSecurityAuthorities;
    }

    @Override
    public void saveUser(UserDto userVo) {
        User user = UserConverter.toBo(userVo);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        List<Role> rolesPersist = new ArrayList<>();
        for (Role role : user.getRoles()) {
            Role userRole = roleRepository.findByRole(role.getRole()).get(0);
            rolesPersist.add(userRole);
        }
        user.setRoles(rolesPersist);
        userRepository.save(user);
    }

    @Override
    public void saveRole(RoleDto roleVo) {
        roleRepository.save(RoleConverter.toBo(roleVo));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return UserConverter.toVoList(userRepository.findAll());
    }

    @Override
    public List<RoleDto> getAllRoles() {
        return RoleConverter.toVoList(roleRepository.findAll());
    }

    @Override
    public RoleDto getRoleByName(String role) {
        return RoleConverter.toVo(roleRepository.findByRole(role).get(0));
    }

    @Override
    public void cleanDataBase() {
        userRepository.deleteAll();
        roleRepository.deleteAll();
        memberRepository.deleteAll();
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public UserDto findByUsername(String username) {
        if (username == null || username.trim().equals(""))
            throw new BusinessException("login is empty !!");

        User bo = userRepository.findByUsername(username);

        if (bo == null)
            throw new BusinessException("No user with this login");

        UserDto vo = UserConverter.toVo(bo);
        return vo;
    }

}
