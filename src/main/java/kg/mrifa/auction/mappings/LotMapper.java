package kg.mrifa.auction.mappings;

import kg.mrifa.auction.models.domain.Lot;
import kg.mrifa.auction.models.dto.LotDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LotMapper {
    LotMapper INSTANCE= Mappers.getMapper(LotMapper.class);
    @Mapping(source = "minPr", target = "minPrice")
    Lot lotDtoToLot(LotDto lotDto);
    @Mapping(source = "minPrice", target = "minPr")
    LotDto lotToLotDto (Lot lot);

}
