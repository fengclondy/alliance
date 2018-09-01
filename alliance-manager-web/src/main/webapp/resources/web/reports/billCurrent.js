/**
 * Created by wuqiang6 on 2017/7/24.
 */
$(function(){
    $( "#autocomplete" ).autocomplete({
        source: function(request, response){
            $.ajax({
                url:  ctx + "/cust/listCust4Query.ajax",
                type:"post",
                data:{
                    custName:$("#autocomplete").val()
                },
                success:function(cr){
                    var list = cr.reModel;
                    response($.map(list,function(item){
                        var name = item.custName;
                        var id = item.custId;
                        return {
                            label:item.custName,//下拉框显示值
                            value:item.custName,//选中后，填充到下拉框的值
                            id:item.custId//选中后，填充到id里面的值
                        }
                    }));
                }
            });
        },
        delay: 500,//延迟500ms便于输入
        select : function(event, ui) {
            $("#custId").val(ui.item.id);
        }
    });

    newQuery();
});

var obj = new Object();
function newQuery(){
    obj = new Object();
    obj.custId = $("#s_custId").val();
    obj.custName = $("#autocomplete").val();

    if(obj.custName == "") {
        $("#s_custId").val("");
        obj.custId = "";
    }
    reportBill(1,8,1);
    reportBill(1,8,2);
    reportBill(1,8,3);
    reportBill(1,8,4);
}

function page(n,s){
    if($("#table1").hasClass("on")) {
        //报表1
        reportBill(n,s,1);
    }
    if($("#table2").hasClass("on")) {
        //报表2
        reportBill(n,s,2);
    }
    if($("#table3").hasClass("on")) {
        //报表3
        reportBill(n,s,3);
    }
    if($("#table4").hasClass("on")) {
        //报表3
        reportBill(n,s,4);
    }
}

function reportBill(n,s,ii) {
    var index = layer.load(2);
    var custId = "";
    var custName = "";
    if(obj != null){
        custId = obj.custId;
        custName = obj.custName;
    }

    var url = ctx + "/reports";

    switch (ii) {
        case 1 : url += "/dayCurMonthlyPage.ajax";break;
        case 2 : url += "/custCurMonthlyPage.ajax";break;
        case 3 : url += "/regionCurMonthlyPage.ajax";break;
        case 4 : url += "/goodsCurMonthlyPage.ajax";break;
        default : ;
    }

    $.ajax({
        url: url,
        type: "POST",
        dataType:"json",
        data:{
            pageNo:n,
            pageSize:s,
            custId:custId,
            custName:custName
        },
        success : function (cr) {
            layer.close(index);
            if(cr.reType){
                switch (ii) {
                    case 1 : reportBillDay(cr.reModel);break;
                    case 2 : reportBillCust(cr.reModel);break;
                    case 3 : reportBillRegion(cr.reModel);break;
                    case 4 : reportBillGoods(cr.reModel);break;
                    default : ;
                }
            }else{
                layer.alert(cr.msg);
            }
        }
    });
}

function reportBillDay(reModel) {
    var list = reModel.list;
    $("#dayInfo table>tbody").empty();
    if (list.length > 0) {
        for(var i=0;i<list.length;i++){
            var tr = $("<tr></tr>");
            tr.append("<td>"+list[i].billMonth+"</td>");
            tr.append("<td>"+list[i].usedCount+"</td>");
            tr.append("<td>"+list[i].usedData+"</td>");
            tr.append("<td>"+$.formatMoney($.numDiv(list[i].billFee, 1000), 2)+"</td>");
            $("#dayInfo table>tbody").append(tr);
        }
        $("#dayInfo .page").html(reModel.html);
    } else {
        $("#dayInfo .page").empty();
        $("#dayInfo .no-data").remove();
        $("#dayInfo table").after(noTips);
    }
}

function reportBillCust(reModel) {
    var list = reModel.list;
    $("#custCurMonthlyInfo table>tbody").empty();
    if (list.length > 0) {
        for(var i=0;i<list.length;i++){
            var tr = $("<tr></tr>");
            tr.append("<td>"+list[i].billMonth+"</td>");
            tr.append("<td>"+list[i].custName+"</td>");
            tr.append("<td>"+list[i].usedCount+"</td>");
            tr.append("<td>"+list[i].usedData+"</td>");
            tr.append("<td>"+$.formatMoney($.numDiv(list[i].billFee, 1000), 2)+"</td>");
            $("#custCurMonthlyInfo table>tbody").append(tr);
        }
        $("#custCurMonthlyInfo .page").html(reModel.html);
    } else {
        $("#custCurMonthlyInfo .page").empty();
        $("#custCurMonthlyInfo .no-data").remove();
        $("#custCurMonthlyInfo table").after(noTips);
    }
}

function reportBillRegion(reModel) {
    var list = reModel.list;
    $("#regionCurMonthlyInfo table>tbody").empty();
    if (list.length > 0) {
        var usedTotal = 0, incomeTotal = 0, billFeeTotal = 0, totalFeeTotal = 0;
        for(var i=0;i<list.length;i++){
            var tr = $("<tr></tr>");
            tr.append("<td>"+list[i].billMonth+"</td>");
            tr.append("<td>"+list[i].regionName+"</td>");
            tr.append("<td>"+list[i].usedCount+"</td>");
            tr.append("<td>"+$.formatMoney($.numDiv(list[i].income, 1000), 2)+"</td>");
            tr.append("<td>"+$.formatMoney($.numDiv(list[i].billFee, 1000), 2)+"</td>");
            tr.append("<td>"+$.formatMoney($.numDiv(list[i].totalFee, 1000), 2)+"</td>");
            $("#regionCurMonthlyInfo table>tbody").append(tr);

            usedTotal += list[i].usedCount;
            incomeTotal += list[i].income;
            billFeeTotal += list[i].billFee;
            totalFeeTotal += list[i].totalFee;
        }

        var tr = $("<tr></tr>");
        tr.append("<td>合计</td>");
        tr.append("<td></td>");
        tr.append("<td>"+usedTotal+"</td>");
        tr.append("<td>"+$.formatMoney($.numDiv(incomeTotal, 1000), 2)+"</td>");
        tr.append("<td>"+$.formatMoney($.numDiv(billFeeTotal, 1000), 2)+"</td>");
        tr.append("<td>"+$.formatMoney($.numDiv(totalFeeTotal, 1000), 2)+"</td>");
        $("#regionCurMonthlyInfo table>tbody").append(tr);

        /*$("#regionCurMonthlyInfo .page").html(reModel.html);*/
    } else {
        /*$("#regionCurMonthlyInfo .page").empty();*/
        $("#regionCurMonthlyInfo .no-data").remove();
        $("#regionCurMonthlyInfo table").after(noTips);
    }
}

function reportBillGoods(reModel) {
    var list = reModel.list;
    $("#goodsCurMonthlyInfo table>tbody").empty();
    if (list.length > 0) {
        for(var i=0;i<list.length;i++){
            var tr = $("<tr></tr>");
            tr.append("<td>"+list[i].goodsName+"</td>");
            tr.append("<td>"+list[i].usedCount+"</td>");
            tr.append("<td>"+$.formatMoney($.numDiv(list[i].billFee, 1000), 2)+"</td>");
            $("#goodsCurMonthlyInfo table>tbody").append(tr);
        }

        $("#goodsCurMonthlyInfo .page").html(reModel.html);
    } else {
        $("#goodsCurMonthlyInfo .page").empty();
        $("#goodsCurMonthlyInfo .no-data").remove();
        $("#goodsCurMonthlyInfo table").after(noTips);
    }
}

function exportReport(ii) {
    window.location.href = ctx + "/reports/exportReports.html?index=" + ii + "&custId=" + obj.custId + "&custName=" + obj.custName;
}