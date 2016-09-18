<?php
    $con=mysqli_connect("localhost","wbatw2003","tldk0914","wbatw2003");
    
    $user_email = $_POST["user_email"];
    $user_password = $_POST["user_password"];
    $user_name = $_POST["user_name"];
    $user_phone = $_POST["user_phone"];
    $user_address = $_POST["user_address"];

    $statement = mysqli_prepare($con, "INSERT INTO information (user_email, user_password, user_name, user_phone, user_address) VALUES (?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "sssss", $user_email, $user_password, $user_name, $user_phone, $user_address);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);

    if($con){
        echo 1;
    }
?>
