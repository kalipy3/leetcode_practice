作者：wang_ni_ma
链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/liang-chong-shi-xian-tu-jie-138-fu-zhi-dai-sui-ji-/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

//方法一 推荐方法一的写法二 和方法一的写法三
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) {
            return null;
        }
        Node p = head;
        //第一步，在每个原节点后面创建一个新节点
        //1->1'->2->2'->3->3'
        while(p!=null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        p = head;
        //第二步，设置新节点的随机节点
        while(p!=null) {
            if(p.random!=null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        Node dummy = new Node(-1);
        p = head;
        Node cur = dummy;
        //第三步，将两个链表分离
        while(p!=null) {
            cur.next = p.next;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }
        return dummy.next;
    }
}	

//方法一的写法三 推荐
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) {
            return null;
        }
        Node p = head;
        //第一步，在每个原节点后面创建一个新节点
        //1->1'->2->2'->3->3'
        while(p!=null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        p = head;
        //第二步，设置新节点的随机节点
        while(p!=null) {
            if(p.random!=null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        
        //分离
        Node cur = head;
        Node ans = head.next;
        while (cur != null) {
            Node t = cur.next;
            if (cur.next != null) 
                cur.next = cur.next.next;
            cur = t;
        }
        return ans;
    }
}	

//方法一的写法二 推荐
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node dummy = new Node(-1);
        dummy.next = head;
        while (head != null) {
            Node node = new Node(head.val);
            node.next = head.next;
            head.next = node;
            head = node.next;
        }
        head = dummy.next;
        while (head != null) {
            if (head.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
        head = dummy.next;
        Node ans = head.next;
        while (head != null) {
            Node tmp = head.next;
            if (head.next != null) head.next = head.next.next;
            head = tmp;
        }
        return ans;
    }
}



//方法二
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) {
            return null;
        }
        //创建一个哈希表，key是原节点，value是新节点
        Map<Node,Node> map = new HashMap<Node,Node>();
        Node p = head;
        //将原节点和新节点放入哈希表中
        while(p!=null) {
            Node newNode = new Node(p.val);
            map.put(p,newNode);
            p = p.next;
        }
        p = head;
        //遍历原链表，设置新节点的next和random
        while(p!=null) {
            Node newNode = map.get(p);
            //p是原节点，map.get(p)是对应的新节点，p.next是原节点的下一个
            //map.get(p.next)是原节点下一个对应的新节点
            if(p.next!=null) {
                newNode.next = map.get(p.next);
            }
            //p.random是原节点随机指向
            //map.get(p.random)是原节点随机指向  对应的新节点 
            if(p.random!=null) {
                newNode.random = map.get(p.random);
            }
            p = p.next;
        }
        //返回头结点，即原节点对应的value(新节点)
        return map.get(head);
    }
}


