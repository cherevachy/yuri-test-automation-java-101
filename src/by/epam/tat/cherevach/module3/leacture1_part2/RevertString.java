package by.epam.tat.cherevach.module3.leacture1_part2;

import java.lang.*;
import java.io.*;

public class RevertString {

public static String Revert(String str1) throws IOException {
		 
String userInput = str1;
String revert = "";
String gap = " ";
int j = userInput.length();
int gapIndex = userInput.lastIndexOf(gap);	
	
j = userInput.length();
gapIndex = userInput.lastIndexOf(gap);
do{
revert += userInput.substring(gapIndex, j);
j = gapIndex;
userInput = userInput.substring(0, gapIndex);
gapIndex = userInput.lastIndexOf(gap);
if(gapIndex == -1){
revert += " " + userInput.substring(0, j);
}
}while(gapIndex != -1);

return revert;
}

}