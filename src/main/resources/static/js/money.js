                            var money = $('#money').text();
                                var money2 = $('#money2').text();
                                var money3 = money2.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
                                $('#money').text(money3);

                                    var moneyP=$('.check')
                                     var money4 = money.find(".price");



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
