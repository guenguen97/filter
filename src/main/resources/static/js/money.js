                            var money = $('#money').text();
                                var money2 = $('#money2').text();
                                var money3 = money2.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                $('#money').text(money3);

                                 var moneyP=$('.check');
                                 $(document).ready(function() {

                                     var $checkElements = $('.check');

                                      // 각 .check 요소에 대한 작업을 수행합니다.
                                      $checkElements.each(function() {
                                        // 현재 .check 요소 내에서 .price 클래스를 찾습니다.
                                        var $priceElement = $(this).find(".price");
                                        var money4 = $priceElement.text();
                                        console.log(money4);

                                        // .price2 클래스를 가진 요소를 찾습니다.
                                        var $money5 = $(this).find(".price2");

                                        // 숫자 형식을 변환하여 콤마를 추가합니다.
                                        var money6 = money4.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                        console.log(money6);

                                        // 변환된 값을 .price2 클래스를 가진 요소의 텍스트로 설정합니다.
                                        $money5.text(money6);
                                      });
                                        });

                                   function comma(str) {
                                                str = String(str);
                                                return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g, '$1,');
                                            }

                                            function uncomma(str) {
                                                str = String(str);
                                                return str.replace(/[^\d]+/g, '');
                                            }

                                            function inputNumberFormat(obj) {
                                                obj.value = comma(uncomma(obj.value));
                                            }

                                            function inputOnlyNumberFormat(obj) {
                                                obj.value = onlynumber(uncomma(obj.value));
                                            }

                                            function onlynumber(str) {
                                        	    str = String(str);
                                        	    return str.replace(/(\d)(?=(?:\d{3})+(?!\d))/g,'$1');
                                        	}
