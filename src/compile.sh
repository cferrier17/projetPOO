cd logger/src2/logger
javac *.java
mv *.class ../../bin

cd ../../../restaurant/src2/restaurant
javac -cp ../../../logger/bin *.java
mv *.class ../../bin