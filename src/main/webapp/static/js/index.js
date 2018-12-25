<script type="text/javascript">
    function refurbishIndex(){

        var optionJson=[];
        $.ajax({
            type:"post",
            url:"/easyuiIndexTable",
            data:{},
            async: false,
            success:function (data) {
                optionJson=data;

                var str="";

                str+="<tr>"+
                    "<td>"+optionJson.totalNumber+"</td>"+
                    "<td>"+optionJson.actualNumber+"</td>"+
                    "<td>"+optionJson.highScore+"</td>"+
                    "<td>"+optionJson.lowScore+"</td>"+
                    "<td>"+optionJson.avgScore+"</td>"+
                    "<td>"+optionJson.variance+"</td>"+
                    "</tr>";

                document.getElementById("tbodydata").innerHTML=str;


            }
        });
    }
    </script>