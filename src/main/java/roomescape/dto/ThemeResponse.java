package roomescape.dto;

public record ThemeResponse(
        Long id,
        String name,
        String description,
        String thumbnail
) {
}
