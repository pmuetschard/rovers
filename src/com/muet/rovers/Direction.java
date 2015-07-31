package com.muet.rovers;

public enum Direction {
  N(0, 1) {
    @Override
    public Direction left() {
      return W;
    }

    @Override
    public Direction right() {
      return E;
    }
  }, E(1, 0) {
    @Override
    public Direction left() {
      return N;
    }

    @Override
    public Direction right() {
      return S;
    }
  }, S(0, -1) {
    @Override
    public Direction left() {
      return E;
    }

    @Override
    public Direction right() {
      return W;
    }
  }, W(-1, 0) {
    @Override
    public Direction left() {
      return S;
    }

    @Override
    public Direction right() {
      return N;
    }
  };

  public final int dx;
  public final int dy;

  private Direction(int dx, int dy) {
    this.dx = dx;
    this.dy = dy;
  }

  public abstract Direction left();
  public abstract Direction right();
}

