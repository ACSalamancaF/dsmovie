package ac.salamancaf.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ac.salamancaf.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
 User findByEmail(String email);
}
