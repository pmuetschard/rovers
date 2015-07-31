package com.muet.rovers;

public interface Command {
  Command TURN_LEFT = new Command() {
    @Override
    public void execute(Rover rover) {
      rover.turnLeft();
    }
  };

  Command TURN_RIGHT = new Command() {
    @Override
    public void execute(Rover rover) {
      rover.turnRight();
    }
  };

  Command MOVE_FORWARD = new Command() {
    @Override
    public void execute(Rover rover) {
      rover.moveForward();
    }
  };

  void execute(Rover rover);
}

