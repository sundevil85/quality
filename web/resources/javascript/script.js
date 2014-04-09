/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//начальная инициализация
$(function() {

    //скроолинг к началу страницы
    $('.backtotop').click(function() {
       $('html, body').animate({scrollTop: 0}, 'slow');       
    });

});


//глобальный массив номеров вопросов для проверки средствами JS
var global_quests = new Array();
var global_quests_length = 0;


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


//помещает в глобальный массив номера вопросов для проверки заполненности через JS
function addQuest(qNum) {
    global_quests[global_quests_length++] = qNum;
}

//если есть не заполненные блоки отменяем отправку форм
function isSetValue() {

    var setQ = 0; //количество заполненных ответов
    //
    //сначала пробегаем по текстовым полям
    for (var i = 0; i < global_quests.length; i++) {
        var value = $('div.inputtextclass_' + global_quests[i] + ' input[type=text]').attr('value');
        if ($.trim(value) !== '') {
            setQ++;
        }
    }

    if (setQ === global_quests.length) { //если количество заполненных совпадает с общим кол-вом        
        return true;
    }

    //прибавляем кол-во отмеченных радиобуттонов
    for (var i = 0; i < global_quests.length; i++) {
        var checkCount = $('div.inputtextclass_' + global_quests[i] + ' input[type=radio]:checked').size();
        setQ += checkCount;
    }

    if (setQ === global_quests.length) { //если количество заполненных совпадает с общим кол-вом       
        return true;
    }

    addNotice('Введены не все данные!', 3000);
    return false;
}


function addNotice(notice, timeout) {

    //показываем сообщения только если нет сообщений от <rich:message>   
    var flag = false;
    $('.error_class').each(function() {
        if (flag === false) {
            var tmp = $(this).css('width');
            if (parseInt(tmp) > 0) {
                flag = true;
            }
        }
    });
    //если есть отображаемые элементы с текстом ошибок то выходим
    if (flag === true) {
        return;
    }



    $('#growl').css('top', parseInt($('#topbar').height() + 15) + 'px');

    $('<div class="notice"></div>')
            .append('<div class="skin"></div>')
            .append($('<div class="content"></div>').html(notice))
            .hide()
            .appendTo('#growl')
            .fadeIn(1000);

    setTimeout('closeNotify()', timeout);
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





