---
title: LeetCode-P1108
date: 2024-05-15 10:27:21
updated: 2024-05-15 10:33:40
categories: LeetCode
tags:
  - LeetCode
  - 字符串
---
## 题目

>给你一个有效的 [IPv4](https://baike.baidu.com/item/IPv4) 地址 `address`，返回这个 IP 地址的无效化版本。
>
>所谓无效化 IP 地址，其实就是用 `"[.]"` 代替了每个 `"."`。
>
> 
>
>**示例 1：**
>
>```
>输入：address = "1.1.1.1"
>输出："1[.]1[.]1[.]1"
>```
>
>**示例 2：**
>
>```
>输入：address = "255.100.50.0"
>输出："255[.]100[.]50[.]0"
>```
>
> 
>
>**提示：**
>
>- 给出的 `address` 是一个有效的 IPv4 地址

## 思路

String 的 `replace()` 可以替换我们想要替换的字符串

```java
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
```

