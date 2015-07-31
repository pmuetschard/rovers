#!/bin/bash

mkdir -p bin
find src -name "*.java" | xargs javac -d bin -cp $GUAVA
java -cp $GUAVA:bin com.muet.rovers.Mission <<EOF
5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
EOF

