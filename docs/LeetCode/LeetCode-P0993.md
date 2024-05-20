---
title: LeetCode-P0993
date: 2024-04-18 15:08:04
categories: "LeetCode"
tags: ["LeetCode","栈"]
---

## 题目

> [20. 有效的括号](https://leetcode.cn/problems/valid-parentheses/)
>
> 给定一个只包括 `'('`，`')'`，`'{'`，`'}'`，`'['`，`']'` 的字符串 `s` ，判断字符串是否有效。
>
> 有效字符串需满足：
>
> 1. 左括号必须用相同类型的右括号闭合。
> 2. 左括号必须以正确的顺序闭合。
> 3. 每个右括号都有一个对应的相同类型的左括号。
>
>  
>
> **示例 1：**
>
> ```
> 输入：s = "()"
> 输出：true
> ```
>
> **示例 2：**
>
> ```
> 输入：s = "()[]{}"
> 输出：true
> ```
>
> **示例 3：**
>
> ```
> 输入：s = "(]"
> 输出：false
> ```
>
>  
>
> **提示：**
>
> - `1 <= s.length <= 104`
> - `s` 仅由括号 `'()[]{}'` 组成

## 思路

用栈的方法去存

1. 没数据或为奇数的直接返回空
2. 把各个字符的对应关系存起来
3. 用队列存数据
4. 遍历字符串，遇到左括号入队，遇到右括号，判断栈首元素是否对应，对应即弹出队列

```java
class Solution {
    public boolean isValid(String s) {
        // 1.没数据或为奇数的直接返回空
        if (s.length()%2!=0){
            return false;
        }
        // 2.把各个字符的对应关系存起来
        Map<Character,Character> map=new HashMap<Character,Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        // 3.用队列存数据
        Deque<Character> stack=new LinkedList<>();
        // 4.遍历字符串，遇到左括号入队，遇到右括号，判断栈首元素是否对应，对应即弹出队列
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if (map.containsKey(ch)){
                if (stack.isEmpty() || stack.peek()!=map.get(ch)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }   
}
```

