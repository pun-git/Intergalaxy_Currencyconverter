
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/18d9c09ad64c488280f1d31f4b11a562)](https://app.codacy.com/app/pun-git/MerchantsGuideToGalaxy?utm_source=github.com&utm_medium=referral&utm_content=pun-git/MerchantsGuideToGalaxy&utm_campaign=Badge_Grade_Dashboard)


Merchant's Guide to the Galaxy
 
You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with 0.01% of the wealth. Luckily, with the scant sum of money that is left in your account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which apparently is worth a lot).
 
Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a program to help you.
 
The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have painstakingly collected the appropriate translation between them.
 
Roman numerals are based on seven symbols:
 
 
Symbol	Value	  
I	1	   
V	5	   
X	10	   
L	50	   
C	100	   
D	500	   
M	1,000	 
 
Numbers are formed by combining symbols together and adding the values. For example, MMVI is 1000 + 1000 + 5 + 1 = 2006. Generally, symbols are placed in order of value, starting with the largest values. When smaller values precede larger values, the smaller values are subtracted from the larger values, and the result is added to the total. For example MCMXLIV = 1000 + (1000 ? 100) + (50 ? 10) + (5 ? 1) = 1944.
 
·	The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) "D", "L", and "V" can never be repeated.
·	"I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.
·	Only one small-value symbol may be subtracted from any large-value symbol.
·	A number written in [16]Arabic numerals can be broken into digits. For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately. Inthe above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.

Pre requisite 

Java sdk 1.8 must be installed and JAVA_HOME must be set
Maven must be installed and mvn command path should be set in PATH enviornment variable.

Note - 
Application will work in unix but can also be made working in windows by updaing setup and Intergalaxy_Currencyconverter bat file for windows


Install
To build the executable jar file
Intergalaxy_Currencyconverter\bin\setup

Execution
To execute the application

To execute command in file
Intergalaxy_Currencyconverter\bin\Intergalaxy_Currencyconverter  <input file which has set of commands>

To execute command throught interactive command line
Intergalaxy_Currencyconverter\bin\Intergalaxy_Currencyconverter  <input file which has st of commands>

Input - Accepted input can be a file or interactive command line.
System consider the test data file if been provided as an command line argument or give interactive command line to provide the input to user.
Test Data
/Intergalaxy_Currencyconverter/input 


Input format - 
1) <currency-name> is <roman number>
example - glob is I
2) <currency-name> <currency-name> <metal-name> is <credit-number> Credits
example - glob glob Silver is 34 Credits
3) how many Credits is <currency-name> <currency-name> <mertal-name> ?
4) how much is <credit-name> <credit-name> <credit-name> ?   

Assumption
1) Focused on design implementation basically follow the input format strictly
2) Metal has been considered as having fixed values which is already known
3) Two type of queries been supported called how much and how many but open for extension

Extensibility -
1) To support new metal type can be added as an ENUM constant in MetalType
2) New currency will automatically be supported when it encounters in input so no change is required
3) To support a different kind of query can be implemented QueryExecutor and also need to update the QueryFactory
4) If need to update format for query only corresponding query implementation need to be updated