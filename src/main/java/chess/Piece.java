package chess;

import java.util.Objects;

public final class Piece {

    private final Color color;

    public Piece(final Color color) {
        this.color = color;
    }

    public String getColor() {
        return color.name();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Piece piece = (Piece) o;
        return color == piece.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    @Override
    public String toString() {
        return "Piece{" +
                "color=" + color +
                '}';
    }
}
