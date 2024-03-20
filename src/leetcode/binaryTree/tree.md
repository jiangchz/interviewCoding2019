*** binary search tree
1. ordered/sorted binary tree
2. Nodes can have 2 subtrees
3. items to the left of a given node are smaller
4. items to the right of a given node are larger

*** balanced search tree
guaranteed height of O(log n) for n items

### red-black tree (a special version of balanced binary search tree)
1. A node is either red or black
2. The root and leaves and null are black
3. if a node is red, then its children are black
4. all path from its null descendants contain the same number of black nodes
5. Nodes require one storage bit to keep track of the color
6. The longest path (root to farthest null) is no more than twice the length of the shortest path (root to nearest null)
- shortest path: all black nodes 
- longest path: alternating red and black 

operations:
search  O(logn)
insertion -require rotation  O(logn)
remove - require rotation  O(logn)
