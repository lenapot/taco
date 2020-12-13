$(document).ready(function(){

    $('.table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
            $.get(href, function (order, status) {
                $('.editOrderForm #id').val(order.id);
                $('.editOrderForm #name').val(order.name);
                $('.editOrderForm #status').val(order.status);
                const statusItems = $('.editOrderForm #status option');
                $.each(statusItems, function (index, status) {
                    if (status.text == order.status) {
                        $(this).add('th:selected="true"');
                    }
                });
            });
            $('.editOrderForm #editOrderModal').modal();
            $('.modal-backdrop').removeClass("modal-backdrop");
    });
});

