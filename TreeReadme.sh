#!/bin/bash

# Usage: ./TreeReadme.sh README.md
# Note : This will DELETE the original file (README) 

echo "## Project Tree" > $1
echo "\`\`\`" >> $1     
tree --noreport -I 'bin' >> $1
echo "\`\`\`" >> $1
#sed -i '1s/^/```/' $1  #Insert to the top (not necessary)

