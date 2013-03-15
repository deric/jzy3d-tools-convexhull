
@echo off
if %1==all goto all
if %1==graham goto graham
if %1==jarvis goto jarvis
if %1==compile goto compile
if %1==stack goto stack
if %1==performance goto performance

echo --------------------------------
echo Use Command-Line Options for testing ConvexHull:
echo test all
echo test compile
echo test graham
echo test jarvis
echo test stack
echo test performance
echo --------------------------------
goto done

:all
echo Not supported yet.
goto done

:compile
if exist test\*.class del test\*.class
javac -Xlint @pakkaukset.txt @testit.txt
goto done

:performance
java -cp .; -ea test.TestPerformance > out.txt
goto done

:graham
java -cp .; -ea test.TestGrahamScan
goto done

:radial
if exist out.txt del out.txt
java -cp .; -ea test.TestRadialComparator > out.txt
goto done

:converter
java -cp .; -ea test.TestConverter
goto done

:xycomparator
java -cp .; -ea test.TestXYComparator > out.txt
goto done

:jarvis
java -cp .; test.TestJarvisMarch
goto done

:stack
java -cp .; -ea  test.TestStack
goto done

:sort
java -cp .; test.TestQuickSort
goto done

:datareader
java -cp .; test.TestDataReader
goto done

:done
pause