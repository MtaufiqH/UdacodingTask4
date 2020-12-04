<?php

include_once('connectdb.php');

if (!empty($_POST['id'])) {
	
	$_id = $_POST['id'];

	$query = "DELETE FROM visitor WHERE id = '$_id'";
	$delete = mysqli_query($connect, $query);


	if ($delete) {
		set_response(true, "delete data success");
	} else{
		set_response(false, "delete data failed");
	}
} else{
	set_response(false, "id wajib diisi.!");
}


function set_response($isSuccess, $message){
	$result = array(
	'response' => $isSuccess,
	 'message' => $message
	);

	echo json_encode($result);
}



?>