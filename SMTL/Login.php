<?php
    $con=mysqli_connect("localhost","wbatw2003","tldk0914","wbatw2003");
    
    $user_email = $_POST["user_email"];
    $user_password = $_POST["user_password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM information WHERE user_email = ? AND user_password = ?");
    mysqli_stmt_bind_param($statement, "ss", $user_email, $user_password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $user_email, $user_password, $user_name, $user_phone, $user_address);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["user_email"] = $user_email;
        $response["user_password"] = $user_password;
        $response["user_name"] = $user_name;
        $response["user_phone"] = $user_phone;
        $response["user_address"] = $user_address;
    }
    
    echo json_encode($response);

      if($con){
        echo 1;
    }
?>
