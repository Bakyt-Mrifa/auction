package kg.mrifa.auction.services.impl;

import kg.mrifa.auction.databases.StatusRepo;
import kg.mrifa.auction.mappings.StatusMapper;
import kg.mrifa.auction.models.domain.Status;
import kg.mrifa.auction.models.dto.StatusDto;
import kg.mrifa.auction.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepo statusRepo;
    @Override
    public StatusDto saveStatus(StatusDto statusDto) {
        Status status= StatusMapper.INSTANCE.statusDtoToStatus(statusDto);
        status=statusRepo.save(status);

        statusDto=StatusMapper.INSTANCE.statusToStatusDto(status);
        return statusDto;
    }

    @Override
    public List<StatusDto> findStatuses() {
        return StatusMapper.INSTANCE.statusesToStatusDtos(statusRepo.findAll());
    }

    @Override
    public List<StatusDto> findStatuses(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable= PageRequest.of(pageNo,pageSize, Sort.by(sortBy));
        return StatusMapper.INSTANCE.statusesToStatusDtos(statusRepo.findStatusesBy(pageable));
    }
}
