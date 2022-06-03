[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=7202974&assignment_repo_type=AssignmentRepo)
# java-template 
<h1>Eliachar Feig</h1>
<ol>
<li>Eliachar Feig</br> eliacharfe@edu.hac.ac.il </br> efeig15@gmail.com</li>
</ol>

<h1>1. Compilation</h1>
<p>Use the IntelliJ configuration to build the project.</p>

<h1>2. Execution</h1>
<p>java Main -[commands] [URL] [name of file] </br> 
[commands] : </br>
a - to exract links of the html </br>
i - to extract images of the html </br>
h - extract all h1 tags of the html </br>
Those are basic command comes with the program, if you want add a new command, for example "p", you need </br>
to create a class "Paragraph" that implements "OptionReader" and add the line "Paragraph.register("p")" </br>
at the function registerAll() in AppDriver class. </br>
[URL] : </br> 
A full path URL including https:// </br>
[name of file] : </br>
For the output, all the extracted data will be written in the file in order of the commands
</p>
<h2>Configurations</h2>
<p>java Main -[commands] [URL] [name of file] </br>
for example, if we want to run test1 configuration, we need to choose Edit configuration </br>
and in the list of argument we could write: -a https://docs.oracle.com/en/java/javase/17/ output1 </br>
and then run the program</p>
<h2>Terminal based execution</h2>
<p>None</p>
<p></br></p>
<pre>
cd out/production/&lt;dirname&gt;<br/>
java hac.Main </br>
java.hac.AppDriver </br>
java.hac.BufferedWriterSingleton </br>
java.hac.DocumentSingleton </br>
java.hac.WriteToFile </br>
java.hac.library.OptionReader </br>
java.hac.library.OptionReaderCreateCommand </br>
java.hac.library.OptionReaderFactory </br>
java.hac.uses_factory.Image </br>
java.hac.uses_factory.Link </br>
java.hac.uses_factory.Title </br>
java.hac.exception.InvalidCommand </br>
java.hac.exception.BadURL </br>
java.hac.exception.Error </br>
</pre>
<h1>3. Documentation</h1>
<p>Link to <a href="https://docs.oracle.com/javase/7/docs/api/">project API (javadoc)</a>.</p>
<h1>4.Possible tests: </h1>
<p>
java Main -a https://docs.oracle.com/en/java/javase/17/ out1 </br>
java Main -ai https://www.w3schools.com out2 </br>
java Main -hia https://docs.oracle.com/en/java/javase/17/docs/api/index.html out3 </br>
java Main -ih https://docs.oracle.com/en/java/javase/17/docs/api/index.html out4 </br>
java Main -ahi https://docs.oracle.com/en/java/javase/17 out5 </br>
</p>
<h1> Design patterns </h1>
<p>
Factory: The program uses Factory in order to create options commands, means that if we want </br>
to add a new otion command to the program we don't need to change the existing program, what </br>
we need to do is create a new class that implements "OptionReader" interface (look at "Link" class </br>
or "Image" class for example). Let's say we want to add a command "p" to extract the paragraphs </br>
of an html, we create a class "Paragraph" in the same pattern of class "Link" (or "Image" or "Title) </br>
and add the line "Paragraph.register("p")" in the function "regiterAll()" in "AppDriver" class. </br></br>
Singleton: 2 singletons class to create the Document and the BufferedWriter, basically I create </br>
in the program those just once, but created them as singleton to assure that if someone accidently </br>
will create another time in the program one of them, it will point to the same object. </br>
  
</p>
<h1>4. Assumptions</h1>
<p>
  
</p>
