MKDIR d:\project\
cd /d d:\project\
git clone -b spring git@github.com:dmitriiiv/JavaEERepository.git

mysql.exe -u root -p < d:\project\JavaEERepository\scripts\travel.sql

cd /d d:\project\JavaEERepository\
call mvn clean install

cd /d web/target
copy web.war c:\env\apache-tomcat-7.0.63\webapps
cd /d c:\env\apache-tomcat-7.0.63\bin
startup.bat