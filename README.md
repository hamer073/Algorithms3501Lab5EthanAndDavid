# Algorithms 3501 Lab 5
Authors: Ethan Hammer and David Chong\
Completed: 10/18

Explain why the algorithm is correct
-


Find efficiency of the algorithm
-
θ(n/2) + θ((n^2-n)/4) + O(n/2) + θ((n^2-n)/4) + O((2n^3-2n^2)/2) = O(n^3-((n^2+n)/2)+n)

Notes
-
10/5/18 - May have a problem with use of modulo in company.java. 
Could be causing infinite loop with certain data sets like that used in test.java.