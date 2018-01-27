# How to Install Oracle JDBC To repo maven
## find odbc7.jar in your project and run command below
Note : -Dfile must be path to ojdbc7.jar

$ mvn install:install-file -Dfile=E:\\22\\ojdbc7.jar -DgroupId=com.oracle -DartifactId=ojdbc7 -Dversion=12.1.0 -Dpackaging=jar 


