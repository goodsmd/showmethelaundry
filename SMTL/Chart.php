<?php
    $con=mysqli_connect("localhost","wbatw2003","tldk0914","wbatw2003");
        
    
    $statement = mysqli_prepare($con, "SELECT * FROM ChartTest;");
   
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $field1, $field2, $field3, $field4);

    $response = array();
    $response["success"] = false; 

    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["field1"] = $field1;
        $response["field2"] = $field2;
        $response["field3"] = $field3;
        $response["field4"] = $field4;
    }
    
    echo json_encode($response);

    
?>