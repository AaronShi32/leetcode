package com.topic.dp;

import com.util.Question;

@Question(id = 96, hint = "Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?")
public class MUniqueBinarySearchTrees {

    // F(i, n) = G(i-1) * G(n-i)
    // G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0)
    public int numTrees(int n) {
        int [] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {
                G[i] += G[j-1] * G[i-j];
            }
        }

        return G[n];
    }

}
