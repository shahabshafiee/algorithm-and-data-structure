@Echo off
@Type TextIn.txt | java Client> TextOut.txt 
java Client < TextIn.txt  > TextOut.txt