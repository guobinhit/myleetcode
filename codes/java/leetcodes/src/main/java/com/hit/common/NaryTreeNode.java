package com.hit.common;

import java.util.List;

/**
 * author:Charies Gavin
 * date:2019/8/12,18:53
 * https:github.com/guobinhit
 * description: N-ary tree node
 */
public class NaryTreeNode {
    public int val;
    public List<NaryTreeNode> children;

    public NaryTreeNode() {
    }

    public NaryTreeNode(int _val, List<NaryTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
