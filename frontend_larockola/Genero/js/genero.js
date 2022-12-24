const url = "http://localhost:8084/genero/";
const url1 = "http://localhost:8084/genero/list";

const contenedor = document.querySelector('tbody');
let resultados = '';

const modalGenero = new
    bootstrap.Modal(document.getElementById('modalGenero'));
const formGenero = document.querySelector('form');
const idGenero = document.getElementById('id');
const nombreGenero = document.getElementById('nombre');
const btnCrear = document.getElementById('btnCrear');
const btnCerrar = document.getElementById('btn-close');
const btnX = document.getElementById('btn-x');

let opcion = '';

btnCrear.addEventListener('click', () => {
    idGenero.value = '';
    nombreGenero.value = '';
    idGenero.disabled = true;
    modalGenero.show();
    opcion = 'crear'
})

btnCerrar.addEventListener('click', () => {
    modalGenero.hide();
})
btnX.addEventListener('click', () => {
    modalGenero.hide();
})
const mostrar = (Genero) => {
    Genero.forEach(Genero => {
        resultados += `<tr><td>${Genero.id_genero}</td><td >${Genero.nombre_genero}</td>
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

    alertify.confirm("Desea eliminar el Genero " + id, function () {
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
    idGenero.value = idForm;
    idGenero.disabled = true;
    nombreGenero.value = nombre;
    opcion = 'editar';
    modalGenero.show()
});

formGenero.addEventListener('submit', (e) => {
    e.preventDefault()
    if (opcion == 'crear') {
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id_genero: idGenero.value,
                nombre_genero: nombreGenero.value
            })
        })
            .then(response => response.json())
            .then(data => {
                const nuevoGenero = []
                nuevoGenero.push(data)
                mostrar(nuevoGenero)
            })
    }
    if (opcion == 'editar') {
        fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id_genero: idForm,
                nombre_genero: nombreGenero.value
            })
        })
            .then(response => location.reload())
    }
    modalGenero.hide()
})