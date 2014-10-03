/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function cargarLogin(){
    cargarCombos();
    $("#btnSumLogin").on("click",function (){
        $(location).attr('href',"../accionConsultarDatos");
    });
}

function validarLogin(){
    
}

function cargarCombos(){
    var tiposDoc= $("#tipo_doc, #tutor_tipo_doc");
    $.ajax({
        url: "../accionConsultarDatos",
        dataType: 'json',
        type: 'POST',
        data:"opcion=tiposDoc",
        success: function (data, textStatus, jqXHR) {
            $(data).each(function (i,doc){
                tiposDoc.append( $("<option>").attr({
                    value:doc.id
                }).text(doc.nombre_doc));
            });
            $("#tutor_tipo_doc").children().each(function (i,op){
                var _op = $(op);
                if(_op.val()==2){
                   _op.remove();
                }
            });
        },
        error: function (jqXHR, textStatus, errorThrown) {

        }
    });
    
    var combCiudad= $("#ciudad");
    $.ajax({
        url: "../accionConsultarDatos",
        dataType: 'json',
        type: 'POST',
        data:"opcion=ciudades",
        success: function (data, textStatus, jqXHR) {
            $(data).each(function (i,ciudad){
                combCiudad.append( $("<option>").attr({
                    value:ciudad.idCiudad
                }).text(ciudad.nombre));
            });
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(textStatus);
        }
    });
    
    $.datepicker.regional['es'] = {
        closeText: 'Cerrar',
        prevText: ' nextText: "Sig>"',
        currentText: 'Hoy',
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio',
        'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
        'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
        dayNamesShort: ['Dom', 'Lun', 'Mar', 'Mié;', 'Juv', 'Vie', 'Sáb'],
        dayNamesMin: ['Do', 'Lu', 'Ma', 'Mi', 'Ju', 'Vi', 'Sá'],
        weekHeader: 'Sm',
        dateFormat: 'dd/mm/yy',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''
        };
        $.datepicker.setDefaults($.datepicker.regional['es']);
    
    $("#fecha_naci").datepicker();
    
}

