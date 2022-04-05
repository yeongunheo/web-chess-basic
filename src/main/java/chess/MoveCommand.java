package chess;

import java.util.Objects;

public final class MoveCommand {

    private final Position from;

    private final Position to;

    private MoveCommand(final Position from, final Position to) {
        this.from = from;
        this.to = to;
    }

    public static MoveCommand of(final String value) {
        final var splitValue = value.split(",|%2C");
        final var from = Position.of(splitValue[0]);
        final var to = Position.of(splitValue[1]);

        return new MoveCommand(from, to);
    }

    public Position from() {
        return from;
    }

    public Position to() {
        return to;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final MoveCommand that = (MoveCommand) o;
        return Objects.equals(from, that.from) && Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return "MoveCommand{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
