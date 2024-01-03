package example.spring_movie.repos;

import example.spring_movie.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {

    boolean existsByNameIgnoreCase(String name);

}
