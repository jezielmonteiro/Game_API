package com.jezielmonteiro.gameapi.infrastructure.http.request;

import com.jezielmonteiro.gameapi.application.input.UpdateGameInput;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.Year;

public record UpdateGameRequest(
    @NotBlank(message = "O título é obrigatório")
    @Size(min = 3, max = 150)
    String title,

    @NotBlank(message = "O nome do estúdio desenvolvedor é obrigatório")
    @Size(min = 3, max = 100)
    String developer,

    @NotNull(message = "O ano de lançamento é obrigatório")
    @Positive(message = "O ano de lançamento deve ser positivo")
    Integer releaseYear
) {
    @AssertTrue(message = "O ano de lançamento não pode ser maior que o ano atual")

    public boolean isReleaseYearValid() {
        return releaseYear == null
                || releaseYear <= Year.now().getValue();
        }

    public UpdateGameInput toInput() {
        return new UpdateGameInput(title, developer, releaseYear);
    }
}