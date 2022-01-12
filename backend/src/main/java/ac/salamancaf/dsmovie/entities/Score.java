package ac.salamancaf.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="tb_score")
public class Score {

	@EmbeddedId
	private ScorePK id= new ScorePK();
	
	private Double value;
	
	public Score() {}

	//referenciar o score ao movie
	public void setMovie (Movie movie) {
		id.setMovie(movie);
	}
	//referenciar o score ao user
		public void setUser (User user) {
			id.setUser(user);
		}
		
	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}
	
}
