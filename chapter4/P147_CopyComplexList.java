package offer.chapter4;

import java.util.HashMap;

/**
 * Created by ryder on 2017/5/13.
 */
public class P147_CopyComplexList {
    public static class ComplexListNode{
        int val;
        ComplexListNode next;
        ComplexListNode random;

        public ComplexListNode(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            StringBuilder ret = new StringBuilder();
            ComplexListNode cur = this;
            while(cur!=null) {
                ret.append(cur.val);
                if(cur.random!=null)
                    ret.append("("+cur.random.val+")");
                else{
                    ret.append("(_)");
                }
                ret.append('\t');
                cur = cur.next;
            }
            return ret.toString();
        }
    }

    //time:o(n^2) space:o(1) 新链表使用的空间不算入
    //先复制val与next（时间o(n)），再复制random（时间o(n^2)）
    public static ComplexListNode clone1(ComplexListNode head){
        if(head==null)
            return null;
        ComplexListNode newHead = new ComplexListNode(head.val);
        ComplexListNode cur = head.next;
        ComplexListNode newPrevCur = newHead;
        ComplexListNode newCur = null;
        while (cur!=null){
            newCur = new ComplexListNode(cur.val);
            newPrevCur.next = newCur;
            newPrevCur = newPrevCur.next;
            cur = cur.next;
        }
        cur = head;
        newCur = newHead;
        ComplexListNode temp = head;
        ComplexListNode newTemp = newHead;
        while(cur!=null){
            if(cur.random!=null){
                temp = head;
                newTemp = newHead;
                while(temp!=cur.random){
                    temp = temp.next;
                    newTemp = newTemp.next;
                }
                newCur.random = newTemp;
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }

    //time:o(n) space:o(n)
    //使用一个哈希表<oldListNode,newListNode>存储,解决random的查询时间问题
    public static ComplexListNode clone2(ComplexListNode head){
        if(head==null)
            return null;
        HashMap<ComplexListNode,ComplexListNode> oldToNew = new HashMap<>();
        ComplexListNode newHead = new ComplexListNode(head.val);
        oldToNew.put(head,newHead);
        ComplexListNode cur = head.next;
        ComplexListNode newPrevCur = newHead;
        ComplexListNode newCur = null;
        while (cur!=null){
            newCur = new ComplexListNode(cur.val);
            oldToNew.put(cur,newCur);
            newPrevCur.next = newCur;
            newPrevCur = newPrevCur.next;
            cur = cur.next;
        }
        cur = head;
        newCur = newHead;
        while(cur!=null){
            if(cur.random!=null)
                newCur.random = oldToNew.get(cur.random);
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }

    //time:o(n) space:o(1)
    //在原始链表后面交叉复制出一个新链表，random的查找赋值可在o(1)时间内完成，之后将节点按照奇偶分开
    public static ComplexListNode clone3(ComplexListNode head){
        ComplexListNode cur = head;
        ComplexListNode newCur = null;
        ComplexListNode temp = null;
        while(cur!=null){
            newCur = new ComplexListNode(cur.val);
            temp = cur.next;
            cur.next = newCur;
            newCur.next = temp;
            cur = temp;
        }
        cur = head;
        newCur = cur.next;
        while(cur!=null){
            if(cur.random!=null){
                newCur.random = cur.random.next;
            }
            cur = cur.next.next;
            if(newCur.next!=null)
                newCur = newCur.next.next;
            else
                newCur = null;
        }
        cur = head;
        newCur = cur.next;
        ComplexListNode newHead = cur.next;
        while(cur!=null){
            if(cur.next.next!=null) {
                cur.next = cur.next.next;
                newCur.next = newCur.next.next;
                cur = cur.next;
                newCur = newCur.next;
            }
            else{
                cur.next = null;
                newCur.next = null;
                cur = null;
            }
        }
        return newHead;
    }
    public static void main(String[] args){
        ComplexListNode head = new ComplexListNode(1);
        ComplexListNode c2 = new ComplexListNode(2);
        ComplexListNode c3 = new ComplexListNode(3);
        ComplexListNode c4 = new ComplexListNode(4);
        ComplexListNode c5 = new ComplexListNode(5);
        head.next = c2;
        head.random = c3;
        head.next.next = c3;
        head.next.random = c5;
        head.next.next.next = c4;
        head.next.next.next.next = c5;
        head.next.next.next.random = c2;
        System.out.println("original:"+'\t'+head);
        System.out.println("clone1:  "+'\t'+clone1(head));
        System.out.println("clone2:  "+'\t'+clone2(head));
        System.out.println("clone3:  "+'\t'+clone3(head));
    }
}
