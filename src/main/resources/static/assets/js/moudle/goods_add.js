jQuery(function ($) {


    // 时间
    $('.date-picker').datepicker({autoclose: true}).next().on(ace.click_event, function () {

        $(this).prev().focus();

    });

    //images upload
    $('#images').ace_file_input({

        style: 'well',

        btn_choose: '拖拽上传或者点击上传图片',

        btn_change: "icon-picture",

        no_icon: 'icon-cloud-upload',

        droppable: true,

        thumbnail: 'fit',//large | fit

        before_change: function (files, dropped) {

            var allowed_files = [];

            for (var i = 0; i < files.length; i++) {

                var file = files[i];

                if (typeof file === "string") {

                    //IE8 and browsers that don't support File Object

                    if (!(/\.(jpe?g|png|gif|bmp)$/i).test(file)) return false;

                } else {

                    var type = $.trim(file.type);

                    if ((type.length > 0 && !(/^image\/(jpe?g|png|gif|bmp)$/i).test(type))

                        || (type.length == 0 && !(/\.(jpe?g|png|gif|bmp)$/i).test(file.name))//for android's default browser which gives an empty string for file.type

                    ) continue;//not an image so don't keep this file

                }


                allowed_files.push(file);

            }

            if (allowed_files.length == 0) return false;


            return allowed_files;

        }


        //,icon_remove:null//set null, to hide remove/reset button

        /**,before_change:function(files, dropped) {

                    //Check an example below

                    //or examples/file-upload.html

                    return true;

                }*/

        /**,before_remove : function() {

                    return true;

                }*/

        ,

        preview_error: function (filename, error_code) {

            //name of the file that failed

            //error_code values

            //1 = 'FILE_LOAD_FAILED',

            //2 = 'IMAGE_LOAD_FAILED',

            //3 = 'THUMBNAIL_FAILED'

            //alert(error_code);

        }


    }).on('change', function () {

        //console.log($(this).data('ace_input_files'));

        //console.log($(this).data('ace_input_method'));

    });


    //we could just set the data-provide="tag" of the element inside HTML, but IE8 fails!
    //配置亮点的tag 控制
    var tag_input = $('#configs');

    if (!(/msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()))) {

        tag_input.tag(
            {

                placeholder: tag_input.attr('placeholder'),

                //enable typeahead by specifying the source array

                source: ace.variable_US_STATES,//defined in ace.js >> ace.enable_search_ahead

            }
        );

    } else {

        //display a textarea for old IE, because it doesn't support this plugin or another one I tried!

        tag_input.after('<textarea id="' + tag_input.attr('id') + '" name="' + tag_input.attr('name') + '" rows="3">' + tag_input.val() + '</textarea>').remove();

        //$('#configs').autosize({append: "\n"});

    }

    $('#transferNum').ace_spinner({
        value: 0,
        min: 0,
        max: 20,
        step: 1,
        btn_up_class: 'btn-info',
        btn_down_class: 'btn-info'
    })
        .on('change', function () {

            //alert(this.value)

        });

    $('#outputVolume').ace_spinner({
        value: 0.00,
        min: 0.00,
        max: 30.0000,
        step: 1.00,
        btn_up_class: 'btn-info',
        btn_down_class: 'btn-info'
    })
        .on('change', function () {

            //alert(this.value)

        });

    $('#distance').ace_spinner({
        value: 0,
        min: 0,
        max: 10000000,
        step: 1,
        btn_up_class: 'btn-info',
        btn_down_class: 'btn-info'
    })
        .on('change', function () {

            //alert(this.value)

        });


    $('#price').ace_spinner({
        value: 0,
        min: 0,
        max: 30.000,
        step: 0.1,
        btn_up_class: 'btn-info',
        btn_down_class: 'btn-info'
    })
        .on('change', function () {

            //alert(this.value)

        });


});
