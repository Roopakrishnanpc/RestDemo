<html>
<body>
<h2>Hello World!</h2>
simple add example<br/>
<form action='add'>
Enter num 1: <input type="text" name="num1"/><br/>
Enter num 2: <input type="text" name="num2"/><br/>
Submit: <input type="submit"/>
</form>
add Data<br/>
<!-- <form action='addModel' method="post"> -->
<form action='addModelAnother' method="post">
Enter id: <input type="text" name="id"/><br/>
Enter name: <input type="text" name="name"/><br/>
Submit: <input type="submit"/>
</form>
get by id <br/>
<form action="getMol">
Enter id: <input type="number" name="id"/><br/>
Submit: <input type="submit"/>
</form>
delete by id <br/>
<form action="deleteEntity">
Enter id: <input type="number" name="id"/><br/>
Submit: <input type="submit"/>
</form>
update by id <br/>
<form action="updateModel">
Enter id: <input type="number" name="id"/><br/>
Enter name: <input type="text" name="name"/><br/>
Submit: <input type="submit"/>
</form>
get data by name
<form action="getMolByName">
Enter name: <input type="text" name="name"/><br/>
Submit: <input type="submit"/>
</form>
</body>
</html>
