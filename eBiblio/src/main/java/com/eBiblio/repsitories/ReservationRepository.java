package com.eBiblio.repsitories;

import com.eBiblio.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {


    List<Reservation> findByDocument_Id(Long documentId);

}
