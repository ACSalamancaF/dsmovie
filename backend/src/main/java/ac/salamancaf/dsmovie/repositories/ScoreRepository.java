package ac.salamancaf.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.salamancaf.dsmovie.entities.Score;
import ac.salamancaf.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
