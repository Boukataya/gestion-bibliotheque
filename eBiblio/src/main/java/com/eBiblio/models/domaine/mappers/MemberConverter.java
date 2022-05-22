package com.eBiblio.models.domaine.mappers;

import com.eBiblio.models.domaine.dto.MemberDto;
import com.eBiblio.models.Membre;

import java.util.ArrayList;
import java.util.List;

public class MemberConverter {

    public static MemberDto toMemberDto(Membre membre) {
        if (membre == null || membre.getId() == null)
            return null;
        MemberDto memberDto = new MemberDto();
        memberDto.setId(membre.getId());
        memberDto.setNom(membre.getNom());
        memberDto.setPrenom(membre.getPrenom());
        memberDto.setEmail(membre.getEmail());
        memberDto.setTelephone(membre.getTelephone());
        memberDto.setActive(membre.isActive());

        return memberDto;
    }

    public static Membre toMember(MemberDto memberDto) {
        Membre membre = new Membre();
        membre.setId(memberDto.getId());
        membre.setNom(memberDto.getNom());
        membre.setPrenom(memberDto.getPrenom());
        membre.setEmail(memberDto.getEmail());
        membre.setTelephone(memberDto.getTelephone());
        membre.setActive(memberDto.isActive());
        return membre;
    }

    public static List<MemberDto> toListMemberDto(List<Membre> membreList) {
        List<MemberDto> memberDtoList = new ArrayList<>();
        for (Membre emp : membreList) {
            memberDtoList.add(toMemberDto(emp));
        }
        return memberDtoList;
    }

}


