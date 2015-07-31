package com.muet.rovers;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.common.base.Function;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;

import java.util.List;

public class Parser {
  private Parser() {
  }

  public static Plateau parsePlateau(String line) {
    List<String> tokens = tokenize(line);
    checkArgument(tokens.size() == 2, "Expected two space separated values: got %s", line);
    return new Plateau(parsePosition(tokens, 0));
  }

  public static Rover parseRover(Plateau plateau, String line) {
    List<String> tokens = tokenize(line);
    checkArgument(tokens.size() == 3, "Expected three space separated values: got %s", line);
    return new Rover(plateau, parsePosition(tokens, 0), Direction.valueOf(tokens.get(2)));
  }

  public static Iterable<Command> parseCommands(String line) {
    return Iterables.transform(
        Splitter.fixedLength(1).split(line), new Function<String, Command>() {
      @Override
      public Command apply(String input) {
        switch (input.toUpperCase()) {
          case "L": return Command.TURN_LEFT;
          case "R": return Command.TURN_RIGHT;
          case "M": return Command.MOVE_FORWARD;
          default: throw new IllegalArgumentException("Invalid move command: " + input);
        }
      }
    });
  }

  private static List<String> tokenize(String line) {
    return Splitter.on(' ').omitEmptyStrings().splitToList(line);
  }

  private static Position parsePosition(List<String> tokens, int offset) {
    try {
      return new Position(
          Integer.parseInt(tokens.get(offset + 0)), Integer.parseInt(tokens.get(offset + 1)));
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("Expected two integers: got " + tokens, e);
    }
  }
}

