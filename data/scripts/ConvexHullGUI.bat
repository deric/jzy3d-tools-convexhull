@echo off
if exist convexhull\gui\*.class del convexhull\gui\*.class
@echo on
javac -Xlint @pakkaukset.txt convexhull/gui/*.java
@echo off


@echo off
if exist convexhull\gui\*.class java -cp .; convexhull.gui.ConvexHullGUI
pause