import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class CodingProblemData {
    private   Set<Problem> myProblems = createMyProblems();

    public Set<Problem> getMyProblems() {
        return myProblems;
    }

    private  HashSet<Problem> createMyProblems() {
        /*
        weight update rule:
        1. Initial weight for all question equals to 5
        2. If solved in 10 minutes, bug fee. Minutes weight by 3
        3. If solved in 20 minutes, bug fee. Minutes weight by 2
        4. If solved with small bug . Minutes weight by 1
        5. If solved with IDE debugger. Remain the same.
        6. If do not have any idea or with wrong idea for the problem. Plus weight by 1.
         */
        HashSet<Problem> myProblems = new LinkedHashSet<>();
        myProblems.add(new Problem("ClassicBinarySearch", 5));
        myProblems.add(new Problem("FirstOccurrence", 5));
        myProblems.add(new Problem("LastOccurrence", 5));
        myProblems.add(new Problem("KClosestInSortedArray", 5));
        myProblems.add(new Problem("SearchInSortedMatrix1", 5));
        myProblems.add(new Problem("SearchInUnknownSizeArray", 5));
        myProblems.add(new Problem("BSTKeysInRange", 5));
        myProblems.add(new Problem("InorderTraversalBST", 5));
        myProblems.add(new Problem("IsBalanced", 5));
        myProblems.add(new Problem("IsBST", 5));
        myProblems.add(new Problem("IsIdentical", 5));
        myProblems.add(new Problem("IsSymmetricBinaryTree", 5));
        myProblems.add(new Problem("PreorderTraversalBST", 5));
        myProblems.add(new Problem("Bipartite", 5));
        myProblems.add(new Problem("GetKeysInBinaryTreeLayerByLayer", 5));
        myProblems.add(new Problem("IsCompleteBinaryTree", 5));
        myProblems.add(new Problem("KthSmallestInMatrix", 4));
        myProblems.add(new Problem("AllPermutations1", 5));
        myProblems.add(new Problem("AllPermutations2", 5));
        myProblems.add(new Problem("AllSubsets1", 6));
        myProblems.add(new Problem("AllValidPermutationsOfParentheses1", 5));
        myProblems.add(new Problem("CombinationsOfCoins", 5));
        myProblems.add(new Problem("CombinationSum1", 5));
        myProblems.add(new Problem("CombinationSum2", 5));
        myProblems.add(new Problem("CombinationSum3", 5));
        myProblems.add(new Problem("CombinationSum4", 5));
        myProblems.add(new Problem("KSmallestElementsInArray", 5));
        myProblems.add(new Problem("CheckIfLinkedListHasACycle", 5));
        myProblems.add(new Problem("InsertInLinkedList", 3));
        myProblems.add(new Problem("MergeTwoSortedLinkedLists", 5));
        myProblems.add(new Problem("MiddleNodeOfLinkedList", 2));
        myProblems.add(new Problem("ReOrderLinkedList", 5));
        myProblems.add(new Problem("ReverseLinkedList", 5));
        myProblems.add(new Problem("ReverseLinkedListRecursive", 5));
        myProblems.add(new Problem("AtoThePowerOfB", 5));
        myProblems.add(new Problem("FibonacciNumber", 3));
        myProblems.add(new Problem("ReverseLinkedListRecursive", 5));
        myProblems.add(new Problem("KSmallestElementsInArray_QuickSelect", 5));
        myProblems.add(new Problem("MergeSort", 5));
        myProblems.add(new Problem("QuickSort", 5));
        myProblems.add(new Problem("QuickSortFormalVersion", 5));
        myProblems.add(new Problem("RainbowSort", 5));
        myProblems.add(new Problem("SelectionSort", 5));
        myProblems.add(new Problem("ImplementQueueByTwoStacks", 5));
        myProblems.add(new Problem("SelectionSortWithThreeStacks", 3));
        myProblems.add(new Problem("AllAnagrams", 5));
        myProblems.add(new Problem("Permutation", 5));
        myProblems.add(new Problem("CharDeduplication1", 5));
        myProblems.add(new Problem("CharDeduplication2", 5));
        myProblems.add(new Problem("LongestSubString", 5));
        myProblems.add(new Problem("R emoveParticularCharsFromString", 5));
        myProblems.add(new Problem("RemoveSpaces", 5));
        myProblems.add(new Problem("StringReplace", 5));
        myProblems.add(new Problem("DecompressString2", 5));
        myProblems.add(new Problem("DecompressString2", 5));
        return myProblems;
    }

    public class Problem {
        public String name;
        public int weight;
        Problem(String name, int weight) {
            this.name  = name;
            this.weight = weight;
        }
    }
}
