package ac.salamancaf.dsmovie.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.salamancaf.dsmovie.dto.MovieDTO;
import ac.salamancaf.dsmovie.services.ScoreService;

@RestController
@RequestMapping(value="/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody MovieDTO dto){
		MovieDTO mdto = scoreService.saveScore(null);
		return mdto;
	}
}
