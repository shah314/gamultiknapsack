#!/bin/bash -v
mkdir testing1
cd testing1
cp ../../java/*.java .
cp ../data.DAT .
javac *.java
java GeneticAlgorithm data.DAT weing
