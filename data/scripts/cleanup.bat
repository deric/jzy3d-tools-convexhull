@echo off

echo Poistaa class-paatteiset tiedostot
echo Nain varmistuu, etta aina kaannetaan uutta koodia

cd convexhull
svn delete *.class --force 
cd gui
svn delete *.class --force 
cd..
cd..

cd test
svn delete *.class --force 
cd..

cd utils
svn delete *.class --force 
cd..

cd algorithms
svn delete *.class --force  
cd..

cd io
svn delete *.class --force  
cd..

if exist testituloste.txt svn delete testituloste.txt --force

pause