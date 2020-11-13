A.) An easy way to sort the two arrays in linearithmic time can be accomplished by heap sorting the two arrays. It also takes
constant extra space because you don't have to use any extra space after you sort the array.

B.) To compare the arrays in linear time you can use a seperate chaining hash table, because you only have to iterate through
the inputs and that is accomplished in linear time with linear extra space because the size of the hash table will grow linearlly
with the input as you insert the keys.

a.) Yes they work
b.) Using 100A and 100B it ran in .02s
    Using 1mA and 1mB it ran in 2.5s for hash and 3.7s for heap
    
c.) The impact of collision is that it makes it more difficult to keep track of what entries were put into the hash. So
having detection is very important to getting complete record of the data and minimizes the size of the underlying array 
by allowing you to override instead of adding a new index. 