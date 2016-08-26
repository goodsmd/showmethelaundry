<?php
    $con=mysqli_connect("localhost","wbatw2003","tldk0914","wbatw2003");
    
    $item = $_POST["item"];


    $statement = mysqli_prepare($con, "INSERT INTO test (clothes) VALUES (?)");
    mysqli_stmt_bind_param($statement, "s", $item);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);

    if($con){
        echo 1;
    }
?>
