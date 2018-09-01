$(function(){
	
});

function viewCont(id){
	window.location.href = ctx + "/contract/downContFile.ajax?contId=" + id;
}
function viewPay(id){
	window.location.href = ctx + "/contract/downPaycert.ajax?paymentId=" + id;
}