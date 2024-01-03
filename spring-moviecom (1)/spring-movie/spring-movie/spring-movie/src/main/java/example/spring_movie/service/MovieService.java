package example.spring_movie.service;

import example.spring_movie.domain.Movie;
import example.spring_movie.model.MovieDTO;
import example.spring_movie.repos.MovieRepository;
import example.spring_movie.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> findAll() {
        final List<Movie> movies = movieRepository.findAll(Sort.by("id"));
        return movies.stream()
                .map(movie -> mapToDTO(movie, new MovieDTO()))
                .toList();
    }

    public MovieDTO get(final Long id) {
        return movieRepository.findById(id)
                .map(movie -> mapToDTO(movie, new MovieDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final MovieDTO movieDTO) {
        final Movie movie = new Movie();
        mapToEntity(movieDTO, movie);
        return movieRepository.save(movie).getId();
    }

    public void update(final Long id, final MovieDTO movieDTO) {
        final Movie movie = movieRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(movieDTO, movie);
        movieRepository.save(movie);
    }

    public void delete(final Long id) {
        movieRepository.deleteById(id);
    }

    private MovieDTO mapToDTO(final Movie movie, final MovieDTO movieDTO) {
        movieDTO.setId(movie.getId());
        movieDTO.setDescription(movie.getDescription());
        movieDTO.setName(movie.getName());
        movieDTO.setFavorite(movie.getFavorite());
        movieDTO.setImg(movie.getImg());
        return movieDTO;
    }

    private Movie mapToEntity(final MovieDTO movieDTO, final Movie movie) {
        movie.setDescription(movieDTO.getDescription());
        movie.setName(movieDTO.getName());
        movie.setFavorite(movieDTO.getFavorite());
        movie.setImg(movieDTO.getImg());
        return movie;
    }

    public boolean nameExists(final String name) {
        return movieRepository.existsByNameIgnoreCase(name);
    }

}
