package repositories;

import models.Diary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DiaryRepo extends JpaRepository<Diary, Long> {

    @Override
    Optional<Diary> findById(Long aLong);
}
