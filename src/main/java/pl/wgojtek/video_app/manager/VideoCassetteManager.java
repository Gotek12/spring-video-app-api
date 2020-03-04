package pl.wgojtek.video_app.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.wgojtek.video_app.dao.VideoCassetteRepo;
import pl.wgojtek.video_app.dao.entity.VideoCasette;

import java.time.LocalDate;
import java.util.Optional;

//nie wiązemy logiki dostęp do danych a api
//warstwa pomiędzy api a dostępem do danych
@Service
public class VideoCassetteManager {

    private VideoCassetteRepo videoCassetteRepo;

    @Autowired
    public VideoCassetteManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    //pobieranie jednego
    public Optional<VideoCasette> findById(Long id){
        return videoCassetteRepo.findById(id);
    }

    //pobieranie wszystkich
    public Iterable<VideoCasette> findAll(){
        return videoCassetteRepo.findAll();
    }

    //zapisywanie
    public VideoCasette save(VideoCasette videoCasette){
        return videoCassetteRepo.save(videoCasette);
    }

    //usówanie
    public void deleteById(Long id){
        videoCassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new VideoCasette(1L, "Titanic", LocalDate.of(1995, 1, 1)));
        save(new VideoCasette(2L, "Pulp Fiction", LocalDate.of(1990, 2, 11)));
    }

}
