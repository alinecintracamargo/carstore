<html>
<body>
<h2>Create Car</h2>

<form action="/create-car" method="post" enctype="multipart/form-data">

    <div>
        <label for="car-name" >Car Name</label>
        <input type="text" name="car-name" id="car-name">
    </div>
    <br>
    <div>
        <label for="image">Image</label>
        <input type="file" name="image" id="image">
    </div>
    <br>

    <button type="submit">Save</button>

</form>

</body>
</html>