# Algorithms 3501 Lab 5
Authors: Ethan Hammer and David Chong\
Completed: 10/18

Running MakeSatisfactory
-
There are three TestData.txt files as examples for setting up the data. Names are allowed to be any length within java's limitations 
* Line one contains how many companies/programmers you have. If you have 3 companies and three programmers then the first line should be three
  * Note that you must have an equal number of companies and programmers for the program to run correctly
* The next n lines (where n is the first number that you give) should be the name of the first company followed by a space and then their programmer preferences in descending order with a space between each programmer
  * For example for company A with preferences 1 3 2 the line would look like: A 1 3 2
* After all of the companies are input then you do the same with the programmers.
  * NOTE the names must be spelled EXACTLY the same otherwise the preferences the program gets will be incomplete.
  
Then compile MakeSatisfactory.java, Bin.java, Company.java, and Programmer.java (If you want a simple example of the program working with the example given in the lab pdf of companies and programmers compile Test.java as well)
<br>
Then to run call MakeSatisfactory with the full path to a text file with your company and programmer information
* For example from the command line to run on TestData.txt you'd call java MakeSatisfactory Path/To/TestData/TestData.txt
<br>

Explain why the algorithm is correct
-
Our algorithm works by first giving each company their first choice of programmer. This allows for the best case where they get their first choice.
<br>
 Then we check for any duplicates. If their are any, we give the second company of the duplicate pair their next choice in programmer. If we get to the end of their choices we go back to giving them the first choice. We then repeat this until there are no duplicates.
 <br>
  Then we check if the pairings are satisfactory. If they are then we just return them. Otherwise we swap the pairings that aren't satisfactory and check them again since the pairings have changed.
   Since a particular unsatisfactory pairing can't go back to it's original unsatisfactory combination after being updated to be satisfactory, even if we end up changing all of them multiple times we will eventually hit a satisfactory pairing and stop, since there is guaranteed to be at least one satisfactory combination.
   The pairings can't go back to unsatisfactory in the same way because once we swap programmers in an unsatisfactory combination to a satisfactory one our code doesn't allow for those programmers to be swapped back into an unsatisfactory combination.

Find efficiency of the algorithm
-
θ(n/2) + θ((n^2-n)/4) + O(n/2) + θ((n^2-n)/4) + O((2n^3-2n^2)/2) = O(n^3-((n^2+n)/2)+n)
