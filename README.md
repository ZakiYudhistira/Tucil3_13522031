# Word Ladder Solver
> This is a java implemented word ladder solver, inspired from the word ladder game. This program takes 2 words as an input: a start word and an end word. It then finds the shortest transformation sequence between the two, where each transformation sequence involves with only changing one letter at a time, with the constraint that every intermediate word must be a valid english word

## Table of Contents
* [General Info](#general-information)
* [Technologies Used](#technologies-used)
* [Features](#features)
* [Setup](#setup)
* [How to use](#how-to-use)
* [Room for Improvement](#room-for-improvement)


## General Information
- The program is implemented in java
- You can load your own custom dictionary in txt
- This program is built to implement few path finding algorithm such as : the A*, Greedy BFS, and Uniform Cost Search

## Technologies Used
- Java Version 16.0.2

Few Features:
- Interactive GUI
- Fast runtime
- As long as your system has a JVM, it can run it

## Setup
- Make sure that Java is installed in your computer, with a minimum bersion of JDK 16.02.2
- The program is ran on windows 11, other platform have not been tested yet
- The 'Nunito' font has to be installed

## How to use
1. Run the JAR file, or run the compile.bat batch and then run the run.bat batchf file
2. Choose an algorithm first
3. Enter your first and second word
4. Click the compute button
5. Wait for the result

## Room for Improvement
Room for improvement:
- The memory used could be innacurate since if the program has a cache in the memory, the memory used would be zero since it took the cached state as a starting point