#! /bin/sh
javac -sourcepath src -d bin -cp bin src/serveur/*.java
javac -sourcepath src -d bin -cp bin src/client/*.java

rmic -classpath bin -d bin serveur.MonObjetAccessibleDistance

export CLASSPATH=/hometu/etudiants/b/a/E145773Z/rmitmp/rmi/bin/:$CLASSPATH

rmiregistry &

java -cp bin -Djava.security.policy=client.policy -Djava.rmi.server.codebase="file:///hometu/etudiants/b/a/E145773Z/rmitmp/rmi/bin" serveur.TestServeurRmi
