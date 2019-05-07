# Compilation

The goal is to be able to analyze a given language, LEA (Algorithmic Elementary Language) from the imperative programming languages such as C, Pascal ... in order to generate its intermediate code. <br>
The code remains partially implemented. It can be implemented later. This part will generate the code Y86 from the intermediate code.

## Usage

In build.xml file, at line 48, change `<arg value="data/progr9.lea" />` by `<arg value="pathOfProgramToTest" />` where `pathOfProgramToTest` is your program to test.<br><br>
On your terminal run:
```bash
$ ant all
```

## Input example
```Javascript
var
a: integer;

begin
a = 100;
while (a >= 0) do
	begin
	println (a);
	a = a - 1;
	end
end
```
