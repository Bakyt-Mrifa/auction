package kg.mrifa.auction.models.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import kg.mrifa.auction.models.domain.Status;
import lombok.Data;
import java.util.Date;

@Data
public class LotDto {
    private Long id;
    @JsonProperty("lotName")
    private String name;
    @JsonProperty("lotPrice")
    private double price;
    private double minPrice;
    private double step;
   // @JsonIgnore
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date startDate;
   // @JsonIgnore
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonProperty("endDate")
    private Date finishDate;
    @JsonProperty("statusDto")
    private Status status;
}
