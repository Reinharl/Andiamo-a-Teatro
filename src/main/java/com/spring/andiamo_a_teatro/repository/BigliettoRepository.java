package com.spring.andiamo_a_teatro.repository;

import com.spring.andiamo_a_teatro.entity.Biglietto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BigliettoRepository extends JpaRepository<Biglietto, Long> {

    List<Biglietto> findAllBySeat_IdAndShow_Id(Long idSeat, Long idShow);

    List<Biglietto> findAllByUser_IdAndShow_Id(Long idUser, Long idShow);

}
