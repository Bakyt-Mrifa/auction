package kg.mrifa.auction.databases;

import kg.mrifa.auction.models.domain.Lot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LotRepo extends JpaRepository<Lot, Long> {}
