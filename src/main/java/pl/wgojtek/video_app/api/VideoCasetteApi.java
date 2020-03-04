package pl.wgojtek.video_app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.wgojtek.video_app.dao.entity.VideoCasette;
import pl.wgojtek.video_app.manager.VideoCassetteManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts")
public class VideoCasetteApi {

    private VideoCassetteManager videoCasettes;

    @Autowired
    public VideoCasetteApi(VideoCassetteManager videoCasettes) {
        this.videoCasettes = videoCasettes;
    }

    @GetMapping("/all")
    public Iterable<VideoCasette> getAll(){
        return videoCasettes.findAll();
    }

    //2
    //http://localhost:8080/api/1
    ///@GetMapping("/{index}")
    //public VideoCasette getById(@PathVariable int index){

    //1
    //http://localhost:8080/api/cassetts?index=1
    @GetMapping
    public Optional<VideoCasette> getById(@RequestParam Long index){
        return videoCasettes.findById(index);
    }

    //@RequestBody - zostanie przesłane w postaci serializowanej do aplikacji
    //http://localhost:8080/api/cassetts
    /*
    * jako json
    * {
        "id": 3,
        "title": "LOTR",
        "productionYear": "2001-02-01"
    }
    * */
    @PostMapping
    public VideoCasette addVideo(@RequestBody VideoCasette videoCasette){
        return videoCasettes.save(videoCasette);
    }

    //do odyfikowania
    @PutMapping
    public VideoCasette updateVideo(@RequestBody VideoCasette videoCasette){
        return videoCasettes.save(videoCasette);
    }

    //http://localhost:8080/api/cassetts?index=3
    @DeleteMapping
    public void deleteVideo(@RequestParam Long index){
        videoCasettes.deleteById(index);
    }
}

