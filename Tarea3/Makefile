compileEnemigo: thelegendofmorio/enemigo
	javac thelegendofmorio/enemigo/*.java
compileJugador: thelegendofmorio/jugador
	javac thelegendofmorio/jugador/*.java
compileMision: thelegendofmorio/mision
	javac thelegendofmorio/mision/*.java
compileNPC: thelegendofmorio/npc
	javac thelegendofmorio/npc/*.java
compileTierra: thelegendofmorio/tierra
	javac thelegendofmorio/tierra/*.java
compileUtils: thelegendofmorio/utils
	javac thelegendofmorio/utils/*.java
	
compile: Main.java compileEnemigo compileJugador compileMision compileNPC compileTierra compileUtils
	javac Main.java
run: Main.class
	java Main


clearWIN:
	DEL *.class && DEL */*.class && DEL */*/*.class


clearEnemigo:
	rm thelegendofmorio/enemigo/*.class
clearJugador:
	rm thelegendofmorio/jugador/*.class
clearMision:
	rm thelegendofmorio/mision/*.class
clearNPC:
	rm thelegendofmorio/npc/*.class
clearTierra:
	rm thelegendofmorio/tierra/*.class
clearUtils:
	rm thelegendofmorio/utils/*.class
clear: clearEnemigo clearJugador clearMision clearNPC clearTierra clearUtils
	 rm *.class