<#import "/spring.ftl" as spring/>

<html>
<head>
<title>Book List</title>
<link rel="stylesheet"
           type="text/css"
           href="<@spring.url '/css/style.css'/>"/>
   </head>
   <body>
     <h3>Book List</h3>

      <div>

         <table border="1">
            <tr>
               <th>Book Id</th>
                <th>Book Name</th>
                 <th>Book Description</th>
                 <th>YearOfPublication</th>
                <th>Type</th>
            </tr>
            <#list books as book>
            <tr>
                <td>${book.id}</td>
                <td>${book.name}</td>
                <td>${book.description}</td>
                <td>${book.yearOfPublication}</td>
                <td>${book.bookType}</td>

           </tr>
            </#list>
         </table>
      </div>
   </body>
</html>