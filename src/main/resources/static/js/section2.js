                var optionPrice=null;
                $(document).ready(function() {

                             let tagIds = [];
                           var text = $(".check");
                           console.log(text);
                        text.click(function() {
                            var checkbox = $(this).find("input[type='checkbox']");
                            var radio = $(this).find("input[type='radio']");
                            var num = $(this).attr("value");

                            optionPrice = $(".option-price").text();
                            var currentPrice =  parseFloat(optionPrice, 10);
                            var otherPrice = parseFloat(num, 10);

                            var optionItem = document.getElementById('box');

                            console.log(optionItem);
                            if (checkbox.prop("checked")) {

                                 checkbox.prop("checked", false);
                                 radio.prop("checked", false);
                                 $(".option-price").text(currentPrice-otherPrice);
                                tagIds=tagIds.filter((element) => element !== $(this).attr("optionId"));
                                         var money = $('#money').text();
                                       var money2 = $('#money2').text();
                                              var money3 = money2.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                $('#money').text(money3);
                                    } else {
                                       checkbox.prop("checked", true);
                                       radio.prop("checked", true);
                                         $(".option-price").text(currentPrice+otherPrice);
                                             tagIds.push($(this).attr("optionId"));
                                            var money = $('#money').text();
                                        var money2 = $('#money2').text();
                                         var money3 = money2.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                            $('#money').text(money3);
                                                console.log(tagIds);
                                  }
                        });


                    });



            $(".option-box-img").on("click", function() {
                           var imgUrl = $(this).attr("data-img-url");
                           var informationText = $(this).attr("information-text");;
                           $(".img-item1").attr("src", imgUrl);
                           $(".information-text").text(informationText);
                       });

           function doCheck(clickedDiv) {
          var c = clickedDiv.closest('.option-item');

          c.classList.toggle('border-highlight2');
        }

