### hashCode 和 equals 的一些基本约定
HashMap 的性能表现非常依赖于哈希码的有效性，请务必掌握 hashCode 和 equals 的一些基本约定，比如：
- equals 相等，hashCode 一定要相等。
- [重写了 hashCode 也要重写 equals。](https://stackoverflow.com/questions/2265503/why-do-i-need-to-override-the-equals-and-hashcode-methods-in-java)
- hashCode 需要保持一致性，状态改变返回的哈希值仍然要一致。
- equals 的对称、反射、传递等特性。
- [Java hashCode() 和 equals()的若干问题解答](https://www.cnblogs.com/skywang12345/p/3324958.html)

### LinkedHashMap vs TreeMap
- LinkedHashMap 通常提供的是遍历顺序等于插入以及访问顺序，它的实现是通过为条目（键值对）维护一个双向链表。
注意，通过特定构造函数，我们可以创建反映访问顺序的实例，所谓的 put、get、compute 等，
都算作“访问”。
- 对于 TreeMap，它的整体顺序是由键的顺序关系决定的，通过 Comparator 或 Comparable（自然顺序）来决定。
priorityQueue, TreeMap, TreeSet都是基于二叉堆的实现

### hash % table.length vs (n - 1) & hash
hash % table.length is mathematically equivalent to (n - 1) & hash where n = table.length and table.
length is a power of two. 
int index = (n - 1) & hash

### Why hash map need to do the hashkey instead of user xxx.hash()
static final int hash(Object kye) { int h; return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>>16;}

hashcode为int类型，4个字节32位，为了确保散列性，肯定是32位都能进行散列算法计算是最好的。

首先要明白，为什么用亦或计算，二进制位计算，a 只可能为0,1，b只可能为0,1。a中0出现几率为1/2,1也是1/2，b同理。
 - 位运算符有三种，|，&，……，或，与，亦或。
 - a,b进行位运算，有4种可能 00，01,10,11
 - a或b计算 结果为1的几率为3/4,0的几率为1/4
 - a与b计算 结果为0的几率为3/4,1的几率为1/4,
 - a亦或b计算 结果为1的几率为1/2,0的几率为1/2
 
所以，进行亦或计算，得到的结果肯定更为平均，不会偏向0或者偏向1，更为散列。 右移16位进行亦或计算，我将其拆分为两部分，前16位的亦或运算，和后16位的亦或运算， 后16位的亦或运算，即原hashcode后16位与原hashcode前16位进行亦或计算，得出的结果，前16位和后16位都有参与其中，保证了 32位全部进行计算。

### resize
Java7中Hashmap底层采用的是Entry对数组，而每一个Entry对又向下延伸是一个链表，在链表上的每一个Entry对不仅存储着自己的key/value值，还存了前一个和后一个Entry对的地址。Java8中的Hashmap底层结构有一定的变化，还是使用的数组，但是数组的对象以前是Entry对，现在换成了Node对象（可以理解是Entry对，结构一样，存储时也会存key/value键值对、前一个和后一个Node的地址），以前所有的Entry向下延伸都是链表，Java8变成链表和红黑树的组合，数据少量存入的时候优先还是链表，当链表长度大于8，且总数据量大于64的时候，链表就会转化成红黑树，所以你会看到Java8的Hashmap的数据存储是链表+红黑树的组合，如果数据量小于64则只有链表，如果数据量大于64，且某一个数组下标数据量大于8，那么该处即为红黑树。 红黑树的插入、删除、查找各种操作性能都比较稳定。 本质其实是性能问题。哈希碰撞频繁，导致链表过长，查询时间陡升，黑客则会利用这个『漏洞』来攻击服务器，让服务器CPU被大量占用，从而引起了安全问题。 而树化(使用红黑树）能将时间复杂度降到O(logn)，从而避免查询时间过长。所以说，本质还是个性能问题。
