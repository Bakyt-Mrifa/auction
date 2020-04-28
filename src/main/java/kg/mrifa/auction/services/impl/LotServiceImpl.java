package kg.mrifa.auction.services.impl;

import kg.mrifa.auction.databases.LotRepo;
import kg.mrifa.auction.databases.StatusRepo;
import kg.mrifa.auction.mappings.LotMapper;
import kg.mrifa.auction.models.domain.Lot;
import kg.mrifa.auction.models.domain.Status;
import kg.mrifa.auction.models.dto.LotDto;
import kg.mrifa.auction.services.LotService;
import kg.mrifa.auction.utils.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

@Service
public class LotServiceImpl implements LotService {
    @Autowired
    private LotRepo lotRepo;
    @Override
    public LotDto saveLot(LotDto lotDto) {
        /*List<Status> statuses= Arrays.asList(
                new Status("Активен"),
                new Status("Закрыт"),
                new Status("Не начат"),
                new Status("Определен победитель"));
        if (lotDto.getStatus().getName()==statuses.stream().forEach(x->x.getName())){}*/
        //преобразование lotDto в lot

        Lot lot=LotMapper.INSTANCE.lotDtoToLot(lotDto);
        lot=lotRepo.save(lot);
        System.out.println("From lot: "+lot);
       //JOptionPane.showMessageDialog(null,lot);

        //преобразование lot в lotDto
        lotDto=LotMapper.INSTANCE.lotToLotDto(lot);
        System.out.println("From lotDto: "+lotDto);
        return lotDto;
    }

    @Override
    public LotDto findById(Long id) {
        Lot lot=lotRepo.findById(id).orElse(new Lot());
        LotDto lotDto=LotMapper.INSTANCE.lotToLotDto(lot);
        return lotDto;
    }
}
