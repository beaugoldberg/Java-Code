/******************************************************************************
 *  Name: Beau Goldberg
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 3: WordNet


/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in synsets.txt. Why did you make this choice?
 *****************************************************************************/
 I used a Red-Black BST to store the synsets. The BST is effective because it allows the storage of the synset with
 the key and the corresponding value. Using the BST also allows the use of all its functionality which is helpful in 
 implementing the wordnet. Using the .contains() method, we can tell easily if the tree contains a noun that we are 
 looking for. It also allowed for simple use in the Iterable method of wordnet to simply return tree.keys() because it 
 is an iterable that has all of the methods we need to inherit to implement the program.


/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in hypernyms.txt. Why did you make this choice?
 *****************************************************************************/
 I used a Digraph to store the information for the hypernyms. This was preffered because it shows all of the 
 relationships between the hypernyms simply and allows for easy use of those hypernyms through its methods.


/******************************************************************************
 *  Describe concisely the algorithm you use in the constructor of
 *  ShortestCommonAncestor to check if the digraph is a rooted DAG.
 *  What is the order of growth of the worst-case running times of
 *  your algorithms as a function of the number of vertices V and the
 *  number of edges E in the digraph?
 *****************************************************************************/

Description: To check if the digraph was acyclic I used the class DirectedCycle from the algs4 file because it 
allows the simple call of hasCycle() to determine if there is a cycle in the digraph and if there is than an error 
is thrown. To check if the digraph was rooted I iterated through every vertex in the digraph and  checked to see 
many vertexes were adjacent to each vertex. If there is a vertex with no adjacent nodes then a counter was increased 
by one. The reason this is effective in determining if the graph is rooted is because only the root of the graph should
have no adjacent vertices and there should only be one root, so by simply running that method and then checking if the 
counter was equal to one would be enough to know if the digraph was rooted or not. If the counter is anything other
than one then an error is thrown.

Order of growth of running time: The root method has a linear run time because it goes through and checks every node for adjacent nodes
but the adj() call is in constant time so it only grows linearly. The directed cycle method hasCycle() has a runtime equivalent
to depth first search so it runs in proportional to V+E.


/******************************************************************************
 *  Describe concisely your algorithm to compute the shortest common
 *  ancestor in ShortestCommonAncestor. For each method, what is the order of
 *  growth of the worst-case running time as a function of the number of
 *  vertices V and the number of edges E in the digraph? For each method,
 *  what is the order of growth of the best-case running time?
 *
 *  If you use hashing, you should assume the uniform hashing assumption
 *  so that put() and get() take constant time.
 *
 *  Be careful! If you use a BreadthFirstDirectedPaths object, don't
 *  forget to count the time needed to initialize the marked[],
 *  edgeTo[], and distTo[] arrays.
 *****************************************************************************/

Description:
My algorithm to compute the shortest common ancestor is the same process of the breadth first directed paths method
but with some changes. I used the same queue implementation to perform the breadth first search but instead of keeping 
all of the arrays neccesary for the breadth first search i just used a ArrayList data structure and inserted the vertexes 
that the breadth first search went through when searching through the digraph. That way it began was by finding the root of
the first vertex put into the method and inserted all vertexes it visited into the arraylist. Then when it goes through to 
find the root for the second vertex inputed it will check vertex by vertex if the vertex it runs into is in the arraylist from 
the first breadth first search. If the check returns true, then it returns that vertex because that is the first node that 
the two have in common therefore the shortest common ancestor.

                                              running time
method                               best case            worst case
------------------------------------------------------------------------
length(int v, int w)				(O) Vertices reachable from input {same for both}

ancestor(int v, int w)				(O) Vertices reachable from input {same for both}

length(Iterable<Integer> v,			(O) Vertices reachable from all input vertices {same for both}
       Iterable<Integer> w)

ancestor(Iterable<Integer> v,		(O) Vertices reachable from all input vertices {same for both}
         Iterable<Integer> w)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
 No known bugs or limitations.

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, but do include any 
 *  help from people (including course staff, TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
 I met with Cole Brooks to discuss the project conceptually and figure out exactly what it is that we were trying to 
 accomplish with each class that we were to implement. I've found that without discussing the project with someone i 
 have an incredibly difficult time determining where exactly to start but Cole was very helpful on guiding me with 
 questions and pushing me in the right direction and once i got the ball rolling the rest fell into place without 
 to much difficulty.

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
 It was difficult to figure out how exactly to set up the shortest common ancestor method but after discussing with Cole (Cole Brooks)
 on how the search exactly worked (i was still a little confused on how exactly breadth first search went up the digraph
 to the root, he walked me through the code of breadth first search from the lectures step by step) it was easy to see 
 that a data structure like an ArrayList would be of great use in this situation to hold the information that the vertex
 indexed arrays did but without having to use any vertex indexed arrays. It is also preferable to a linked list for 
 example because it has indexing and can change size instead of in the linked list you would be unable to access indexes
 in a linked list. The implementation was rather simple after that.


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
 I was a little iffy on some of the information we have been going over in the last couple weeks but this assignment was 
 really good at covering all that and i feel like i have a better understanding from doing this assignment. It was tough
 but well worth it. Was proud of myself when i got it to work.