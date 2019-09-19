#!/bin/bash -v
mkdir testing1
cd testing1
cp ../../java/*.java .
cp ../data.DAT .
javac *.java
java GeneticAlgorithm
cd ..
rm testing1/*.java
rm testing1/*.class
rm testing1/data.DAT
rmdir testing1
