MKDIR d:\project\
cd /d d:\project\
git clone -b feature git@github.com:dmitriiiv/JavaEERepository.git

mysql.exe -u root -p < d:\project\JavaEERepository\scripts\travel.sql

cd /d d:\project\JavaEERepository\
call mvn clean install