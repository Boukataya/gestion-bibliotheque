package com.eBiblio.services.member;

import com.eBiblio.models.domaine.mappers.MemberConverter;
import com.eBiblio.models.domaine.dto.MemberDto;
import com.eBiblio.models.Membre;
import com.eBiblio.repsitories.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements IMemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberDto> getAllMembers() {
        List<Membre> list = memberRepository.findAll();
        return MemberConverter.toListMemberDto(list);
    }

    @Override
    public void saveMember(MemberDto emp) {
        memberRepository.save(MemberConverter.toMember(emp));
    }

    @Override
    public MemberDto getMemberById(Long id) {
        boolean trouve = memberRepository.existsById(id);
        if (!trouve)
            return null;
        return MemberConverter.toMemberDto(memberRepository.getById(id));
    }

    @Override
    public MemberDto getMemberByEmail(String email) {
        return MemberConverter.toMemberDto(memberRepository.findByEmail(email));
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    @Override
    public List<MemberDto> findAll(int pageId, int size) {
        Page<Membre> result = memberRepository.findAll(PageRequest.of(pageId, size, Direction.ASC, "name"));
        return MemberConverter.toListMemberDto(result.getContent());
    }

    @Override
    public List<MemberDto> sortBy(String fieldName) {
        return MemberConverter.toListMemberDto(memberRepository.findAll(Sort.by(fieldName)));
    }

}
