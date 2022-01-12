package ac.salamancaf.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.salamancaf.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
