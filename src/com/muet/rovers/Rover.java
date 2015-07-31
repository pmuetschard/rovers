package com.muet.rovers;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

import java.io.IOException;

public class Rover {
  private final Plateau plateau;
  private Position position;
  private Direction direction;

  public Rover(Plateau plateau, Position position, Direction direction) {
    checkArgument(plateau.contains(position), "Invalid starting position: %s", position);
    this.plateau = plateau;
    this.position = position;
    this.direction = direction;
  }

  public void turnLeft() {
    direction = direction.left();
  }

  public void turnRight() {
    direction = direction.right();
  }

  public void moveForward() {
    Position newPosition = position.neighbor(direction);
    checkState(
        plateau.contains(newPosition), "Received move command to go out of bounds: %s", this);
    position = newPosition;
  }

  public Appendable appendTo(Appendable out) throws IOException {
    out.append(Integer.toString(position.x))
        .append(' ').append(Integer.toString(position.y))
        .append(' ').append(direction.name());
    return out;
  }

  @Override
  public String toString() {
    return "[Rover at " + position + " facing " + direction + "]";
  }
}

