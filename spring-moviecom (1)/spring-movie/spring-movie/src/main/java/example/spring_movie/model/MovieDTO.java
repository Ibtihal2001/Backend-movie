package example.spring_movie.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MovieDTO {

    private Long id;

    private String description;

    @NotNull
    @Size(max = 255)
    private String name;

    private Boolean favorite;

    @NotNull
    @Size(max = 255)
    private String img;

}
