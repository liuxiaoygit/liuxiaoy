package com.yuan.algorithm.leedcode;


import java.util.*;

/**
 * 请由该二叉树生成一个新的二叉树，它满足其树中的每个节点将包含原始树中的左子树和右子树的和。
 * <p>
 * <p>
 * 左子树表示该节点左侧叶子节点为根节点的一颗新树；右子树表示该节点右侧叶子节点为根节点的一颗新树。
 * <p>
 * <p>
 * 输入描述
 * 2行整数，第1行表示二叉树的中序遍历，第2行表示二叉树的前序遍历，以空格分割
 * 例如：
 * 7 -2 6 6 9
 * 6 7 -2 9 6
 * <p>
 * <p>
 * 输出描述
 * 1行整数，表示求和树的中序遍历，以空格分割
 * 例如：
 * -2 0 20 0 6
 * <p>
 * <p>
 * 用例1
 * 输入
 * <p>
 * 7 -2 6 6 9
 * 6 7 -2 9 6
 * 输出
 * <p>
 * -2 0 20 0 6
 * 说明 无
 * <p>
 * 用例2
 * 输入
 * <p>
 * -3 12 6 8 9 -10 -7
 * 8 12 -3 6 -10 9 -7
 * 输出
 * <p>
 * 0 3 0 7 0 2 0
 * 说明 无
 */

public class TreeCaculate {


    class Node {
        int val;
        Node left, right;
        int last;

        Node(int v) {
            val = v;
            left = right = null;
            last = 0;
        }

    }

    // 构建树的递归函数
    public Node buildTree(int[] pre, int[] mid) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < mid.length; ++i) {
            int val = mid[i];
            mp.putIfAbsent(val, new ArrayList<>());
            mp.get(val).add(i);
        }

        int i[] = {0};
        Map<Integer, Integer> c = new HashMap<>();
        int index[] = new int[pre.length];

        for (int k = 0; k < pre.length; ++k) {
            int val = pre[k];
            c.put(val, c.getOrDefault(val, 0) + 1);
            index[k] = c.get(val) - 1;
        }

        return build(0, mid.length - 1, pre, mp, index, i);

    }


    private Node build(int lc, int rc, int[] pre,
                       Map<Integer, List<Integer>> mp, int[] index, int[] i) {
        if (i[0] >= pre.length) return null;
        int val = pre[i[0]];
        int idx = mp.get(val).get(index[i[0]]);
        Node now = new Node(val);
        if (lc <= idx - 1) {
            i[0]++;
            now.left = build(lc, idx - 1, pre, mp, index, i);
        }
        if (rc >= idx + 1) {
            i[0]++;
            now.right = build(idx + 1, rc, pre, mp, index, i);
        }
        return now;
    }

    // 深度优先遍历，为每个节点计算 last 值
    public static void dfs(Node now) {
        if (now.left != null) {
            dfs(now.left);
            now.last += now.left.last + now.left.val;
        }
        if (now.right != null) {
            dfs(now.right);
            now.last += now.right.last + now.right.val;
        }
    }

    // 中序遍历，获取每个节点的 last 值
    public static void zhong(Node now, List<Integer> ans) {
        if (now == null) return;
        zhong(now.left, ans);
        ans.add(now.last);
        zhong(now.right, ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tmp = sc.nextLine().split(" ");
        int n = tmp.length;
        int[] mid = new int[n];
        int[] pre = new int[n];
        for (int i = 0; i < n; ++i) {
            mid[i] = Integer.parseInt(tmp[i]);
        }
        tmp = sc.nextLine().split(" ");
        for (int i = 0; i < n; ++i) {
            pre[i] = Integer.parseInt(tmp[i]);
        }
        TreeCaculate treeCaculate = new TreeCaculate();
        Node root = treeCaculate.buildTree(pre, mid);

        dfs(root);

        List<Integer> ans = new ArrayList<>();
        zhong(root, ans);

        for (int i = 0; i < ans.size(); ++i) {
            if (i > 0) System.out.print(" ");
            System.out.print(ans.get(i));
        }
        System.out.println();
    }


}
