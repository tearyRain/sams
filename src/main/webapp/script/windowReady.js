function clickAction() {
    $.ajax({
        url: "add.action",
        type: "post",
        data: JSON.stringify({"age": 12, "person": {"name": "aaa", "age": 12}}),
        contentType: 'application/json',
        success: function (data, textStatus) {
            alert(JSON.stringify(data));
            $('#para1').html(JSON.stringify(data));
            $('#para2').html(textStatus);
        },
        dataType: "json"
    });
}

$(document).ready(function () {
    $.ajax({
        url: "add.action",
        type: "post",
        data: JSON.stringify({"age": 12, "person": {"name": "aaa", "age": 12}}),
        contentType: 'application/json',
        success: function (data, textStatus) {
            alert(JSON.stringify(data));
            $('#para1').html(JSON.stringify(data));
            $('#para2').html(textStatus);
        },
        dataType: "json"
    });
})
$(document).ready(function () {
    alert("Hello");
})
$(document).ready(function () {
    alert("World");
})
$('#b1').click(clickAction);