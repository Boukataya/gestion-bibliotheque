package com.eBiblio.models.domaine.mappers;

import com.eBiblio.models.domaine.dto.RoleDto;
import com.eBiblio.models.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleConverter {

	public static RoleDto toVo(Role bo) {
		if (bo == null)
			return null;
		RoleDto vo = new RoleDto();
		vo.setId(bo.getId());
		vo.setRole(bo.getRole());
		return vo;
	}

	public static Role toBo(RoleDto vo) {
		if (vo == null)
			return null;
		Role bo = new Role();
		bo.setId(vo.getId());
		bo.setRole(vo.getRole());
		return bo;
	}

	public static List<RoleDto> toVoList(List<Role> boList) {
		if (boList == null || boList.isEmpty())
			return null;
		List<RoleDto> voList = new ArrayList<>();
		for (Role role : boList) {
			voList.add(toVo(role));
		}
		return voList;
	}

	public static List<Role> toBoList(List<RoleDto> voList) {
		if (voList == null || voList.isEmpty())
			return null;
		List<Role> boList = new ArrayList<>();
		for (RoleDto roleVo : voList) {
			boList.add(toBo(roleVo));
		}
		return boList;
	}

}
