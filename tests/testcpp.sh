#!/bin/bash -v
mkdir testing1
cd testing1
cp ../../*.cpp .
cp ../data.DAT .
g++ *.cpp
./a.out
cd ..
rm testing1/*.cpp
rm testing1/*.out
rm testing1/data.DAT
rmdir testing1
