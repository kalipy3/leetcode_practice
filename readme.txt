readme.txt

:Author: kalipy
:Email: kalipy@debian
:Date: 2021-08-03 10:50


java -Xdebug -Xrunjdwp:transport=dt_socket,address=8888,server=y,suspend=y  -cp ./ MainClass215

jdbshell -attach 8888 -sourcepath ./.
