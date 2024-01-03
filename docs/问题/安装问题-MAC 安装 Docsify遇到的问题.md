用官方文档命令，第一步可以，但第二步提示命令不存在。

```bash
npm i docsify-cli -g
docsify init ./docs
```

环境变量的问题，之前指定的路径不对

```bash
echo -e "export PATH=$(npm prefix -g)/bin:$PATH" >> ~/.bash_profile && source ~/.bash_profile
```
