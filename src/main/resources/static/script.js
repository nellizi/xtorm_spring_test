function ajax_upload(){
console.log("work?");
var formData = new FormData($('#createForm')[0]);

$.ajax({
	type: 'POST',
	enctype: 'multipart/form-data',
	url: '/multipartUpload.do',
	data: formData,
	processData: false,
	contentType: false,
	cache: false,
	success: function (msg) {
	    alert(msg);
	},
	error: function (msg) {
	    alert(msg);
	}
});

}


function ajax_download(){
var formData = new FormData($('#downloadForm')[0]);

$.ajax({
	type: 'POST',
	enctype: 'multipart/form-data',
	url: '/multipartDownload.do',
	data: formData,
	processData: false,
	contentType: false,
	cache: false,
	success: function () {
	    console.log("ajax 다운로드 성공");
	    alert("파일 다운로드 성공.");
	},
	error: function (e) {
	}
});

}

function ajax_delete(){
var formData = new FormData($('#deleteForm')[0]);

$.ajax({
	type: 'POST',
	enctype: 'multipart/form-data',
	url: '/multipartDelete.do',
	data: formData,
	processData: false,
	contentType: false,
	cache: false,
	success: function () {
	    console.log("ajax 삭제 성공");
	    alert("파일 삭제 성공.");
	},
	error: function (e) {
	}
});

}
