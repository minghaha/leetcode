package com.example.leetcode;

/**
 * @description:
 * 700. 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 *
 * 例如，
 *
 * 给定二叉搜索树:
 *
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * 和值: 2
 * 你应该返回如下子树:
 *
 *       2
 *      / \
 *     1   3
 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 *
 * @author: licm
 * @create: 2021-04-21 10:05
 **/
public class Lc700_二叉搜索树中的搜索 {
    /**
     * 思路 利用二叉搜索树 避免全树搜索
     * 二叉搜索树定义：二叉搜索树是一个有序树：
     *
     * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 它的左、右子树也分别为二叉搜索树
     * 这就决定了，二叉搜索树，递归遍历和迭代遍历和普通二叉树都不一样。
     *
     * @param root
     * @param val
     * @return
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        return travesal(root,val);
    }

    static TreeNode travesal(TreeNode root,int val){
        if(root == null || root.val == val){
            return root;
        }

        if(root.val > val){
            return travesal(root.left,val);
        }

        if(root.val < val){
            return travesal(root.right,val);
        }
        return null;
    }

}
