Beau Goldberg

1.) There are two possible cases for running into duplicates. The first being duplicates in the same array in which you
can check if the number you just popped off of the tree is equal to the next number to be inserted. The other case 
is a duplicate in the other array in which you can check if the key you are inserting is already in the tree using the 
.contains() method. This works because we are assuming it will not remove a key until it is the smallest value in both 
arrays. Also because they are sorted you are guaranteed to not remove a key before its duplicate.

2.) Both N & k scale logarithmically in the test cases.