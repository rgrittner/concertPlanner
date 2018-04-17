$(document).ready(function() {
    $('#resultTable').DataTable();

    $("button").on("click", function() {
        console.log("you clicked: " + $(this).text());
    })
})