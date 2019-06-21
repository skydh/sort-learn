package com.dh.search.tree.RBTree;

/**
 * 红黑树，其实就是比较平衡的一个查找二叉树，其原理就是就是类似魔方的复原一样， 什么样的场景干什么事。大致可以找出3个情况，左旋，右旋，变色。
 * 左旋就是这个节点向左旋转，让其右节点作为父节点。右旋则是这个节点向右旋转。让其左节点作为父节点。
 * 
 * 插入：如果父节点是黑色，不用平衡。
 * 如果父节点是红色，那么就根据下面几种情况处理来平衡。
 * case1:
 * 如果关注节点是 a，它的叔叔节点 d 是红色，我们就依次执行下面操作。
 * 将a的父节点，叔叔节点都设置为黑色
 * 将a的祖父节点设置为红色
 * 将关注节点变成a的祖父节点
 * 
 * 如果关注节点是 a，它的叔叔节点 d 是黑色，a是父节点的右子节点我们就依次执行下面操作。
 * 关注节点变成a节点的父节点。
 * 围绕新的节点左旋
 * 
 * 如果关注节点是 a，它的叔叔节点 d 是黑色，a是父节点的左子节点我们就依次执行下面操作。
 * 围绕a的祖父节点右旋
 * 关注节点a的父节点和其兄弟节点换色
 * 如此所有情况都已经考虑了
 * 
 * @author Lenovo
 *
 */
public class RBTreeNode {
	

}
