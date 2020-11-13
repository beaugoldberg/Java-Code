Linear Probing
---------------
For N=1000
Average Number of Probes = ~4

For N=10000
Average Number of Probes = ~3

For N=100000
Average Number of Probes = ~3

For N=1000000
Average Number of Probes = ~2.5

Since we are using 1/2 the size of the list, if you plug 1/2 into the equation given in the book for search misses
 you get ~2.5 which is exactly what the average number of probes was converging to during my trials.
 
 
 BST
 ------------
 N        Mean         Standard Deviation
 100	  5			   .578
 200	  7			   .598
 400	  8			   .588
 800	  10	       .641
 1600	  11		   .676
 3200	  12		   .662
 6400	  14		   .639
 12800	  15		   .637