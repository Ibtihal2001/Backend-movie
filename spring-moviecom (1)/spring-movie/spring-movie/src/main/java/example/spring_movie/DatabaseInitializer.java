package example.spring_movie;


import example.spring_movie.model.MovieDTO;
import example.spring_movie.service.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final MovieService movieService;

    public DatabaseInitializer(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) {
        addMovie(
                "Vendeta",
                "Vendetta est un thriller d'action américain écrit et réalisé par Jared Cohn et sorti en 2022.",
                "https://img7.cdn.cinoche.com/images/14b63ac14dbd243133ba75aca2d3a371.jpg",
                false
        );
        addMovie(
                "SHE has a name",
                "pièce de théâtre sur la traite des êtres humains écrite par Andrew Kooma",
                "https://m.media-amazon.com/images/M/MV5BMmI0ZWMzYjctMDdjOC00NGZiLWFkNDItNWJmZjlmZGU2NzAwXkEyXkFqcGdeQXVyMjA1NzUxOTM@._V1_.jpg",
                false

        );
        addMovie(
                "Your Name",
                "Your Name suit deux adolescentsde la destin",
                "https://fr.web.img2.acsta.net/pictures/16/12/12/13/49/295774.jpg",
                true
        );
        addMovie(
                "Tu Ne Tueras Point",
                "Tu ne tueras point (Hacksaw Ridge), réalisé par Mel Gibson",
                "https://i.pinimg.com/736x/a8/cd/4e/a8cd4ec052397f1f215e0df9efb2aa41.jpg",
                true
        );
    }

    private void addMovie(String name, String description, String img, Boolean favorite) {
        MovieDTO movie = new MovieDTO();
        movie.setName(name);
        movie.setDescription(description);
        movie.setImg(img);
        movie.setFavorite(favorite);
        movieService.create(movie);
    }

}

