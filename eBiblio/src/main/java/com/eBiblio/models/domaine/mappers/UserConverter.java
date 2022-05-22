package com.eBiblio.models.domaine.mappers;

import com.eBiblio.models.User;
import com.eBiblio.models.domaine.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {

    public static UserDto toVo(User bo) {
        if (bo == null)
            return null;
        UserDto vo = new UserDto();
        vo.setId(bo.getId());
        vo.setUsername(bo.getUsername());
        vo.setPassword(bo.getPassword());
        vo.setRoles(RoleConverter.toVoList(bo.getRoles()));
        return vo;
    }

    public static User toBo(UserDto vo) {
        if (vo == null)
            return null;
        User bo = new User();
        if (vo.getId() != null)
            bo.setId(vo.getId());
        bo.setUsername(vo.getUsername());
        bo.setPassword(vo.getPassword());
        bo.setRoles(RoleConverter.toBoList(vo.getRoles()));
        return bo;
    }

    public static List<UserDto> toVoList(List<User> boList) {
        if (boList == null || boList.isEmpty())
            return null;
        List<UserDto> voList = new ArrayList<>();
        for (User user : boList) {
            voList.add(toVo(user));
        }
        return voList;
    }

    public static List<User> toBoList(List<UserDto> voList) {
        if (voList == null || voList.isEmpty())
            return null;
        List<User> boList = new ArrayList<>();
        for (UserDto UserDto : voList) {
            boList.add(toBo(UserDto));
        }
        return boList;
    }

}
