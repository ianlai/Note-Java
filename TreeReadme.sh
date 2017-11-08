#!/bin/bash

# Usage: ./TreeReadme.sh README.md
# Note : This will DELETE the original file (README) 

os="$(uname -s)"

echo "## Project Tree" > $1
echo "\`\`\`" >> $1     
tree --noreport -I 'bin' >> $1
echo "\`\`\`" >> $1
#sed -i '1s/^/```/' $1  #Insert to the top (not necessary)

### Mac OSX
if [ $os == "Darwin" ]; then 
    quizNum=$(find -E . -regex '^.+[_]{1}[0-9]{3}.+java$' | nl | tail -1 | awk '{print $1}')
### Others (Linux) 
else
    quizNum=$(find . -regextype posix-extended -regex '^.+[_]{1}[0-9]{3}.+java$' | nl | tail -1 | awk '{print $1}')
fi
totalNum=$(find . -name '*.java' | nl | tail -1 | awk '{print $1}')

echo "* Total Number: $totalNum" >> $1
echo "* Quiz  Number: $quizNum"  >> $1
