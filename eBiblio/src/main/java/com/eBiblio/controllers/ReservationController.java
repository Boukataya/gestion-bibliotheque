package com.eBiblio.controllers;

import com.eBiblio.models.domaine.dto.DocumentDto;
import com.eBiblio.models.domaine.dto.MemberDto;
import com.eBiblio.models.domaine.dto.ReservationDto;
import com.eBiblio.models.domaine.mappers.DocumentConverter;
import com.eBiblio.models.domaine.mappers.MemberConverter;
import com.eBiblio.services.document.IDocumentService;
import com.eBiblio.services.member.IMemberService;
import com.eBiblio.services.reservation.IReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final IReservationService reservationService;
    private final IDocumentService documentService;
    private final IMemberService memberService;

    public ReservationController(IReservationService reservationService, IMemberService memberService, IDocumentService documentService) {
        this.reservationService = reservationService;
        this.memberService = memberService;
        this.documentService = documentService;
    }

    @PostMapping("/new/{idDocument}/{idMembre}")
    public ResponseEntity<Object> addReservation(@PathVariable Long idDocument, @PathVariable Long idMembre) {
        DocumentDto document = documentService.getDocumentById(idDocument);
        MemberDto memberDto = memberService.getMemberById(idMembre);
        ReservationDto newReservation = new ReservationDto(new Date(), MemberConverter.toMember(memberDto), DocumentConverter.toDocument(document));
        reservationService.addReservation(newReservation);
        return new ResponseEntity<>("The book " + document.getTitle() + " has been reserved successfully!", HttpStatus.CREATED);
    }

    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<Object> addReservation(@PathVariable Long id) {
        reservationService.cancelReservation(id);
        return new ResponseEntity<>("Your reservation has been canceled!", HttpStatus.OK);
    }

    @GetMapping("/member/{id}")
    public List<ReservationDto> memberReservation(@PathVariable Long id) {
        return reservationService.allReservationsByMember(id);
    }

}
