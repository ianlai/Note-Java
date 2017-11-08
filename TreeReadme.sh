#!/bin/bash

# Usage: ./TreeReadme.sh README.md
# Note : This will DELETE the original file (README) 

echo "## Project Tree" > $1
echo "\`\`\`" >> $1     
tree --noreport -I 'bin' >> $1
echo "\`\`\`" >> $1
#sed -i '1s/^/```/' $1  #Insert to the top (not necessary)

quizNum=$(find . -regextype posix-extended -regex '^.+[_]{1}[0-9]{3}.+$' | nl | tail -1 | awk '{print $1}')
totalNum=$(find . -name '*.java' | nl | tail -1 | awk '{print $1}')

echo "* Total Number: $totalNum" >> $1
echo "* Quiz  Number: $quizNum"  >> $1
