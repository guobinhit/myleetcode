package com.hit.basmath.learn.others;

import java.util.Stack;

/**
 * 591. Tag Validator
 * <p>
 * Given a string representing a code snippet, you need to implement a tag validator to parse the code and return whether it is valid. A code snippet is valid if all the following rules hold:
 * <p>
 * The code must be wrapped in a valid closed tag. Otherwise, the code is invalid.
 * A closed tag (not necessarily valid) has exactly the following format : <TAG_NAME>TAG_CONTENT</TAG_NAME>. Among them, <TAG_NAME> is the start tag, and </TAG_NAME> is the end tag. The TAG_NAME in start and end tags should be the same. A closed tag is valid if and only if the TAG_NAME and TAG_CONTENT are valid.
 * A valid TAG_NAME only contain upper-case letters, and has length in range [1,9]. Otherwise, the TAG_NAME is invalid.
 * A valid TAG_CONTENT may contain other valid closed tags, cdata and any characters (see note1) EXCEPT unmatched <, unmatched start and end tag, and unmatched or closed tags with invalid TAG_NAME. Otherwise, the TAG_CONTENT is invalid.
 * A start tag is unmatched if no end tag exists with the same TAG_NAME, and vice versa. However, you also need to consider the issue of unbalanced when tags are nested.
 * A < is unmatched if you cannot find a subsequent >. And when you find a < or </, all the subsequent characters until the next > should be parsed as TAG_NAME (not necessarily valid).
 * The cdata has the following format : <![CDATA[CDATA_CONTENT]]>. The range of CDATA_CONTENT is defined as the characters between <![CDATA[ and the first subsequent ]]>.
 * CDATA_CONTENT may contain any characters. The function of cdata is to forbid the validator to parse CDATA_CONTENT, so even it has some characters that can be parsed as tag (no matter valid or invalid), you should treat it as regular characters.
 * <p>
 * Valid Code Examples:
 * <p>
 * Input: "<DIV>This is the first line <![CDATA[<div>]]></DIV>"
 * <p>
 * Output: True
 * <p>
 * Explanation:
 * <p>
 * The code is wrapped in a closed tag : <DIV> and </DIV>.
 * <p>
 * The TAG_NAME is valid, the TAG_CONTENT consists of some characters and cdata.
 * <p>
 * Although CDATA_CONTENT has unmatched start tag with invalid TAG_NAME, it should be considered as plain text, not parsed as tag.
 * <p>
 * So TAG_CONTENT is valid, and then the code is valid. Thus return true.
 * <p>
 * Input: "<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"
 * <p>
 * Output: True
 * <p>
 * Explanation:
 * <p>
 * We first separate the code into : start_tag|tag_content|end_tag.
 * <p>
 * start_tag -> "<DIV>"
 * <p>
 * end_tag -> "</DIV>"
 * <p>
 * tag_content could also be separated into : text1|cdata|text2.
 * <p>
 * text1 -> ">>  ![cdata[]] "
 * <p>
 * cdata -> "<![CDATA[<div>]>]]>", where the CDATA_CONTENT is "<div>]>"
 * <p>
 * text2 -> "]]>>]"
 * <p>
 * The reason why start_tag is NOT "<DIV>>>" is because of the rule 6.
 * The reason why cdata is NOT "<![CDATA[<div>]>]]>]]>" is because of the rule 7.
 * <p>
 * Invalid Code Examples:
 * <p>
 * Input: "<A>  <B> </A>   </B>"
 * Output: False
 * Explanation: Unbalanced. If "<A>" is closed, then "<B>" must be unmatched, and vice versa.
 * <p>
 * Input: "<DIV>  div tag is not closed  <DIV>"
 * Output: False
 * <p>
 * Input: "<DIV>  unmatched <  </DIV>"
 * Output: False
 * <p>
 * Input: "<DIV> closed tags with invalid tag name  <b>123</b> </DIV>"
 * Output: False
 * <p>
 * Input: "<DIV> unmatched tags with invalid tag name  </1234567890> and <CDATA[[]]>  </DIV>"
 * Output: False
 * <p>
 * Input: "<DIV>  unmatched start tag <B>  and unmatched end tag </C>  </DIV>"
 * Output: False
 * <p>
 * Note:
 * <p>
 * For simplicity, you could assume the input code (including the any characters mentioned above) only contain letters, digits, '<','>','/','!','[',']' and ' '.
 */
public class _591 {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < code.length(); ) {
            if (i > 0 && stack.isEmpty()) return false;
            if (code.startsWith("<![CDATA[", i)) {
                int j = i + 9;
                i = code.indexOf("]]>", j);
                if (i < 0) return false;
                i += 3;
            } else if (code.startsWith("</", i)) {
                int j = i + 2;
                i = code.indexOf('>', j);
                if (i < 0 || i == j || i - j > 9) return false;
                for (int k = j; k < i; k++) {
                    if (!Character.isUpperCase(code.charAt(k))) return false;
                }
                String s = code.substring(j, i++);
                if (stack.isEmpty() || !stack.pop().equals(s)) return false;
            } else if (code.startsWith("<", i)) {
                int j = i + 1;
                i = code.indexOf('>', j);
                if (i < 0 || i == j || i - j > 9) return false;
                for (int k = j; k < i; k++) {
                    if (!Character.isUpperCase(code.charAt(k))) return false;
                }
                String s = code.substring(j, i++);
                stack.push(s);
            } else {
                i++;
            }
        }
        return stack.isEmpty();
    }
}
