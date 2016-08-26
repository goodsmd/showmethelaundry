<?php
    $con=mysqli_connect("localhost","wbatw2003","tldk0914","wbatw2003");
    
    $item_startdate = $_POST["item_startdate"];
    $item_enddate = $_POST["item_enddate"];
    $item_name = $_POST["item_name"];
    $item_quantity = $_POST["item_quantity"];
    $how_to_pay = $_POST["how_to_pay"];
    $user_name = $_POST["user_name"];
    $user_phone = $_POST["user_phone"];
    $item_order = $_POST["item_order"];

    $statement = mysqli_prepare($con, "INSERT INTO LaundryItem (item_startdate, item_enddate, item_name, item_quantity, how_to_pay, user_name, user_phone, item_order) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sssiissi", $item_startdate, $item_enddate, $item_name, $item_quantity, $how_to_pay, $user_name, $user_phone, $item_order);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);

?>
