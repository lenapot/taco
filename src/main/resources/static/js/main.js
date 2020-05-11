$(document).ready(function(){

    $('.table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        //var text = $(this).text(); //return New or Edit

        // if (text === 'Edit') {
            $.get(href, function (order, status) {
                $('.myForm #id').val(order.id);
                $('.myForm #name').val(order.name);
                $('.myForm #status').val(order.status);
                const statusItems = $('.myForm #status option');
                $.each(statusItems, function (index, status) {
                    if (status.text == order.status) {
                        $(this).add('th:selected="true"');
                    }
                });
            });
            $('.myForm #exampleModal').modal();
            $('.modal-backdrop').removeClass("modal-backdrop");
        // } else {
        //     $('.myForm #id').val('');
        //     $('.myForm #name').val('');
        //     $('.myForm #capital').val('');
        //     $('.myForm #exampleModal').modal();
        // }
    });
});

