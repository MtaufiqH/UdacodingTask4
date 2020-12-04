<?php 
include_once('connectdb.php');

if (!empty($_POST['id']) && !empty($_POST['nama']) && !empty($_POST['no_hp']) && !empty($_POST['tanggal_kunjungan']) && !empty($_POST['alamat']) && !empty($_POST['asal_sekolah']) && !empty($_POST['tujuan'])) {

	$_id = $_POST['id'];
	$nama = $_POST['nama'];
	$noHp = $_POST['no_hp'];
	$tanggal_kunjungan = $_POST['tanggal_kunjungan'];
	$alamat = $_POST['alamat'];
	$asal_sekolah = $_POST['asal_sekolah'];
	$tujuan = $_POST['tujuan'];

	$query = "UPDATE visitor SET nama = '$nama' ,no_hp = '$noHp',tanggal_kunjungan= '$tanggal_kunjungan',alamat = '$alamat', asal_sekolah = '$asal_sekolah', tujuan = '$tujuan' WHERE id = '$_id'";


	$update = mysqli_query($connect, $query);


	if ($update) {
		set_response(true, "update data Success");
	} else{
		set_response(false, "update data failed");
	}
} else{
	set_response(false, "Mohon isi data dengan lengkap!");
}



function set_response($isSuccess, $message){
	$response = array(
	'response' => $isSuccess,
	 'message' => $message
	);

	echo json_encode($response);
}


 ?>