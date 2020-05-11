$(document).ready(function(){

    if ($(document)[0].referrer!= "http://localhost:8080/orders/current") {
        var rows = document.getElementById('taco-table').rows;
        var col_no = 3;
        for (var row = 0; row < rows.length; row++) {
            var cols = rows[row].cells;
            if (col_no >= 0 && col_no < cols.length) {
                cols[col_no].style.display = 'none';
            }
        }
    }
});

