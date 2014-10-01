
function cargarBasePag(){
    $("#informaciontutor").hide();
    cargarCombos();
    cargarEventoTiposDoc();
    cargarEnvio();
}

function cargarEnvio() {
    
    
    $("#formRegistro").on("submit",function(event){
        event.preventDefault();
        
        if(datosMal()){
             alertify.alert("<b>Verifica que todos los Datos sean Correctos</b>");
        }else{
        
            var datos = $(this).serialize();
            //if(!hayErrores){
                $.ajax({
                    type: "POST",
                    url: "../php/controlador/accionesInsert.php",
                    data: datos,
                    dataType: 'json',
                    success: function (data, textStatus, jqXHR) {
                        if(data.codigo==0){
                            alertify.alert("<b>Registro Realizado con Exito</b>",function (){
                                $(location).attr('href',"http://profesiongamer.com");
                            });
                            //alert("Registro Realizado con exito");  
                        }else {
                            alertify.alert("<b>No es Posible Registrarte en este Momento</b>",function (){
                                $(location).attr('href',"http://profesiongamer.com");
                            });
                        }
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        alert(textStatus);
                    }
                });
            //}
        }
        
    });
}


function datosMal(){
    
    var resultado = true;
    
    if(($("#pass").val() != $("#pass2").val()) || $("#pass").val().length < 3){
        resultado = false;
    }
    
    if($("#nombre").val() != "" &&
            $("#apellidos").val() != "" &&
            $("#tipo_doc").val() != 0 &&
            $("#num_doc").val() != "" &&
            $("#correo").val() != "" &&
            $("#genero").val() != 0 &&
            $("#ciudad").val() != 0 &&
            $("#celular").val() != "" &&
            $("#id_play").val() != ""){
        resultado = false;
    } 
    return resultado;
}


function cargarCombos(){
    var tiposDoc= $("#tipo_doc, #tutor_tipo_doc");
    $.ajax({
        url: "../php/controlador/accionesConsulta.php",
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
        url: "../php/controlador/accionesConsulta.php",
        dataType: 'json',
        type: 'POST',
        data:"opcion=ciudades",
        success: function (data, textStatus, jqXHR) {
            $(data).each(function (i,ciudad){
                combCiudad.append( $("<option>").attr({
                    value:ciudad.id
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

function cargarEventoTiposDoc(){
    $("#tipo_doc").change(function (){
	if(this.value==2){
            $("#informaciontutor").show();
	}else{
            $("#informaciontutor").hide();
	}
    });
}
