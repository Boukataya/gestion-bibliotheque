package com.eBiblio.models.domaine.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleDto {
	private Long id;
	private String role;

	public RoleDto(String role) {
		this.role = role;
	}
}