// Call the dataTables jQuery plugin
$(document).ready(function() {
  

  cargarUsuarios();


  $('#usuarios').DataTable();
});

async function cargarUsuarios(){
  const request = await fetch('api/usuarios',{
    method:'GET',
    headers:getHeaders()
  });
  const usuarios=await request.json();

  let listaHmtl= ' ';
  for(let usuario of usuarios){
    let botonEliminar='<a href="#" onclick="eliminarUsuario('+usuario.id+')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';
    let usuariohtml='<tr><td>'+usuario.id+'</td><td>'+usuario.nombre+
    ' '+usuario.apellido+'</td>'+usuario.email+
    '</td><td>'+usuario.telefono+
    '</td><td>'+botonEliminar+'</td></tr>';
    listaHmtl+=usuariohtml;
  }

  console.log(usuarios)

  document.querySelector('#usuarios tbody').outerHTML=listaHmtl;
}

function getHeaders(){
  return{
    'Accept':'application/json',
    'Content-Type':'application/json',
    'Authorization':localStorage.token
  };
}

async function eliminarUsuario(id){
  if(confirm('¿Desea eliminar este usuaio?')){
    const request = await fetch('api/usuarios/'+id,{
      method:'DELETE',
      headers:getHeaders()
    });
  }

  location.reload();
}


