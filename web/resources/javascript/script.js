/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function init_comp(classId) {
    //навешиваем обраобтчик нажатия кнопки в текстовом поле, по которому 
    //все радиобаттоны отменяются
    $('div.inputtextclass_' + classId + ' input[type=text]').bind('keypress',
            function() {
                $('div.inputtextclass_' + classId + ' input[type=radio]').removeAttr('checked');
            });


    //навешиваем обработчик на радиобуттоны
    //если отмечена радиобуттон то не может быть значения в поле
    //не может быть отмечено одновременно более одного радиобуттона
    $('div.inputtextclass_' + classId + ' input[type=radio]').bind('click',
            function() {
                $('div.inputtextclass_' + classId + ' input[type=text]').attr('value', '');
                var chkCount = $('div.inputtextclass_' + classId + ' input[type=radio]:checked').size();
                if (chkCount > 1) {
                    $('div.inputtextclass_' + classId + ' input[type=radio]').removeAttr('checked');
                }
            });
}



//если есть не заполненные блоки отменяем отправку форм
function isSetValue() {
    var result = false;
    var value = $('div.inputtextclass input[type=text]').attr('value');
    if ($.trim(value) !== '') {
        return true;
    }
    var checkCount = $('div.inputtextclass input[type=radio]:checked').size();
    if (checkCount === 0) {
        addNotice('Введены не все данные!');
        return false;
    }
    return true;
}


function addNotice(notice) {
    
    $('#growl').css('top',parseInt($('#topbar').height()+15)+'px');
    
    $('<div class="notice"></div>')
            .append('<div class="skin"></div>')            
            .append($('<div class="content"></div>').html(notice))
            .hide()
            .appendTo('#growl')
            .fadeIn(1000);

    setTimeout('closeNotify()', 3000);
}

function closeNotify() {
    $('#growl')
            .find('.notice')
            .animate({
                border: 'none',
                height: 0,
                marginBottom: 0,
                marginTop: '-6px',
                opacity: 0,
                paddingBottom: 0,
                paddingTop: 0,
                queue: false
            }, 1000, function() {
                $(this).remove();
            });
}





