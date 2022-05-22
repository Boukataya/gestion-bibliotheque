package com.eBiblio.controllers;

import com.eBiblio.models.domaine.dto.RoleDto;
import com.eBiblio.models.domaine.dto.TokenDto;
import com.eBiblio.models.domaine.dto.UserDto;
import com.eBiblio.exceptions.BusinessException;
import com.eBiblio.jwt.JwtUtils;
import com.eBiblio.services.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private IUserService userService;

	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<TokenDto> authenticateUser(@Valid @RequestBody UserDto userVo) {

		try {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(userVo.getUsername(), userVo.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);

			TokenDto tokenVo = new TokenDto();
			tokenVo.setJwttoken(jwt);
			tokenVo.setUsername(userVo.getUsername());
			Collection<? extends GrantedAuthority> list = authentication.getAuthorities();
			list.forEach(authority -> tokenVo.getRoles().add(authority.getAuthority()));
			return ResponseEntity.ok(tokenVo);
		} catch (Exception e) {
			throw new BusinessException("Username or password incorrect!");
		}

	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userVo) {
		if (userService.existsByUsername(userVo.getUsername())) {
			return ResponseEntity.badRequest().body("Error: Username is already taken!");
		}
		// par défaut, le client a le rôle CLIENT
		userVo.getRoles().add(new RoleDto("CLIENT"));
		userService.saveUser(userVo);
		return ResponseEntity.ok("User registered successfully!");
	}

}
