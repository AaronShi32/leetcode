package com.support;

public class TreeFactory {


      public static TreeNode buildSample(){
          TreeNode root = new TreeNode(1);
          TreeNode a = new TreeNode(2);
          TreeNode b = new TreeNode(3);
          root.left = a;
          root.right = b;
          TreeNode c = new TreeNode(4);
          a.left = c;
          TreeNode d = new TreeNode(5);
          a.right = d;
          TreeNode e = new TreeNode(7);
          d.left = e;
          TreeNode f = new TreeNode(8);
          e.right = f;
          TreeNode g = new TreeNode(5);
          b.right = g;
          TreeNode h = new TreeNode(7);
          g.left = h;
          return root;
      }

    /**
     *       5
     *      / \
     *     3   6
     *    / \
     *   2   4
     *  /
     * 1
     * @return
     */
    public static TreeNode buildBST(){
          TreeNode root = new TreeNode(5);
          TreeNode a = new TreeNode(3);
          TreeNode b = new TreeNode(6);
          TreeNode c = new TreeNode(2);
          TreeNode d = new TreeNode(4);
          TreeNode e = new TreeNode(1);
          root.left = a;
          root.right = b;
          a.left = c;
          a.right = d;
          c.left = e;
          return root;
      }
//    public static TreeNode buildLevel(String[] nodes){
//        TreeNode root = null;
//        int len = nodes.length;
//        for(int i = 0; i < len; i++){
//
//
//        }
//
//        return root;
//    }
//
//

//    public static TreeNode buildPreOrder(TreeNode t, String node){
//        if(node.equals("#")){
//            t = null;
//        }else{
//            t = new TreeNode(Integer.parseInt(node));
//            t.left = buildPreOrder(t.left);
//        }
//
//        return t;
//    }




    public static TreeNode build(String str, int type){

        String[] nodes = str.split(",");
        TreeNode root = null;
        switch (type){
//            case Constants.LEVEL:
//                root = buildLevel(nodes);
//                break;
//            case Constants.PREORDER:
//                root = buildPreOrder(nodes);
//                break;
            case Constants.SAMPLE:
                root = buildSample();
                break;
            default:
                System.err.println("not support");
                break;
        }
        return root;
    }


    public static void main(String[] args){
        //build("10,5,-3,3,2,#,11,3,-2,#,1", 1);


    }

}
