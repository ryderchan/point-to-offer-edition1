package offer.structure;

/**
 * Created by ryder on 2017/5/2.
 *
 */
public class ListNode{
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        StringBuilder s= new StringBuilder();
        ListNode cur = this;
        while(cur!=null){
            s.append(cur.val);
            s.append(" ");
            cur = cur.next;
        }
        return s.toString();
    }
}
