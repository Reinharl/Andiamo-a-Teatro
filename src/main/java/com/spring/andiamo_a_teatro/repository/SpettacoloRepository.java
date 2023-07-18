package com.spring.andiamo_a_teatro.repository;

import com.spring.andiamo_a_teatro.entity.Spettacolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SpettacoloRepository extends JpaRepository<Spettacolo, Long> {

    List<Spettacolo> findAllByHall_Id(Long idHall);

    List<Spettacolo> findAllByHall_Venue_CityAndDateBetween(String city, LocalDateTime startTime, LocalDateTime endTime);

    default List<Spettacolo> findByCityAndDate(String city, LocalDate date) {
        LocalDateTime startTime = date.atStartOfDay();
        LocalDateTime endTime = date.atTime(23, 59, 59);

        return findAllByHall_Venue_CityAndDateBetween(city, startTime, endTime);
    }

    @Query("SELECT s FROM Spettacolo s " +
            "WHERE s.genre IN (" +
            "   SELECT b.show.genre FROM Biglietto b " +
            "   WHERE b.user.id = :userId " +
            "   AND b.show.date < CURRENT_DATE " +
            "   ORDER BY b.show.date DESC " +
            ") " +
            "AND s.date >= CURRENT_TIMESTAMP " +
            "AND s.date < :endTime " +
            "ORDER BY s.date ASC " +
            "LIMIT 3")
    List<Spettacolo> findSuggestedShowsByUserId(Long userId, LocalDateTime endTime);

    default List<Spettacolo> findSuggestedShowsByUser(Long userId) {
        LocalDateTime endTime = LocalDateTime.now().plusMonths(1);
        return findSuggestedShowsByUserId(userId, endTime);
    }

}
