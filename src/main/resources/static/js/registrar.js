async function registrarUsuario(){
    let datos={};
    datos.nombre=document.getElementById('txtnombre').value;
    datos.apellido=document.getElementById('txtapellido').value;
    datos.email=document.getElementById('txtemail').value;
    datos.password=document.getElementById('txtpassword').value;

    let repetirPassword=document.getElementById('txtrepeatpassword').value;

    if(repetirPassword !=datos.password){
        alert('La contraseña es diferente');
        return;
    }

    const request= await fetch('api/usuarios',{
        method:'POST',
        headers:{
            'Accept':'application/json',
            'Content-Type':'application/json'
        },
        body:JSON.stringify(datos)
    });

    alert('Se registro correctamente');

    window.location.href='login.html';
}