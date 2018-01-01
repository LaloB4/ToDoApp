function confirmDelete(){
	let confirmation = confirm("Do you really want to delete this task?");
	$(this).value = confirmation;
}