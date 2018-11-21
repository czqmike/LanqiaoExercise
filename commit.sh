#!/bin/bash
echo "Please input message of commit:"
read MESSAGE
if [ -z $MESSAGE ];then 
    echo "[ERROR]No meassage, exit."
    exit -1
else
    git add src
    git commit -m "$MESSAGE"
    git push origin master
fi
exit 0
