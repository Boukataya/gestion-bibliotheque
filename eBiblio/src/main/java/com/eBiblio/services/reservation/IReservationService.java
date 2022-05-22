package com.eBiblio.services.reservation;

import com.eBiblio.models.domaine.dto.ReservationDto;

import java.util.List;

public interface IReservationService {

    void addReservation(ReservationDto reservation);

    void cancelReservation(Long id);

    List<ReservationDto> allReservationsByMember(Long memberId);

}
