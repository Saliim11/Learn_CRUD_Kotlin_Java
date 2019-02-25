<?php  

include "connect.php";
$con = mysqli_connect(HOST,USER,PASSWORD,DATABASE);

date_default_timezone_set('Asia/Jakarta');
$date = date("Y-m-d H:i:s");

$response = array();

// $_POST['tanda_jadi']='tanda_jadi';
// $_POST['create_by']='1';

$id = $_GET['id'];
$tanda_jadi = $_GET['tanda_jadi'];
$modified = date('Y-m-d H:i:s');
$mod_by = $_GET['mod_by'];

$sql = "UPDATE tanda_jadis SET tanda_jadi = '$tanda_jadi', modified = '$modified', mod_by = '$mod_by' WHERE id = '$id' ";  
// print_r($sql);exit;

$result = mysqli_query($con, $sql);

if ($result) {
    $resp["status"] = "1";
    $resp["message"] = "Update successfully"; 
    $resp["tanda_jadi"] = $tanda_jadi;
    $resp["mod_by"] = $mod_by; 
}else{
	$resp["status"] = "0";
    $resp["message"] = "Update not successfully"; 
}

$response=$resp;  
echo json_encode($response);  

mysqli_close($con);

?>