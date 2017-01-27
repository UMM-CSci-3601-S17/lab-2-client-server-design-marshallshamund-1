**Exploring the project
~What is the purpose of .gitignore?
    Tells git what files to intentionally ignore


**Exploring the server
~Explain what a route is?
    The process of entering a path and receiving a result (from one page to another).
     
~What is the purpose of umm3601.Server?
    Redirects you to an html file

~What is the purpose of the umm3601.user.Usercontroller class? 
    Filters the data based on a key word
    
~Explain what happens when a user accesses each of the following URLs:
    -users
       Non-formatted list of users comes up (after hitting Get All Users)
    -api/users
         You get a list of all the users and their info
    -api/users?age=25
        Returns list of users who are 25 years old
    -api/users/588935f5de613130e931ffd5
        returns the information of the user with the id number 588935f5de613130e931ffd5
     
~What happens when the user accesses the page "kittens"?3
    Page not found
    
~Modify the server code so accessing the page "kittens" 
~results in the text "Meow". Describe what you did and how it worked.
    We changed the server code by adding another get line identical to the hello world one.
    

**Exploring the client
~What are the contents of the public folder? What is the purpose of each of the HTML files there?
    Folders containing code for setting up the web pages. 
    There are 3 HTML files that are the main pages of the website.
    
~Describe what happens when you filter users by age in the client? 
    WILL NEED TO ANSWER LATER!!
    
~Where is the client-side JavaScript defined? Name the file(s) in which it is used.
    It's defined in the users.js file in the javascript folder. It's used in resources/public/javascript