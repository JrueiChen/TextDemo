package untitled;

//    新建一个链表
class LinkList {
    Node head;
    int N = 0;

    //    构造函数，新建链表头结点
    public LinkList() {
        this.head = new Node();
    }

    //        遍历链表
    public void traversal() {
        Node tra = head.next;
        do {
            System.out.print(tra.date + " ");
            tra = tra.next;
        } while (tra != null);
    }

    //    合并链表，第一个链表的第一个元素在前
    public LinkList combine(LinkList fir, LinkList sec) {
        LinkList com = new LinkList();
        Node A = fir.head.next, B = sec.head.next;
        Node C = com.head;
        int h = 1;
        while (A != null || B != null) {
            C.next = new Node();
            C = C.next;
            if (h == 1) {
                C.date = A.date;
                A = A.next;
            } else {
                C.date = B.date;
                B = B.next;
            }
            com.N++;
            h *= -1;
        }
        return com;
    }

    //    倒置链表
    public void reverse() {
        Node[] pointer = new Node[N];
        Node po = head;
        int i;
        for (i = 0; i < N; i++) {
            pointer[i] = po.next;
            po = po.next;
        }

        head = new Node();
        head.next = po;
        for (i = 0; i < N; i++) {
            po.next = pointer[N - 1 - i];
            po = po.next;
        }
        po.next = null;

    }

    //    删去链表中的大写字母
    public void reduceBig() {
        Node trans = head;
        Node A;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            A = trans.next;
            if (isBig(A)) {
                trans.next = A.next;
                cnt++;
            } else trans = trans.next;
        }
        N -= cnt;
    }

    //    判断是否为大写字母
    public boolean isBig(Node I) {
        if (I == null) {
            return false;
        }
        return I.date >= 'A' && I.date <= 'Z';
    }
}


//    构造结点
class Node {
    char date;
    Node next;

    public Node() {
        this.date = 0;
        this.next = null;
    }
}

public class LinkListCompute {
    public static void main(String[] args) {
//        将‘a’-‘h’赋值链表Text_1
        LinkList Text_1 = new LinkList();
        Node A = Text_1.head;
        for (char i = 'a'; i <= 'h'; i++) {
            A.next = new Node();
            A = A.next;
            A.date = i;
            Text_1.N++;
        }

//        将‘A’-‘H’赋值链表Text_2
        LinkList Text_2 = new LinkList();
        Node B = Text_2.head;
        for (char i = 'A'; i <= 'H'; i++) {
            B.next = new Node();
            B = B.next;
            B.date = i;
            Text_2.N++;
        }

        System.out.println("遍历链表1，链表2:");
//        遍历链表1，链表2
        Text_1.traversal();
        Text_2.traversal();

        System.out.println("\n=========================================\n" +
                "将链表1,2整合并遍历:");
//        将链表1,2整合并遍历
        LinkList Text_3 = Text_1.combine(Text_1, Text_2);
        Text_3.traversal();

        System.out.println("\n=========================================\n" +
                "倒置链表并遍历:");
//        倒置链表并遍历
        Text_3.reverse();
        Text_3.traversal();

        System.out.println("\n=========================================\n" +
                "去除链表中的大写字母:");
//        去除链表中的大写字母
        Text_3.reduceBig();
        Text_3.traversal();
    }
}