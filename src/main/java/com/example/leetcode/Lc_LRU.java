package com.example.leetcode;

/**
 * 基于链表实现LRU缓存淘汰算法
 * 思路：1.如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 * 2.如果此数据没有在缓存链表中，又可以分为两种情况：
 * 如果此时缓存未满，则将此结点直接插入到链表的头部；
 * 如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
 */
public class Lc_LRU {
    public static class LinkList {
        int node;
        LinkList next;

        public LinkList() {
        }

        public LinkList(int node, LinkList next) {
            this.node = node;
            this.next = next;
        }

        public LinkList(int node) {
            this.node = node;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public LinkList getNext() {
            return next;
        }

        public void setNext(LinkList next) {
            this.next = next;
        }
    }

    //链表最大长度
    int size = 10;

    //遍历链表
    private boolean traversal(LinkList newNode, LinkList linkList) {
        LinkList curr = linkList;
        while (curr != null) {
            if (curr.node != newNode.node) {
                curr = curr.next;
            } else {
                return true;
            }
        }
        return false;
    }

    //遍历链表是否存在新插入的值,存在则删除
    private LinkList delete(LinkList head, LinkList toRemove) {
        if (head.node == toRemove.node) {
            return head.next;
        }
        LinkList pre = head;
        LinkList curr = head;
        while (curr != null) {
            if (curr.node == toRemove.node) {
                pre.next = curr.next;
                return pre;
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return null;
    }

    //删除最后一个节点
    private void deleteLastNode(LinkList linkList) {
        LinkList curr = linkList;
        int position = 0;
        while (curr != null && position != 8) {
            position++;
            curr = curr.next;
        }
        curr.next = null;
    }


    //遍历链表长度
    private int count(LinkList linkList) {
        LinkList curr = linkList;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    //插入新节点，检查是否存在该节点，若存在删除原来位置的节点，插入到头,如果不存在，直接插入到头
    private LinkList insert(LinkList newNode, LinkList linkList) {
        if (count(linkList) < 10) {
            //go on
        } else {
            deleteLastNode(linkList);
        }
        linkList = delete(linkList, newNode);
        LinkList head = newNode;
        head.next = linkList;
        return head;
    }

    private void sysoLinkList(LinkList linkList) {
        StringBuffer stringBuffer = new StringBuffer();
        LinkList curr = linkList;
        while (curr != null) {
            stringBuffer.append(curr.node);
            curr = curr.next;
        }
        System.out.println(stringBuffer.toString());
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList(2);
        LinkList newNode = new LinkList(1);
        linkList.next = newNode;
        LinkList newNode1 = new LinkList(1);
        Lc_LRU lc_lru = new Lc_LRU();
        linkList = lc_lru.insert(newNode1, linkList);
        lc_lru.sysoLinkList(linkList);
    }
}
