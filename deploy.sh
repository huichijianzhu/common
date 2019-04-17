#!/usr/bin/env bash
# 安装hjmall-common站点

#需要配置如下参数
# 项目路径,在Execute Shell中配置项目路径,pwd就可以获得该项目路径
# export PROJ_PATH=这个Jenkins任务在部署机器上的路径

cd $PROJ_PATH/
mvn clean install




