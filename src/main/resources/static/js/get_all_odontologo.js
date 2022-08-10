window.addEventListener('load', function () {
    (function(){

      //con fetch invocamos a la API de odontologos con el método GET
      //nos devolverá un JSON con una colección de odontologos
      const url = 'http://localhost:8080/odontologos';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
      //recorremos la colección de odontologos del JSON
         for(odontologo of data){
         console.log('-------------- DATA----------- ', data)
            //por cada odontologo armaremos una fila de la tabla
            //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos el odontologo
            var odontologoRow =table.insertRow();
            let tr_id = 'tr_' + odontologo.id;
            odontologoRow.id = tr_id;

            let deleteLink='<a id=\"a_delete_'+odontologo.id+'\"'+
            ' href=\"#\" onclick=\"deleteBy('+odontologo.id+')\"'+
            ' class=\"link-danger\">Borrar</a>';

            //armamos cada columna de la fila
            //como primer columna pondremos el boton modificar
            //luego los datos del odontologo
            //como ultima columna el boton eliminar
            odontologoRow.innerHTML =
                    '<td class=\"td_id\">' + odontologo.id + '</td>' +
                    '<td class=\"td_apellido\">' + odontologo.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_nombre\">' + odontologo.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_matricula\">' + odontologo.matricula + '</td>'+
                    '<td>'+deleteLink+'</td>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "http://localhost:8080/tp/odontologos") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })