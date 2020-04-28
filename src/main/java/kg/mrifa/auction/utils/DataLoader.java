package kg.mrifa.auction.utils;

import kg.mrifa.auction.databases.StatusRepo;
import kg.mrifa.auction.models.domain.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Component
public class DataLoader implements ApplicationRunner {
    private StatusRepo statusRepo;
    @Autowired
    public DataLoader (StatusRepo statusRepo){
        this.statusRepo=statusRepo;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Status> statuses= Arrays.asList(
                new Status("Активен"),
                new Status("Закрыт"),
                new Status("Не начат"),
                new Status("Определен победитель"));

        ExampleMatcher exampleMatcher=ExampleMatcher.matching().withIgnorePaths("id")
                .withMatcher("name", ignoreCase());
        statuses.stream()
                .forEach(x->{
                    if (!statusRepo.exists(Example.of(x,exampleMatcher))){
                        statusRepo.save(x);
                    }else {
                        System.out.println("Такой статус существует");
                    }
                });

    }

}
