ifeq ($(OS),Windows_NT)
    RM = del /s
else
    RM = rm -r
endif

all:
	javac TODO/*.java
	jar cfve TODO.jar TODO.MainWindow TODO/*.class

clean:
	$(RM) TODO.jar
	cd TODO; $(RM) *.class

