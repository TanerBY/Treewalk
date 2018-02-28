# Treewalk

This project has been developed by Taner BUYUKYILDIZ as a technical test.

The project is expected to take in a text file that has review relations of authors and output the tree structure of those relations.

The project reads the file from the resource, parsing the relations one by one, creating the links between the authors using a simple tree structure. After creating the tree nodes , they are put in a person pool (HashMap) and once they appear again in the text file, grab the existing user from the pool , if it does not exist, create a new one and put in the pool. 

After the process is complete, the project finds the root node in the persons pool and sends it to the recursive function which then prints out the contents in a previously decided format depending on the relation and the depth of the tree.
