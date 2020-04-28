package kg.mrifa.auction.databases;

import kg.mrifa.auction.models.domain.Status;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepo extends JpaRepository<Status, Long> {
    List<Status> findStatusesBy(Pageable pageable);
}
