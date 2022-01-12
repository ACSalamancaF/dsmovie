package ac.salamancaf.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ac.salamancaf.dsmovie.dto.MovieDTO;
import ac.salamancaf.dsmovie.dto.ScoreDTO;
import ac.salamancaf.dsmovie.entities.Movie;
import ac.salamancaf.dsmovie.entities.Score;
import ac.salamancaf.dsmovie.entities.User;
import ac.salamancaf.dsmovie.repositories.MovieRepository;
import ac.salamancaf.dsmovie.repositories.ScoreRepository;
import ac.salamancaf.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {//método save score
		User user = userRepository.findByEmail(dto.getEmail());
		if(user==null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		score = scoreRepository.saveAndFlush(score);
		
		double sum=0.0;
		for(Score s:movie.getScores()) {
			sum = sum + s.getValue();
		}
		
		double avg =sum/movie.getScores().size();
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
}
