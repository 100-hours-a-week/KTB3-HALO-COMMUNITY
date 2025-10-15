package springboot.kakao_boot_camp.global.dto;

public record CursorInfo(
        boolean hasNext,
        Long nextCursor,
        int size
) {
    public static CursorInfo of(boolean hasNext, Long nextCursor, int size) {
        return new CursorInfo(hasNext, nextCursor, size);
    }
}
