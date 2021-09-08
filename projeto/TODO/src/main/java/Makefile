ifeq ($(OS),Windows_NT)
    RM = cmd //C del //Q //F
else
    RM = rm
endif

all:
	javac TODO/*.java
	jar cfve TODO.jar TODO.MainWindow TODO/*.class

clean:
	$(RM) TODO.jar
	$(RM) TODO/*.class

