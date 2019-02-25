<?php  

include "connect.php";
$con = mysqli_connect(HOST,USER,PASSWORD,DATABASE);

date_default_timezone_set('Asia/Jakarta');
$date = date("Y-m-d H:i:s");

$response = array();

// $_POST['tanda_jadi']='tanda_jadi';
// $_POST['create_by']='1';

$tanda_jadi = $_GET['tanda_jadi'];
$create_by = $_GET['create_by'];

$sql = "INSERT INTO tanda_jadis(id, tanda_jadi, created, create_by) VALUES(UUID(),'$tanda_jadi','".date('Y-m-d')."','$create_by')";
// print_r($create_by);exit;

$result = mysqli_query($con, $sql);

if ($result) {
    $resp["status"] = "1";
    $resp["message"] = "Create successfully"; 
    $resp["tanda_jadi"] = $tanda_jadi;
    $resp["create_by"] = $create_by; 
}else{
	$resp["status"] = "0";
    $resp["message"] = "Create not successfully"; 
}

$response=$resp;  
echo json_encode($response);  

mysqli_close($con);

?>