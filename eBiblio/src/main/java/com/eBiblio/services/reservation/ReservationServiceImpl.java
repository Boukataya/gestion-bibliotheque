package com.eBiblio.services.reservation;

import com.eBiblio.models.Membre;
import com.eBiblio.models.Reservation;
import com.eBiblio.models.domaine.dto.ReservationDto;
import com.eBiblio.models.domaine.mappers.ReservationConverter;
import com.eBiblio.repsitories.MemberRepository;
import com.eBiblio.repsitories.ReservationRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService {

    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, MemberRepository memberRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
    }

    @Override
    public void addReservation(ReservationDto reservationDto) {
        reservationRepository.save(ReservationConverter.toReservation(reservationDto));
    }

    @Override
    public void cancelReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<ReservationDto> allReservationsByMember(Long memberId) {
        Optional<Membre> membre = memberRepository.findById(memberId);
        Membre membre1 = membre.get();
        List<Reservation> reservationListByMember = membre1.getReservationList();
        return ReservationConverter.reservationDtoList(reservationListByMember);
    }

}
