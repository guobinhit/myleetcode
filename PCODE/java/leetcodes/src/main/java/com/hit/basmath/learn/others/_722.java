package com.hit.basmath.learn.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 722. Remove Comments
 * <p>
 * Given a C++ program, remove comments from it. The program source is an array where source[i] is the i-th line of the source code. This represents the result of splitting the original source code string by the newline character \n.
 * <p>
 * In C++, there are two types of comments, line comments, and block comments.
 * <p>
 * The string // denotes a line comment, which represents that it and rest of the characters to the right of it in the same line should be ignored.
 * <p>
 * ....
 * <p>
 * <p>
 * Note:
 * <p>
 * The length of source is in the range [1, 100].
 * The length of source[i] is in the range [0, 80].
 * Every open block comment is eventually closed.
 * There are no single-quote, double-quote, or control characters in the source code.
 */
public class _722 {
    private String lc = "//"; // line comment
    private String bcs = "/*"; // block comment start
    private String bce = "*/"; // block comment end

    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < source.length; i++) {
            int idxLine = source[i].indexOf(lc); // get idex of line comment
            int idxBlock = source[i].indexOf(bcs); // get idex of block comment
            // if there is any comment in the current line
            if (idxLine != -1 || idxBlock != -1) {
                // case 1: line comment takes precedence
                if (idxLine != -1 && (idxLine < idxBlock || idxBlock == -1)) {
                    source[i] = source[i].substring(0, idxLine);
                } else {
                    // case 2: block comment takes precedence
                    String s = source[i].substring(0, idxBlock);
                    int start = idxBlock + 2;
                    int idxBlockEnd = -1;
                    while (true) {
                        idxBlockEnd = source[i].indexOf(bce, start);
                        if (idxBlockEnd != -1) {
                            break;
                        }
                        i++;
                        start = 0;
                    }
                    s += source[i].substring(idxBlockEnd + 2, source[i].length());
                    source[i] = s;
                    // recurse here
                    i--;
                    continue;
                }
            }
            // only add non-empty line
            if (!source[i].isEmpty()) {
                res.add(source[i]);
            }
        }
        return res;
    }
}
