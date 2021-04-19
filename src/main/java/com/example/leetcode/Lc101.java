package com.example.leetcode;

/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * <p>
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class Lc101 {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }else{
            return isSame(root.left,root.right);
        }
    }

    public static boolean isSame(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }

        if(p.val == q.val){
            return isSame(p.left,q.right)&&isSame(p.right,q.left);
        }

            return false;
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,null,null};
        TreeNode root = CreateNode.createTree(arr).get(0);
        System.out.println(isSymmetric(root));
    }
}
