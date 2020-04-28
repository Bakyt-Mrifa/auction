package kg.mrifa.auction.mappings;

import kg.mrifa.auction.models.domain.Lot;
import kg.mrifa.auction.models.dto.LotDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LotMapper {
    LotMapper INSTANCE= Mappers.getMapper(LotMapper.class);

    Lot lotDtoToLot(LotDto lotDto);
    LotDto lotToLotDto (Lot lot);

}
