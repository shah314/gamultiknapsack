#!/bin/bash -v
mkdir testing1
cd testing1
cp ../../*.cpp .
cp ../data.DAT .
g++ *.cpp
./a.out data.DAT weing
