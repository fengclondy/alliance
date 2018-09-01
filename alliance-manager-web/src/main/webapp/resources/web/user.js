$(function(){
	$('select').selectOrDie();
    $(".role-assigned li").click(function(){
        if($(this).hasClass('selected')){
            $(this).removeClass('selected');
        }else{
            $(this).addClass('selected');
        }
    });
    //移到右边
    $('#add').click(function() {
    //获取选中的选项，删除并追加给对方
        $('#select2 li.selected').appendTo('#select1');
    });
    //移到左边
    $('#remove').click(function() {
        $('#select1 li.selected').appendTo('#select2');
    });
    //全部移到右边
    $('#add_all').click(function() {
        //获取全部的选项,删除并追加给对方
        $('#select2 li').appendTo('#select1');
    });
    //全部移到左边
    $('#remove_all').click(function() {
        $('#select1 li').appendTo('#select2');
    });
});