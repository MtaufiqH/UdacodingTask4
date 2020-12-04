<?php 
include_once('connectdb.php');

if (!empty($_POST['nama']) && !empty($_POST['no_hp']) && !empty($_POST['tanggal_kunjungan']) && !empty($_POST['alamat']) && !empty($_POST['asal_sekolah']) && !empty($_POST['tujuan'])) {
	$nama = $_POST['nama'];
	$noHp = $_POST['no_hp'];
	$tanggal_kunjungan = $_POST['tanggal_kunjungan'];
	$alamat = $_POST['alamat'];
	$asal_sekolah = $_POST['asal_sekolah'];
	$tujuan = $_POST['tujuan'];

	$query = "INSERT INTO visitor(nama,no_hp,tanggal_kunjungan,alamat, asal_sekolah, tujuan)
			 VALUES ('$nama', '$noHp', '$tanggal_kunjungan', '$alamat', '$asal_sekolah', '$tujuan')";
	$insert = mysqli_query($connect, $query);


	if ($insert) {
		set_response(true, "success insert data");
	} else{
		set_response(false, "failed insert data");
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