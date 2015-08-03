MKDIR d:\project\
cd /d d:\project\
git clone -b develop git@github.com:dmitriiiv/JavaEERepository.git

mysql.exe -u root -p < d:\project\JavaEERepository\scripts\travel.sql

cd /d d:\project\JavaEERepository\
call mvn clean install

cd dao\target\
java -jar dao-1.0.jar