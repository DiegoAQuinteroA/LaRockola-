const url = "http://localhost:8084/usuario/";
const url1 = "http://localhost:8084/usuario/list";

const contenedor = document.querySelector('tbody');
let resultados = '';

const modalUsuario = new
    bootstrap.Modal(document.getElementById('modalUsuario'));
const formUsuario = document.querySelector('form');
const idUsuario = document.getElementById('id');
const nombreUsuario = document.getElementById('nombre');
const emailUsuario = document.getElementById('email');
const claveUsuario = document.getElementById('password');
const btnCrear = document.getElementById('btnCrear');
const btnCerrar = document.getElementById('btn-close');
const btnX = document.getElementById('btn-x');

let opcion = '';

btnCrear.addEventListener('click', () => {
    idUsuario.value = '';
    nombreUsuario.value = '';
    emailUsuario.value = "";
    claveUsuario.value = "";
    modalUsuario.show();
    opcion = 'crear'
})
btnCerrar.addEventListener('click', () => {
    modalUsuario.hide();
})
btnX.addEventListener('click', () => {
    modalUsuario.hide();
})

const mostrar = (Usuario) => {
    Usuario.forEach(Usuario => {
        resultados += `<tr><td >${Usuario.id_usuario}</td><td >${Usuario.nombre_usu}</td><td >${Usuario.email_usu}</td><td >${Usuario.contraseña_usu}</td>
<td class="text-center" width="20%"><a class="btnEditar btn btn-primary">Editar</a><a class="btnBorrar btn btn-danger">Borrar</a></td></tr>`});
    contenedor.innerHTML = resultados;
}

fetch(url1)
    .then(response => response.json())
    .then(data => mostrar(data))
    .catch(error => console.log(error));


const on = (element, event, selector, handler) => {
    element.addEventListener(event, e => {
        if (e.target.closest(selector)) handler(e)
    })
}

on(document, 'click', '.btnBorrar', e => {
    const fila = e.target.parentNode.parentNode;
    const id = fila.firstElementChild.innerHTML;
    console.log(id)

    alertify.confirm("Desea eliminar el Usuario " + id, function () {
        fetch(url + id, {
            method: 'DELETE'
        })
            .then(() => location.reload())
    },
        function () {
            alertify.error('Cancel')
        });
})

let idForm = 0;
on(document, 'click', '.btnEditar', e => {
    const fila = e.target.parentNode.parentNode;
    idForm = fila.children[0].innerHTML;
    const nombre = fila.children[1].innerHTML;
    const email = fila.children[2].innerHTML;
    const password = fila.children[3].innerHTML;
    idUsuario.value = idForm;
    nombreUsuario.value = nombre;
    emailUsuario.value = email;
    claveUsuario.value = password;
    opcion = 'editar';
    modalUsuario.show()
});
formUsuario.addEventListener('submit', (e) => {
    e.preventDefault()
    if (opcion == 'crear') {
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id_usuario: idUsuario.value,
                nombre_usu: nombreUsuario.value,
                email_usu: emailUsuario.value,
                contraseña_usu: claveUsuario.value
            })
        })
            .then(response => response.json())
            .then(data => {
                const nuevoUsuario = []
                nuevoUsuario.push(data)
                mostrar(nuevoUsuario)
            })
    }
    if (opcion == 'editar') {
        fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id_usuario: idForm,
                nombre_usu: nombreUsuario.value,
                email_usu: emailUsuario.value,
                contraseña_usu: claveUsuario.value
            })
        })
            .then(response => location.reload())
    }
    modalUsuario.hide();

})

