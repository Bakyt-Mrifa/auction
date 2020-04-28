package kg.mrifa.auction.services;

import kg.mrifa.auction.models.dto.StatusDto;

import java.util.List;

public interface StatusService {
    StatusDto saveStatus (StatusDto statusDto);
    List<StatusDto> findStatuses();
    List<StatusDto> findStatuses(Integer pageNo, Integer pageSize, String sortBy);
}
