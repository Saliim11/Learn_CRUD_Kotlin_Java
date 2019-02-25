<?php  

include "connect.php";

$con = mysqli_connect(HOST,USER,PASSWORD,DATABASE);

$id = $_GET['id'];

$sql = "DELETE from tanda_jadis WHERE id = '$id'";

$result = mysqli_query($con, $sql);

$response = array();
if($result){
    $resp["status"] = 1;
    $resp["message"] = "Delete successfully"; 
} else{
    $resp["status"] = 0;
    $resp["message"] = "Delete Unsuccessfully"; 
}

$response=$resp;  
echo json_encode($response);  
mysql_close();

?>