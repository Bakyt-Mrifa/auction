package kg.mrifa.auction.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping(value = "/file")
public class FileController {

    @Value("${file.upload-dir}") // из application.properties
    private String dirPath;

    @PostMapping(value = "/upload")
    public void upload(
            @RequestParam MultipartFile file,
            @RequestParam (name="lot")String lotId

            ){
        //Указываем путь до локальной директории, для сохраниения файлов
       // String dirPath="E:\\Distr\\Projects\\Java\\4. images\\";
        // Путь до нашего файла
        Path path= Paths.get(dirPath+lotId);
        if (!Files.exists(path)){
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            path=Paths.get(path+"/"+file.getOriginalFilename());
        }

        try {
            Files.write(path,file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
