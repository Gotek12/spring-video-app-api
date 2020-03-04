package pl.wgojtek.video_app.dao;

import org.springframework.data.repository.CrudRepository;
import pl.wgojtek.video_app.dao.entity.VideoCasette;

public interface VideoCassetteRepo extends CrudRepository<VideoCasette, Long> {
}
