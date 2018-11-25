rm -r logger/bin
mkdir logger/bin
javac -d logger/bin $(find logger/src -name *.java)

rm -r restaurant/bin
mkdir restaurant/bin
javac -classpath logger/bin -d restaurant/bin $(find restaurant/src -name *.java)

# rm -r testframework/bin
# mkdir testframework/bin
# javac -classpath logger/bin:restaurant/bin -d testframework/bin $(find testframework/src -name *.java)
