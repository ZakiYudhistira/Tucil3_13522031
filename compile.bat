@ECHO OFF
javac --release 16 -d ./bin ./src/DataStructs/Path.java -cp ./bin
javac --release 16 -d ./bin ./src/DataStructs/ArrayRet.java -cp ./bin
javac --release 16 -d ./bin ./src/DataStructs/Return.java -cp ./bin
echo DataStructs Succesfully compiled

javac --release 16 -d ./bin ./src/Algorithm/NodeProcessing.java -cp ./bin
javac --release 16 -d ./bin ./src/Algorithm/Compute.java -cp ./bin

javac --release 16 -d ./bin ./src/Algorithm/Astar.java -cp ./bin
javac --release 16 -d ./bin ./src/Algorithm/GreedyBfs.java -cp ./bin
javac --release 16 -d ./bin ./src/Algorithm/UCS.java -cp ./bin
echo Algorithm Succesfully compiled

javac --release 16 -d ./bin ./src/Util/Loader.java -cp ./bin
javac --release 16 -d ./bin ./src/Util/Run.java -cp ./bin

javac --release 16 -d ./bin ./src/GUI/Frame.java -cp ./bin

javac --release 16 -d ./bin ./src/Main.java -cp ./bin
echo Main Succesfully compiled
echo =========================
echo You can now run the 'run.bat' file