
import java.util.*;

class X {
    Y y = new Y();
    public X() {
        System.out.println("X");
    }
}
class Y {
    public Y() {
        System.out.println("Y");
    }
}
public class Test extends X {
    Y y = new Y();

    public Test() {
        System.out.println("Z");
    }

    public static void main1(String[] args) {
        new Test(); // YXYZ
    }
}

class TestDemo {
    static boolean paddy;

    public static void main2(String[] args) {
        System.out.println(paddy); // false
    }
}

class TestDemo2 {
    public String name = "abc";

    public static void main(String[] args) {
        TestDemo2 test = new TestDemo2();
        TestDemo2 test1 = new TestDemo2();
        System.out.println(test.equals(test1) + ", " + test1.name.equals(test1.name));
        // false, true
    }
}

class Main{

    // 给定一个正整数 N 代表火车数量，0 < N < 10，
    // 接下来输入火车入站的序列，一共 N 辆火车，每辆火车以数字 1 - 9 编号，
    // 火车站只有一个方向进出，同时停靠在火车站的列车中，只有先进站的出站了，后进站的才能出站。
    // 要求以字典序排序输出火车出站的序列号。

    // 输入多组测试用例，每一组第一行输入一个正整数 N（0 < N < 10），第二行包括 N 个正整数，范围为 1 到 9。
    // 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见 sample。

    //示例:
    //输入
    //3
    //1 2 3

    //输出
    //1 2 3
    //1 3 2
    //2 1 3
    //2 3 1
    //3 2 1

    // 顺序输出可以出栈的顺序
    static ArrayList<String> list = new ArrayList<>(); // 储存结果
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            list.clear(); // 静态变量，每次先清空
            int nums = sc.nextInt();
            int[] id=new int[nums];
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < nums; i++) {
                id[i] = sc.nextInt();
            }
            outStack(id,0, stack,"",0);
            Collections.sort(list); // 对结果集排序
            for(String str:list) {
                System.out.println(str);
            }
        }
        sc.close();
    }
    // i 为入栈次数，n 为出栈次数，str 存储一趟结果
    public static void outStack(int[] id, int i, Stack<Integer> s, String str, int n) {
        if(n == id.length) {
            list.add(str);
            // 如果所有火车均出栈则将当前结果保存
        }
        if(!s.empty()) {
            // 栈非空时出栈
            int temp=s.pop();
            outStack(id, i, s,str+temp+" ",n+1);
            s.push(temp); // 恢复现场
        }
        if(i < id.length) {
            // 若所有火车没有都入栈则入栈
            s.push(id[i]);
            outStack(id,i + 1, s, str, n);
            s.pop();
            //恢复现场
        }
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Node {
    public void Mirror(TreeNode root) {
        // 操作给定的二叉树，将其变换为源二叉树的镜像
        // ps: 输出对称的二叉树

        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if (node.left != null || node.right != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
    }
}