   (function($){

         $.fn.imagePicker = function(options){
            
                 var settings = $.extend({

                        name: "",
                        class: "form-control btn btn-default btn-block",
                        icon: "glyphicon glyphicon-plus"
                 },options);
                
                     return this.each(function(){
                          $(this).html(create_btn(this,settings));
                     });
         }


       })(jQuery);

       function create_btn(that,settings)
       {
           var picker_btn_icon = $("<i class='"+settings.icon+"'></i>");

           var picker_btn_input = $("<input type='file' name='"+settings.name+"'/>");

           var picker_btn = $("<div class='"+settings.class+" img-upload-btn'></div>")
                              .append(picker_btn_icon)
                              .append(picker_btn_input);


                              picker_btn_input.change(function(){
                                    
                                    if($(this).prop('files')[0]){

                                        var reader = new FileReader();

                                        reader.onload = function(e){

                                          var preview = create_preview(that,e.target.result,settings);

                                          $(that).html(preview);
                                        }

                                        reader.readAsDataURL(picker_btn_input.prop('files')[0]);
                                    }

                              });

                              return picker_btn;
       }  ;


       function create_preview(that, src, settings)
       {

          var picker_preview_image = $("<img src='"+src+"' class='img-responsive img-rounded'/>");

          var picker_preview_remove = $('<button class="btn btn-link"><small>Remove</small></button>');

          var picker_preview = $("<div class='text-center'></div>")
                                .append(picker_preview_image)
                                .append(picker_preview_remove);

                                picker_preview_remove.click(function(){

                                    var btn = create_btn (that,settings);
                                    $(that).html(btn);
                                });

          return picker_preview; 
       }     
       
