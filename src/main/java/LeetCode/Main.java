package LeetCode;

import LeetCode.Arrays.MergeIntervals;
import LeetCode.DynamicProgramming.Knapsack;
import LeetCode.DynamicProgramming.MatrixChainMultiplication;
import LeetCode.Graphs.*;
import LeetCode.Recursion.*;
import LeetCode.StacksAndQueues.CelebrityProblem;
//import LeetCode.StacksAndQueues.LFUCache;
import LeetCode.StacksAndQueues.MaxOfMinOfEveryWindow;
import LeetCode.StacksAndQueues.MinStack;
import LeetCode.StacksAndQueues.SlidingWindowMaximum;
import LeetCode.Strings.CountAndSay;
import LeetCode.Strings.RepeatedStringMatch;
import LeetCode.Tree.CreateBSTFromPreOrder;
import LeetCode.Tree.CreateTreeFromPreOrderAndInOrderTraversal;
import LeetCode.Tree.MaxSumBST;
import LeetCode.Tree.Nodes.TreeNode;
import LeetCode.Tree.SerializeDeserializeBinaryTree;
//import LeetCode.Tree.PredecessorAndSuccessor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        RepeatedStringMatch repeatedStringMatch = new RepeatedStringMatch();
        repeatedStringMatch.repeatedStringMatch("abcd", "cdabcdab");

//        SudokuSolver sudokuSolver = new SudokuSolver();
//        char[][] board = {
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        };
//        sudokuSolver.solveSudoku(board);
//        System.out.println();


//        MaxOfMinOfEveryWindow maxOfMinOfEveryWindow = new MaxOfMinOfEveryWindow();
//        System.out.println(maxOfMinOfEveryWindow.maxMinWindow(new int[]{3, 7, 5, 6, 1, 8, 4, 2, 10}, 9));
//        System.out.println(maxOfMinOfEveryWindow.maxMinWindow(new int[]{45, -2, 42, 5, -11}, 5));
//        System.out.println(maxOfMinOfEveryWindow.maxMinWindow(new int[]{-2, 12, -1, 1, 20, 1}, 6));

//        CountAndSay countAndSay = new CountAndSay();
//        countAndSay.countAndSay(5);

//        Knapsack knapsack = new Knapsack();
//        System.out.println(knapsack.knapSack(4, new int[]{4, 5, 1}, new int[]{1, 2, 3}, 3));

//        MatrixChainMultiplication matrixChainMultiplication = new MatrixChainMultiplication();
//        System.out.println(matrixChainMultiplication.matrixMultiplication(5, new int[]{40, 20, 30, 10, 30}));

//        BridgesInGraph bridgesInGraph = new BridgesInGraph();
//        List<List<Integer>> connections = new ArrayList<>();
//        connections.add(List.of(0, 1));
//        connections.add(List.of(1, 2));
//        connections.add(List.of(2, 0));
//        connections.add(List.of(1, 3));
//        bridgesInGraph.criticalConnections(4, connections);

//        StronglyConnectedComponents stronglyConnectedComponents = new StronglyConnectedComponents();
//        List<List<Integer>> adj = new ArrayList<>();
//        adj.add(List.of(2, 3));
//        adj.add(List.of(0));
//        adj.add(List.of(1));
//        adj.add(List.of(4));
//        adj.add(List.of());
//        stronglyConnectedComponents.kosaraju(5, adj);



//        MSTPrimsAlgorithm mstPrimsAlgorithm = new MSTPrimsAlgorithm();
//        int[][] coordinates = new int[5][2];
//        coordinates[0] = new int[]{0, 0};
//        coordinates[1] = new int[]{2, 2};
//        coordinates[2] = new int[]{3, 10};
//        coordinates[3] = new int[]{5, 2};
//        coordinates[4] = new int[]{7, 0};
//        System.out.println(MSTPrimsAlgorithm.minCostConnectPoints(coordinates));

//        Dijkstra dijkstra = new Dijkstra();
//        int[][] edges = new int[3][3];
//        edges[0] = new int[]{2, 1, 1};
//        edges[1] = new int[]{2, 3, 1};
//        edges[2] = new int[]{3, 4, 1};
//        dijkstra.networkDelayTime(edges, 4, 2);

//        MGraphColoring mGraphColoring = new MGraphColoring();
//        boolean[][] graph = new boolean[5][5];
//        graph[0][4] = true;
//        graph[2][4] = true;
//        graph[3][4] = true;
//        graph[4][0] = true;
//        graph[4][2] = true;
//        graph[4][3] = true;
//        mGraphColoring.graphColoring(graph, 1, 4);

//        boolean[][] graph = new boolean[4][4];
//        graph[0] = new boolean[]{false, true, true, true};
//        graph[1] = new boolean[]{true, false, true, false};
//        graph[2] = new boolean[]{true, true, false, true};
//        graph[3] = new boolean[]{true, false, true, false};
//        mGraphColoring.graphColoring(graph, 3, 4);


//        NQueens nQueens = new NQueens();
//        System.out.println(nQueens.solveNQueens(4));


//        MergeIntervals mergeIntervals = new MergeIntervals();
//        int[][] intervals = new int[4][2];
//        intervals[0] = new int[]{1, 3};
//        intervals[1] = new int[]{2, 6};
//        intervals[2] = new int[]{8, 10};
//        intervals[3] = new int[]{15, 18};
//        mergeIntervals.merge(intervals);


//        SerializeDeserializeBinaryTree serializeDeserializeBinaryTree = new SerializeDeserializeBinaryTree();
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
//        String t = serializeDeserializeBinaryTree.serialize(root);
//        serializeDeserializeBinaryTree.deserialize(t);

//        MaxSumBST maxSumBST = new MaxSumBST();
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(2);
//        root.right.right = new TreeNode(5);
//        root.right.right.left = new TreeNode(4);
//        root.right.right.right = new TreeNode(6);
//        MaxSumBST maxSumBST = new MaxSumBST();
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(2);
//        System.out.println(maxSumBST.maxSumBST(root));

//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(15);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(6);
//        PredecessorAndSuccessor predecessorAndSuccessor = new PredecessorAndSuccessor();
//        List<List<Integer>> result = predecessorAndSuccessor.closestNodes(root, List.of(7, 5, 12, 17, 0));
//        System.out.println(0);

//        LFUCache lfuCache = new LFUCache(2);
//        lfuCache.put(1, 1);
//        lfuCache.put(2, 2);
//        System.out.println(lfuCache.get(1));
//        lfuCache.put(3, 3);
//        System.out.println(lfuCache.get(2));
//        System.out.println(lfuCache.get(3));
//        lfuCache.put(4, 4);
//        System.out.println(lfuCache.get(1));
//        System.out.println(lfuCache.get(3));
//        System.out.println(lfuCache.get(4));



//        LFUCache lfuCache = new LFUCache(3);
//        lfuCache.put(2, 2);
//        lfuCache.put(1, 1);
//        System.out.println(lfuCache.get(2));
//        System.out.println(lfuCache.get(1));
//        System.out.println(lfuCache.get(2));
//        lfuCache.put(3, 3);
//        lfuCache.put(4, 4);
//        System.out.println(lfuCache.get(3));
//        System.out.println(lfuCache.get(2));
//        System.out.println(lfuCache.get(1));
//        System.out.println(lfuCache.get(4));

//        MinStack minStack = new MinStack();
//        minStack.push(512);
//        minStack.push(-1024);
//        minStack.push(-1024);
//        minStack.push(512);
//        minStack.pop();
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.getMin());
//        minStack.pop();
//        System.out.println(minStack.getMin());

//        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
//        slidingWindowMaximum.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);

//        CelebrityProblem celebrityProblem = new CelebrityProblem();
//        int[][] M = new int[4][4];
//        M[0] = new int[]{0, 1, 1, 0};
//        M[1] = new int[]{0, 0, 0, 1};
//        M[2] = new int[]{1, 1, 0, 1};
//        M[3] = new int[]{1, 1, 1, 0};
//        System.out.println(celebrityProblem.celebrity(M, 4));
//        CreateBSTFromPreOrder createBSTFromPreOrder = new CreateBSTFromPreOrder();
//        createBSTFromPreOrder.bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12});


//        CreateTreeFromPreOrderAndInOrderTraversal createTreeFromPreOrderAndInOrderTraversal = new CreateTreeFromPreOrderAndInOrderTraversal();
//        int[] preorder = new int[]{1, 2};
//        int[] inorder = new int[]{2, 1};
//        System.out.println(createTreeFromPreOrderAndInOrderTraversal.buildTree(preorder, inorder));
//        MSTPrimsAlgorithm2 mstPrimsAlgorithm2 = new MSTPrimsAlgorithm2();
//        int[][] coordinates = new int[5][2];
//        coordinates[0] = new int[]{0, 0};
//        coordinates[1] = new int[]{2, 2};
//        coordinates[2] = new int[]{3, 10};
//        coordinates[3] = new int[]{5, 2};
//        coordinates[4] = new int[]{7, 0};
//        System.out.println(mstPrimsAlgorithm2.minCostConnectPoints(coordinates));

//        SubSetSum subSetSum = new SubSetSum();
//        ArrayList<Integer> a = new ArrayList<>(List.of(2, 3, 4));
//        System.out.println(subSetSum.subsetSums(a, a.size()));


//        List<Integer> s1 = new ArrayList<>();
//        s1.add(0); s1.add(1); s1.add(2);
//        List<Integer> s2 = new ArrayList<>();
//        s2.add(0); s2.add(1); s2.add(2);
//
//        Map<List<Integer>, Integer> map = new HashMap<>();
//        map.put(s1, 1);
//        System.out.println(map.containsKey(s2));

//        KthPermutation kthPermutation = new KthPermutation();
//        System.out.println(kthPermutation.getPermutation(4, 10));
//        PalindromePartition palindromePartition = new PalindromePartition();
//        System.out.println(palindromePartition.partition("abbab"));

//        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
//        System.out.println(kthLargestElementInArray.findKthLargest(new int[]{3, 2, 1, 5, 5, 6, 4}, 4));

//        KthLargestElementInStream kthLargestElementInStream = new KthLargestElementInStream(3, new int[]{4, 5, 8, 2});
//        System.out.println(kthLargestElementInStream.add(3));
//        System.out.println(kthLargestElementInStream.add(5));
//        System.out.println(kthLargestElementInStream.add(10));
//        System.out.println(kthLargestElementInStream.add(9));
//        System.out.println(kthLargestElementInStream.add(4));

//        MaximumSumIncreasingSubsequence maximumSumIncreasingSubsequence = new MaximumSumIncreasingSubsequence();
//        int[] arr = new int[]{1, 101, 2, 3, 100};
//        System.out.println(maximumSumIncreasingSubsequence.maxSumIS(arr, arr.length));

//        EggDrop eggDrop = new EggDrop();
//        System.out.println(eggDrop.eggDrop(4, 8));

//        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
//        System.out.println(palindromePartitioning.palindromicPartition("ababbbabbababa"));
//        System.out.println(palindromePartitioning.palindromicPartition("aaabba"));

//        MaximalSquare maximalSquare = new MaximalSquare();
//        char[][] A = new char[5][5];
//        A[0] = "11110".toCharArray();
//        A[1] = "11110".toCharArray();
//        A[2] = "11111".toCharArray();
//        A[3] = "11111".toCharArray();
//        A[4] = "00111".toCharArray();
//        System.out.println(maximalSquare.maximalSquare(A));

//        WordBreak wordBreak = new WordBreak();
//        System.out.println(wordBreak.wordBreak("leetcode", List.of("leet", "code")));
//        System.out.println(wordBreak.wordBreak("ab", List.of("a", "b")));
//        InterLeavingStrings interLeavingStrings = new InterLeavingStrings();
//        System.out.println(interLeavingStrings.isInterleave("", "", ""));

//        RemoveDuplicatesSortedArray removeDuplicatesSortedArray = new RemoveDuplicatesSortedArray();
//        System.out.println(removeDuplicatesSortedArray.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));

//        InverseArrayReversePairs inverseArrayReversePairs = new InverseArrayReversePairs();
//        System.out.println(inverseArrayReversePairs.reversePairs(new int[]{2, 4, 3, 5, 1}));


//        MatrixRotate matrixRotate = new MatrixRotate();
//        int[] A = new int[]{1, 2, 3};
//        int[] B = new int[]{4, 5, 6};
//        int[] C = new int[]{7, 8, 9};
//        int[][] M = new int[3][3];
//        M[0] = A;
//        M[1] = B;
//        M[2] = C;
//        matrixRotate.rotate(M);


//        Power power = new Power();
//        System.out.println(power.myPow(2, -2));

//        SubArrayWithGivenXOR subArrayWithGivenXOR = new SubArrayWithGivenXOR();
//        ArrayList<Integer> list = new ArrayList<>(List.of(4, 2, 2, 6, 4));
//        System.out.println(subArrayWithGivenXOR.solve(list, 6));


//        KthLargestElement kthLargestElement = new KthLargestElement();
//        System.out.println(kthLargestElement.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));


//        SubsequenceOfLengthKWithLargestSum subsequenceOfLengthKWithLargestSum = new SubsequenceOfLengthKWithLargestSum();
//        subsequenceOfLengthKWithLargestSum.maxSubsequence(new int[]{2, 1, 3, 3}, 2);
//        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();
//        System.out.println(kokoEatingBananas.minEatingSpeed(new int[]{312884470}, 312884469));

//        AllocateBooks allocateBooks = new AllocateBooks();
//        ArrayList<Integer> A = new ArrayList<>(List.of(97, 26, 12, 67, 10, 33, 79, 49, 79, 21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24));
//        System.out.println(allocateBooks.books(A, 26));


//        MatrixMedian matrixMedian = new MatrixMedian();
//        int[] a1 = new int[]{1, 3, 6};
//        int[] a2 = new int[]{2, 7, 9};
//        int[] a3 = new int[]{3, 7, 9};
//        int[][] A = new int[3][3];
//        A[0] = a1; A[1] = a2; A[2] = a3;
//        System.out.println(matrixMedian.median(A, A.length, A[0].length));
//        MedianOf2SortedArrays medianOf2SortedArrays = new MedianOf2SortedArrays();
//        int[] A = new int[]{2};
//        int[] B = new int[]{1, 3};
//        System.out.println(medianOf2SortedArrays.findMedianSortedArrays(A, B));
//        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
//        int[] A = new int[]{1, 2, 6, 7, 9};
//        int[] B = new int[]{3, 4, 4, 8, 10, 11};
//        int[] A = new int[]{0, 0, 0, 0, 0};
//        int[] B = new int[]{-1, 0, 0, 0, 0, 0, 1};

//        int[] A = new int[]{2};
//        int[] B = new int[]{1, 3, 4};
//        int[] A = new int[]{2};
//        int[] B = new int[]{1, 3, 4, 5, 6};
//        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(A, B));

//        KthMedianOfTwoSortedArray kthMedianOfTwoSortedArray = new KthMedianOfTwoSortedArray();
//        int[] A = new int[]{1, 2, 6, 7, 9};
//        int[] B = new int[]{3, 4, 8, 10};
//        System.out.println(kthMedianOfTwoSortedArray.kthElement(A, B, A.length, B.length, 4));
//        StringMatching stringMatching = new StringMatching();
//        System.out.println(stringMatching.strStr("sadbutsad", "sad"));


//        PalindromicSubstring palindromicSubstring = new PalindromicSubstring();
//        System.out.println(palindromicSubstring.longestPalindrome("aacabdkacaa"));

//        RodCuttingProblem rodCuttingProblem = new RodCuttingProblem();
//        System.out.println(rodCuttingProblem.minCost(7, new int[]{1,3,4,5}));

//        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
//        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{0,1,0,3,2,3}));


//        MaxiumXOR maxiumXOR = new MaxiumXOR();
//        int xor = maxiumXOR.findMaximumXOR(new int[]{3, 10, 5, 25, 8});
//        System.out.println(xor);
//        SubSet subSet = new SubSet();
//        List<List<Integer>> words = subSet.subsets(new int[]{1, 2, 3});
//        for(List<Integer> word: words){
//            System.out.println(word);
//        }


//        BuySellStock4 buySellStock1 = new BuySellStock4();
//        int k = 1;
//        int[] arr = new int[]{1, 2};
//        System.out.println(buySellStock1.maxProfit(k, arr));


//        BuySellStock4 buySellStock4 = new BuySellStock4();
//        int k = 100;
//        int[] arr = new int[]{70,4,83,56,94,72,78,43,2,86,65,100,94,56,41,66,3,33,10,3,45,94,15,12,78,60,58,0,58,15,21,7,11,41,12,96,83,77,47,62,27,19,40,63,30,4,77,52,17,57,21,66,63,29,51,40,37,6,44,42,92,16,64,33,31,51,36,0,29,95,92,35,66,91,19,21,100,95,40,61,15,83,31,55,59,84,21,99,45,64,90,25,40,6,41,5,25,52,59,61,51,37,92,90,20,20,96,66,79,28,83,60,91,30,52,55,1,99,8,68,14,84,59,5,34,93,25,10,93,21,35,66,88,20,97,25,63,80,20,86,33,53,43,86,53,55,61,77,9,2,56,78,43,19,68,69,49,1,6,5,82,46,24,33,85,24,56,51,45,100,94,26,15,33,35,59,25,65,32,26,93,73,0,40,92,56,76,18,2,45,64,66,64,39,77,1,55,90,10,27,85,40,95,78,39,40,62,30,12,57,84,95,86,57,41,52,77,17,9,15,33,17,68,63,59,40,5,63,30,86,57,5,55,47,0,92,95,100,25,79,84,93,83,93,18,20,32,63,65,56,68,7,31,100,88,93,11,43,20,13,54,34,29,90,50,24,13,44,89,57,65,95,58,32,67,38,2,41,4,63,56,88,39,57,10,1,97,98,25,45,96,35,22,0,37,74,98,14,37,77,54,40,17,9,28,83,13,92,3,8,60,52,64,8,87,77,96,70,61,3,96,83,56,5,99,81,94,3,38,91,55,83,15,30,39,54,79,55,86,85,32,27,20,74,91,99,100,46,69,77,34,97,0,50,51,21,12,3,84,84,48,69,94,28,64,36,70,34,70,11,89,58,6,90,86,4,97,63,10,37,48,68,30,29,53,4,91,7,56,63,22,93,69,93,1,85,11,20,41,36,66,67,57,76,85,37,80,99,63,23,71,11,73,41,48,54,61,49,91,97,60,38,99,8,17,2,5,56,3,69,90,62,75,76,55,71,83,34,2,36,56,40,15,62,39,78,7,37,58,22,64,59,80,16,2,34,83,43,40,39,38,35,89,72,56,77,78,14,45,0,57,32,82,93,96,3,51,27,36,38,1,19,66,98,93,91,18,95,93,39,12,40,73,100,17,72,93,25,35,45,91,78,13,97,56,40,69,86,69,99,4,36,36,82,35,52,12,46,74,57,65,91,51,41,42,17,78,49,75,9,23,65,44,47,93,84,70,19,22,57,27,84,57,85,2,61,17,90,34,49,74,64,46,61,0,28,57,78,75,31,27,24,10,93,34,19,75,53,17,26,2,41,89,79,37,14,93,55,74,11,77,60,61,2,68,0,15,12,47,12,48,57,73,17,18,11,83,38,5,36,53,94,40,48,81,53,32,53,12,21,90,100,32,29,94,92,83,80,36,73,59,61,43,100,36,71,89,9,24,56,7,48,34,58,0,43,34,18,1,29,97,70,92,88,0,48,51,53,0,50,21,91,23,34,49,19,17,9,23,43,87,72,39,17,17,97,14,29,4,10,84,10,33,100,86,43,20,22,58,90,70,48,23,75,4,66,97,95,1,80,24,43,97,15,38,53,55,86,63,40,7,26,60,95,12,98,15,95,71,86,46,33,68,32,86,89,18,88,97,32,42,5,57,13,1,23,34,37,13,65,13,47,55,85,37,57,14,89,94,57,13,6,98,47,52,51,19,99,42,1,19,74,60,8,48,28,65,6,12,57,49,27,95,1,2,10,25,49,68,57,32,99,24,19,25,32,89,88,73,96,57,14,65,34,8,82,9,94,91,19,53,61,70,54,4,66,26,8,63,62,9,20,42,17,52,97,51,53,19,48,76,40,80,6,1,89,52,70,38,95,62,24,88,64,42,61,6,50,91,87,69,13,58,43,98,19,94,65,56,72,20,72,92,85,58,46,67,2,23,88,58,25,88,18,92,46,15,18,37,9,90,2,38,0,16,86,44,69,71,70,30,38,17,69,69,80,73,79,56,17,95,12,37,43,5,5,6,42,16,44,22,62,37,86,8,51,73,46,44,15,98,54,22,47,28,11,75,52,49,38,84,55,3,69,100,54,66,6,23,98,22,99,21,74,75,33,67,8,80,90,23,46,93,69,85,46,87,76,93,38,77,37,72,35,3,82,11,67,46,53,29,60,33,12,62,23,27,72,35,63,68,14,35,27,98,94,65,3,13,48,83,27,84,86,49,31,63,40,12,34,79,61,47,29,33,52,100,85,38,24,1,16,62,89,36,74,9,49,62,89};
//        System.out.println(buySellStock4.maxProfit(k, arr));

//        SortColors sortColors = new SortColors();
//        int[] arr = new int[]{2,2,0};
//        sortColors.sortColors(arr);
//        for(int x: arr){
//            System.out.println(x);
//        }
    }
}