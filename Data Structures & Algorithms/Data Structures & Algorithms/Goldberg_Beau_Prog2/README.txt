/******************************************************************************
 *  Name:     Beau Goldberg
 *
 *  Hours to complete assignment (optional): 20 hrs
 *
 ******************************************************************************/

Programming Assignment 3: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
 My firsstIndexOf() method begins by checking if the middle key in the array is less than, greater than or equal to.
 If it is less than then it will split the lower half of the array and if it is higher it will split the upper half.
 Once it finds a key in the array that is equal to search key it will go into a loop where it will check one at a time
 the indexes to the left of the first key and see if they are also equal to the search key. Once it sees that the left 
 index is no longer equal to the search key or it hits the beginning of the array it will mark how many indexes over from 
 the original search key it iterated through to find the first key and add subtract that number from the mid value to get 
 the first index in the array.

/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: NlogN

allMatches(): NlogN

numberOfMatches(): constant 


/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
 No known bugs or limitations.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
I meet with Kellen Donahue to discuss the end goal of the project so i could get a better idea of exactly i was shooting
for in my functionality. Once i had a better grasp of what i was shooting for i was able to get the majority of the project
done until i hit some bugs at the end. I meet with my friend Seth Hovenkotter and he taught me how to use the debugger in 
eclipse so i could see step by step what was going on in my code so i could solve my remaining problems.

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
I had an issue in my term functionality where if a key was to short to make a substring i was getting a index out of bounds
exception and the program would crash. Once i figured out that i needed to set up some checks to determine if the 
string was long enough to be substringed i ran into another error that i found with the debugger. For some reason when 
I had a check to see if the terms compared was equal to zero it was never going into that option and i honestly don't really 
know why. I saw though that since my two other checks were for all terms other than zero instead of having a specific check
i could just make it the else option and then it started to take that path. That was a big error because it didn't return 
an error it would just give me the wrong output. So i used print statements to find that it was getting stuck in that chunk
of code then used the debugger to see that it never entered that check statement. It took me quite awhile to solve that one 
problem but once i did it was really the only thing holding back my program.


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/

