async function iniciarSesion(){
    let datos={};
    datos.email=document.getElementById('txtemail').value;
    datos.password=document.getElementById('txtpassword').value;

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    const response=await request.text();

    if(response!='FAILD'){
        localStorage.token=response;
        localStorage.email=datos.email;
        window.location.href='usuarios.html';
    }else{
        alert('Credenciales son incorrectas');
    }
}