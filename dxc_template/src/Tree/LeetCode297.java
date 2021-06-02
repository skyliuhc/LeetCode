package Tree;

public class LeetCode297 {
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root,sb);
        // System.out.println(sb.toString());
        return sb.toString();
    }

    void dfs(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return ;
        }
        sb.append(root.val+",");
        dfs(root.left,sb);
        dfs(root.right,sb);
    }
    int u = 0;
    //一定要定义成属性，这样才能全局访问
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        // System.out.println(data);
        return dp(data);
    }
    TreeNode dp(String data){
        if(data.charAt(u)=='#'){
            u+=2;
            return null;
        }

        boolean is_minus = false;
        if(data.charAt(u)=='-'){
            u++;
            is_minus=true;
        }

        int t =0;
        // System.out.println(data.charAt(u)+"//");
        while(data.charAt(u)!=','){
            t=t*10+data.charAt(u)-'0';
            // System.out.println(t);
            u++;
        }
        // System.out.println("u:"+u);
        u++;
        if(is_minus) t=-t;
        TreeNode root = new TreeNode(t);
        // System.out.println("进行左右子树构造时u:"+u);
        root.left=dp(data);
        root.right=dp(data);
        return root;
    }
}
