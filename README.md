# wc-tool

## Description
This tool is written in Java. It's used to count the number of bytes, lines, 
words & characters in a file or standard input.

## Build
Clone the project and build the Jar.
You will find the Jar named `wc-tool-0.0.1.jar` in target folder.

## Example Usage
You can either create an executable Jar or use as it is using below commands.
```text
java -cp <your_path>/wc-tool-0.0.1.jar com.challenge.wc.wcMain ccwc [option] test.txt

option:
-l = count number of lines
-c = count number of bytes
-w = count number of words
-m = count number of characters


java -cp <your_path>/wc-tool-0.0.1.jar com.challenge.wc.wcMain ccwc test.txt
```

You can also use it by taking input from standard input as follows.
```text
cat <fileName> | java -cp <your_path>/wc-tool-0.0.1.jar com.challenge.wc.wcMain ccwc [option]
cat <fileName> | java -cp <your_path>/wc-tool-0.0.1.jar com.challenge.wc.wcMain ccwc
```




