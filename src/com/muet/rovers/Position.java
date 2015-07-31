package com.muet.rovers;

public class Position {
  public final int x;
  public final int y;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Position neighbor(Direction dir) {
    return new Position(x + dir.dx, y + dir.dy);
  }

  @Override
  public String toString() {
    return "[" + x + ", " + y + "]";
  }
}

