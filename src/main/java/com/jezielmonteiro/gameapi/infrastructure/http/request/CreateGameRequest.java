package com.jezielmonteiro.gameapi.infrastructure.http.request;

import com.jezielmonteiro.gameapi.application.input.CreateGameInput;
import jakarta.validation.constraints.*;
import java.time.Year;

public record CreateGameRequest(
        @NotBlank(message = "O título é obrigatório")
        @Size(min = 3, max = 150,
                message = "O título deve possuir entre 3 e 150 caracteres")
        String title,

        @NotBlank(message = "O gênero é obrigatório")
        @Size(min = 5, max = 50,
                message = "O gênero deve possuir entre 5 e 50 caracteres")
        String genre,

        @NotBlank(message = "O nome do estúdio desenvolvedor é obrigatório")
        @Size(min = 3, max = 100,
                message = "O nome do estúdio desenvolvedor deve possuir entre 3 e 100 caracteres")
        String developer,

        @NotNull(message = "O ano de lançamento é obrigatório")
        @Positive(message = "O ano de lançamento deve ser positivo")
        Integer releaseYear
) {
    @AssertTrue(message =
            "O ano de lançamento não pode ser maior que o ano atual")
    public boolean isReleaseYearValid() {
        return releaseYear == null
                || releaseYear <= Year.now().getValue();
    }
    public CreateGameInput toInput() {
        return new CreateGameInput(title, genre, developer, releaseYear);
    }
}