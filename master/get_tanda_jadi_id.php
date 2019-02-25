<?php  

include "connect.php";

$con = mysqli_connect(HOST,USER,PASSWORD,DATABASE); 
$id = $_GET['id'];

$reference = "select * from tanda_jadis where id = '$id'";
$resultReference = mysqli_query($con, $reference);

$response = array();
while($rowId = mysqli_fetch_array($resultReference)){
    array_push($response,array('id'=>$rowId['id'],
    'tanda_jadi'=>$rowId['tanda_jadi'], 
    'created'=>$rowId['created'], 
    'create_by'=>$rowId['create_by'],
    'modified'=>$rowId['modified'],
    'mod_by'=>$rowId['mod_by']));
};

echo json_encode($response);
?>