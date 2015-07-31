package com.muet.rovers;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Mission {
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in, UTF_8));
    Writer out = new OutputStreamWriter(System.out, UTF_8); 

    Plateau plateau = Parser.parsePlateau(
        checkNotNull(in.readLine(), "Early EOF, expected plateau definition"));
    String line;
    while ((line = in.readLine()) != null) {
      Rover rover = Parser.parseRover(plateau, line);
      Iterable<Command> commands = Parser.parseCommands(
          checkNotNull(in.readLine(), "Early EOF, expected move commands"));
      for (Command command : commands) {
        command.execute(rover);
      }
      rover.appendTo(out).append('\n');
    }
    out.flush();
  }
}
