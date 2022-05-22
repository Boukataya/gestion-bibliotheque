package com.eBiblio.services.member;

import com.eBiblio.models.domaine.dto.MemberDto;

import java.util.List;

public interface IMemberService {

    List<MemberDto> getAllMembers();

    void saveMember(MemberDto emp);

    MemberDto getMemberById(Long id);

    MemberDto getMemberByEmail(String email);

    void deleteMember(Long id);

    //Pour la pagination
    List<MemberDto> findAll(int pageId, int size);

    //pour le tri
    List<MemberDto> sortBy(String fieldName);

}
