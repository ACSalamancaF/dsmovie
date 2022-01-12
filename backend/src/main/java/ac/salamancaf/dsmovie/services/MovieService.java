package ac.salamancaf.dsmovie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ac.salamancaf.dsmovie.dto.MovieDTO;
import ac.salamancaf.dsmovie.entities.Movie;
import ac.salamancaf.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Transactional(readOnly = true)//somente leitura
	public Page<MovieDTO> findAll(Pageable pageable){
		Page<Movie> result = movieRepository.findAll(pageable);//busca de página das entidades
		Page<MovieDTO> page=result.map(x -> new MovieDTO(x));//converte essa pagina para uma DTO
		return page;//Retorna DTO
	}
	
	public MovieDTO findById(Long id){
		Movie result = movieRepository.findById(id).get();
		MovieDTO dto=new MovieDTO(result);
		return dto;//Retorna DTO
	}
}
