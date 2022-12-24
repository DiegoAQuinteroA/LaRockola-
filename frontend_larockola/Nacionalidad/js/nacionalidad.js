const url = "http://localhost:8084/nacionalidad/"
const url1 = "http://localhost:8084/nacionalidad/list"


const contenedor = document.querySelector('tbody');
let resultados = '';

const modalNacionalidad = new
    bootstrap.Modal(document.getElementById('modalNacionalidad'));
const formNacionalidad = document.querySelector('form');
const idNacionalidad = document.getElementById('id');
const nombreNacionalidad = document.getElementById('nombre');
const btnCerrar = document.getElementById('btn-close');
const btnX = document.getElementById('btn-x');
const btnCrear = document.getElementById('btnCrear');

let opcion = '';

btnCrear.addEventListener('click', () => {
    idNacionalidad.value = '';
    nombreNacionalidad.value = '';
    idNacionalidad.disabled = true;
    modalNacionalidad.show();
    opcion = 'crear'
})
btnCerrar.addEventListener('click', () => {
    modalNacionalidad.hide();
})

btnX.addEventListener('click', () => {
    modalNacionalidad.hide();
})
const mostrar = (Nacionalidad) => {
    Nacionalidad.forEach(Nacionalidad => {
        resultados += `<tr><td >${Nacionalidad.id_nacionalidad}</td><td >${Nacionalidad.nombre_nacionalidad}</td>
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
    idNacionalidad.value = idForm;
    nombreNacionalidad.value = nombre;
    opcion = 'editar';
    modalNacionalidad.show()
});
formNacionalidad.addEventListener('submit', (e) => {
    e.preventDefault()
    if (opcion == 'crear') {
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id_nacionalidad: idNacionalidad.value,
                nombre_nacionalidad: nombreNacionalidad.value
            })
        })
            .then(response => response.json())
            .then(data => {
                const nuevaNacionalidad = []
                nuevaNacionalidad.push(data)
                mostrar(nuevaNacionalidad)
            })
    }
    if (opcion == 'editar') {
        fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id_nacionalidad: idNacionalidad.value,
                nombre_nacionalidad: nombreNacionalidad.value
            })
        })
            .then(response => location.reload())
    }
    modalNacionalidad.hide();

})