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
    obj.billMonth = $("#billMonth").val();

    if(obj.custName == "") {
        $("#s_custId").val("");
        obj.custId = "";
    }
    reportBill(1,8,1);
    reportBill(1,8,2);
    reportBill(1,8,3);
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
}

function reportBill(n,s,ii) {
    var index = layer.load(2);
    var custId = "";
    var custName = "";
    var billMonth = "";
    if(obj != null){
        custId = obj.custId;
        custName = obj.custName;
        billMonth = obj.billMonth;
    }

    var url = ctx + "/reports";

    switch (ii) {
        case 1 : url += "/billHisPage.ajax";break;
        case 2 : url += "/costRatePage.ajax";break;
        case 3 : url += "/costGoodsPage.ajax";break;
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
            custName:custName,
            billMonth: billMonth
        },
        success : function (cr) {
            layer.close(index);
            if(cr.reType){
                switch (ii) {
                    case 1 : reportBillHis(cr.reModel);break;
                    case 2 : reportBillCostRate(cr.reModel);break;
                    case 3 : reportBillCostGoods(cr.reModel);break;
                    default : ;
                }
            }else{
                layer.alert(cr.msg);
            }
        }
    });
}

function reportBillHis(reModel) {
    $("#billHis table>tbody").empty();
    $("#billHis .no-data").remove();

    var list = reModel.list;
    if (list.length > 0) {
        var proTotal = 0, pubTotal = 0, billFeeTotal = 0;
        for(var i=0;i<list.length;i++){
            var tr = $("<tr></tr>");
            tr.append("<td>"+list[i].billMonth+"</td>");
            tr.append("<td>"+list[i].custName+"</td>");
            tr.append("<td>"+list[i].userMobile+"</td>");
            tr.append("<td>"+list[i].regionName+"</td>");
            tr.append("<td>"+list[i].proGoodsNum+"</td>");
            tr.append("<td>"+list[i].pubGoodsNum+"</td>");
            tr.append("<td>"+$.formatMoney($.numDiv(list[i].billFee, 1000), 2)+"</td>");
            tr.append("<td>"+list[i].billStateName+"</td>");
            $("#billHis table>tbody").append(tr);

            proTotal += list[i].proGoodsNum;
            pubTotal += list[i].pubGoodsNum;
            billFeeTotal += list[i].billFee;
        }
        var fee = $.numDiv(billFeeTotal, 1000);

        var tr = $("<tr></tr>");
        tr.append("<td>合计</td>");
        tr.append("<td></td>");
        tr.append("<td></td>");
        tr.append("<td></td>");
        tr.append("<td>"+proTotal+"</td>");
        tr.append("<td>"+pubTotal+"</td>");
        tr.append("<td>"+$.formatMoney(fee, 2)+"</td>");
        tr.append("<td></td>");
        $("#billHis table>tbody").append(tr);

        $("#billHis .page").html(reModel.html);
    } else {
        $("#billHis .page").empty();
        $("#billHis table").after(noTips);
    }
}

function reportBillCostRate(reModel) {
    $("#costRate table>tbody").empty();
    $("#costRate .no-data").remove();

    var list = reModel.list;
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
            $("#costRate table>tbody").append(tr);

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
        $("#costRate table>tbody").append(tr);

        // $("#costRate .page").html(reModel.html);
    } else {
        $("#costRate .page").empty();
        $("#costRate table").after(noTips);
    }
}

function reportBillCostGoods(reModel) {
    $("#costGoods table>tbody").empty();
    $("#costGoods .no-data").remove();

    var list = reModel.list;
    if (list.length > 0) {
        for(var i=0;i<list.length;i++){
            var tr = $("<tr></tr>");
            tr.append("<td>"+list[i].billMonth+"</td>");
            tr.append("<td>"+list[i].goodsName+"</td>");
            tr.append("<td>"+list[i].usedCount+"</td>");
            tr.append("<td>"+$.formatMoney($.numDiv(list[i].billFee, 1000), 2)+"</td>");
            $("#costGoods table>tbody").append(tr);
        }

        $("#costGoods .page").html(reModel.html);
    } else {
        $("#costGoods .page").empty();
        $("#costGoods table").after(noTips);
    }
}

function exportReport(ii) {
    window.location.href = ctx + "/reports/exportReports.html?index=" + ii + "&custId=" + obj.custId + "&custName=" + obj.custName + "&billMonth=" + obj.billMonth;
}