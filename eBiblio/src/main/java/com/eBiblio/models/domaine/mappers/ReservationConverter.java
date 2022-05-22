package com.eBiblio.models.domaine.mappers;

import com.eBiblio.models.Reservation;
import com.eBiblio.models.domaine.dto.ReservationDto;

import java.util.ArrayList;
import java.util.List;

public class ReservationConverter {

    public static ReservationDto toReservationDto(Reservation reservation) {
        if (reservation == null || reservation.getId() == null) return null;
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservation.getId());
        reservationDto.setMembre(reservation.getMembre());
        reservationDto.setDocument(reservation.getDocument());
        reservationDto.setDateReservation(reservation.getDateReservation());

        return reservationDto;
    }

    public static Reservation toReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDto.getId());
        reservation.setMembre(reservationDto.getMembre());
        reservation.setDocument(reservationDto.getDocument());
        reservation.setDateReservation(reservationDto.getDateReservation());
        return reservation;
    }

    public static List<ReservationDto> reservationDtoList(List<Reservation> reservationList) {
        List<ReservationDto> reservationDtoList = new ArrayList<>();
        for (Reservation reservation : reservationList)
            reservationDtoList.add(toReservationDto(reservation));
        return reservationDtoList;
    }

    public static List<Reservation> reservationList(List<ReservationDto> reservationDtoList) {
        List<Reservation> reservationList = new ArrayList<>();
        for (ReservationDto reservationDto : reservationDtoList)
            reservationList.add(toReservation(reservationDto));
        return reservationList;
    }

}
