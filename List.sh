#quizNum!/bin/bash
os="$(uname -s)"

### Mac OSX
if [ $os == "Darwin" ]; then 
    find -E . -regex '^.+[_]{1}[0-9]{3}.+java$' | awk -F '/' '{print $5}' | awk -F '_' '{print $2 " " $3}' | sort
    quizNum=$(find -E . -regex '^.+[_]{1}[0-9]{3}.+java$' | wc -l | awk '{print $1}')
### Others (Linux) 
elif [ $os == "Linux" ]; then
    find . -regextype posix-extended -regex '^.+[_]{1}[0-9]{3}.+java$' | awk -F '/' '{print $5}' | awk -F '_' '{print $2 " " $3}' | sort
    quizNum=$(find . -regextype posix-extended -regex '^.+[_]{1}[0-9]{3}.+java$' | wc -l | awk '{print $1}')

fi

echo "=============================" 
echo "* Quiz Java Number: $quizNum"  
