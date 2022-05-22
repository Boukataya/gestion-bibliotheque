package com.eBiblio.repsitories;

import com.eBiblio.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {
	List<Role> findByRole(String role);

	List<Role> findAll();

}