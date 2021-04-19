package com.example.leetcode;

public class IsAnagram {

    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s = "rat", t = "car"
     * 输出: false
     * 说明:
     * 你可以假设字符串只包含小写字母。
     * <p>
     * 进阶:
     * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        /**
         * 用一个数组记录s出现的位置和次数
         * 在用这个数组建议t出现的位置和次数
         *如果最后记录的数组有一个位置不为0 则证明不包含
         */
        int record[] = new int[26];
        for (int i = 0 ; i<s.length();i++){
            record[s.charAt(i)-'a']++;
        }

        for (int i = 0 ; i<t.length();i++){
            record[t.charAt(i)-'a']--;
        }

        for(int i = 0; i< record.length;i++){
            if(record[i]!=0){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {

       String  s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
