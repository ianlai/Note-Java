#!/bin/bash

# Usage: ./TreeReadme.sh 
# Note : This will DELETE the current README.md 

os="$(uname -s)"
file="README.md"

echo "## Project Tree" > $file
echo "\`\`\`" >> $file     
tree --noreport -I 'bin' >> $file
echo "\`\`\`" >> $file
#sed -i '1s/^/```/' $file  #Insert to the top (not necessary)

### Mac OSX
if [ $os == "Darwin" ]; then 
    quizNum=$(find -E . -regex '^.+[_]{1}[0-9]{3}.+java$' | nl | tail -1 | awk '{print $1}')
### Others (Linux) 
elif [ $os == "Linux" ]; then
    quizNum=$(find . -regextype posix-extended -regex '^.+[_]{1}[0-9]{3}.+java$' | nl | tail -1 | awk '{print $1}')
fi
totalNum=$(find . -name '*.java' | nl | tail -1 | awk '{print $1}')

echo "## Quiz List" >> $file
./List.sh >> $file 

echo "** Total Java Number: $totalNum" >> $file
