package com.iterlife.zeus.algo.matrix;

/**
 * @desc:https://leetcode-cn.com/problems/escape-the-ghosts/
 * @author: lujie
 * @version: V1.0.0
 * @datetime: 2021/8/22 11:10
 **/
public class EscapeTheGhosts {
}


class EscapeTheGhostsSolution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int escapeMinPath = Math.abs(target[0] - 0) + Math.abs(target[1] - 0);
        int ghostMinPath = Math.abs(target[0] - ghosts[0][0]) + Math.abs(target[1] - ghosts[0][1]);
        for (int i = 1; i < ghosts.length; ++i) {
            int ghostTempPath = Math.abs(target[0] - ghosts[i][0]) + Math.abs(target[1] - ghosts[i][1]);
            ghostMinPath = ghostMinPath > ghostTempPath ? ghostTempPath : ghostMinPath;
        }
        return escapeMinPath < ghostMinPath;
    }
}
