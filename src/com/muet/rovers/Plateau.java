package com.muet.rovers;

public class Plateau {
  private final Position topRight;

  public Plateau(Position topRight) {
    this.topRight = topRight;
  }

  public boolean contains(Position pos) {
    return pos.x >= 0 && pos.y >= 0  && pos.x <= topRight.x && pos.y <= topRight.y;
  }
}

