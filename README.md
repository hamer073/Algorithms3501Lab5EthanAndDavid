# Algorithms 3501 Lab 5
Authors: Ethan Hammer and David Chong\
Completed: 10/18

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
