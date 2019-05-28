jQuery(function ($) {

    var oTable1 = $('#sample-table-2').dataTable({

        "aoColumns": [

            {"bSortable": false},

            null, null, null, null, null,

            {"bSortable": false}

        ]
    });


    $('table th input:checkbox').on('click', function () {

        var that = this;

        $(this).closest('table').find('tr > td:first-child input:checkbox')

            .each(function () {

                this.checked = that.checked;

                $(this).closest('tr').toggleClass('selected');

            });


    });


    $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});

    function tooltip_placement(context, source) {

        var $source = $(source);

        var $parent = $source.closest('table')

        var off1 = $parent.offset();

        var w1 = $parent.width();


        var off2 = $source.offset();

        var w2 = $source.width();


        if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';

        return 'left';

    }


    var colorbox_params = {

        reposition: true,

        scalePhotos: true,

        scrolling: false,

        previous: '<i class="icon-arrow-left"></i>',

        next: '<i class="icon-arrow-right"></i>',

        close: '&times;',

        current: '{current} of {total}',

        maxWidth: '100%',

        maxHeight: '100%',

        onOpen: function () {

            document.body.style.overflow = 'hidden';

        },

        onClosed: function () {

            document.body.style.overflow = 'auto';

        },

        onComplete: function () {

            $.colorbox.resize();

        }

    };


    $('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);

    $("#cboxLoadingGraphic").append("<i class='icon-spinner orange'></i>");//let's add a custom loading icon


});

deleteGoods = function (goodsId) {
    $.ajax({
        type: "post",
        url: '/goods/delete/' + goodsId,
        data: goodsId,
        dataType: 'json',
        contentType: 'application/json;charset=UTF-8',
        success: function (result) {
            console.log(result);
            if (result.code == 200) {
                let data = "#" + result.data;
                $(data).remove();
            }
            alert(result.message);


        }
    });
}