<?php 

include_once('connectdb.php');

if (!empty($_GET['id'])) {
	$id = $_GET['id'];
	$query = "SELECT * FROM visitor WHERE id= '$id'";
} else{
	$query = "SELECT * FROM visitor";

}


$get = mysqli_query($connect, $query);
$visitor = array();
if (mysqli_num_rows($get) > 0) {
	while ($row = mysqli_fetch_assoc($get)) {
		$visitor[] = $row;
	}

	set_response("fetch data success", $visitor);


}else{
	set_response("failed to fetch data", $visitor);
}


function set_response($message, $visitor){

	$result= array('status' => $message, 'visitor' => $visitor);

	echo json_encode($result);

}


?>