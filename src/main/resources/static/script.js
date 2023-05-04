function ajax_upload(){

console.log("work?");
alert("alert");
var formData = new FormData($('#createForm')[0]);

$.ajax({
	type: 'POST',
	enctype: 'multipart/form-data',
	url: '/multipartUpload.do',
	data: formData,
	processData: false,
	contentType: false,
	cache: false,
	success: function (data) {
	    alert(data.msg);
	},
	error: function (data) {
	    alert(data.fail);
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
	success: function (data) {
    	    alert(data.msg);
    	},
    	error: function (data) {
    	    alert(data.fail);
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
success: function (data) {
	    alert(data.msg);
	},
	error: function (data) {
	    alert(data.fail);
	}
});

}