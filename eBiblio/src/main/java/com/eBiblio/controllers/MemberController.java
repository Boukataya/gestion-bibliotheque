package com.eBiblio.controllers;

import com.eBiblio.models.domaine.dto.MemberDto;
import com.eBiblio.services.member.IMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MemberController {

    private IMemberService memberService;

    public MemberController(IMemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<MemberDto> getAll() {
        return memberService.getAllMembers();
    }

    @GetMapping(value = "/member/{id}")
    public ResponseEntity<Object> getMemberById(@PathVariable(value = "id") Long memberVoId) {
        MemberDto memberVoFound = memberService.getMemberById(memberVoId);
        if (memberVoFound == null)
            return new ResponseEntity<>("Member doesn't exist", HttpStatus.OK);
        return new ResponseEntity<>(memberVoFound, HttpStatus.OK);
    }

    @PostMapping(value = "/admin/create")
    public ResponseEntity<Object> createMember(@Valid @RequestBody MemberDto memberVo) {
        MemberDto memberVoFound = memberService.getMemberByEmail(memberVo.getEmail());
        if (memberVoFound != null)
            return new ResponseEntity<>("Email already exist", HttpStatus.FORBIDDEN);

        memberService.saveMember(memberVo);
        return new ResponseEntity<>("Member is created successfully", HttpStatus.CREATED);

    }

    @PutMapping(value = "/admin/update/{id}")
    public ResponseEntity<Object> updateMember(@PathVariable(name = "id") Long memberVoId, @Valid @RequestBody MemberDto memberDto) {
        MemberDto memberVoFound = memberService.getMemberById(memberVoId);
        if (memberVoFound == null)
            return new ResponseEntity<>("Member doesn't exist", HttpStatus.OK);
        memberDto.setId(memberVoId);
        memberService.saveMember(memberDto);
        return new ResponseEntity<>("Member is updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/admin/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Object> deleteMember(@PathVariable(name = "id") Long memberVoId) {
        MemberDto memberVoFound = memberService.getMemberById(memberVoId);
        if (memberVoFound == null)
            return new ResponseEntity<>("Member doesn't exist", HttpStatus.OK);
        memberService.deleteMember(memberVoId);
        return new ResponseEntity<>("Member is deleted successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/employees/sort/{fieldName}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public List<MemberDto> sortBy(@PathVariable String fieldName) {
        return memberService.sortBy(fieldName);
    }

    @GetMapping("/employees/pagination/{pageid}/{size}")
    public List<MemberDto> pagination(@PathVariable int pageid, @PathVariable int size, Model m) {
        return memberService.findAll(pageid, size);
    }

}
