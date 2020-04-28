package kg.mrifa.auction.mappings;

import kg.mrifa.auction.models.domain.Status;
import kg.mrifa.auction.models.dto.StatusDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StatusMapper {
    StatusMapper INSTANCE= Mappers.getMapper(StatusMapper.class);

    Status statusDtoToStatus (StatusDto statusDto);
    StatusDto statusToStatusDto (Status status);

    List<Status> statusDtosToStatuses (List<StatusDto> statusDtos);
    List<StatusDto> statusesToStatusDtos (List<Status> statuses);
}
