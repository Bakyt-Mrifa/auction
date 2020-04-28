package kg.mrifa.auction.services;

import kg.mrifa.auction.models.dto.LotDto;

public interface LotService {
    LotDto saveLot(LotDto lotDto);
    LotDto findById(Long id);
}
