const url = "http://localhost:8084/artista/";
const url1 = "http://localhost:8084/artista/list";

const contenedor = document.querySelector('tbody');
let resultados = '';

const modalArtista = new
    bootstrap.Modal(document.getElementById('modalArtista'));
const formArtista = document.querySelector('form');
const idArtista = document.getElementById('id');
const nombreArtista = document.getElementById('nombre');
const añoArtista = document.getElementById('año');
const idnacionalidad = document.getElementById('id-nacionalidad');
const btnCrear = document.getElementById('btnCrear');
const btnCerrar = document.getElementById('btn-close');
const btnX = document.getElementById('btn-x');

let opcion = '';

btnCrear.addEventListener('click', () => {
    idArtista.value = '';
    nombreArtista.value = '';
    añoArtista.value = "";
    idnacionalidad.value = "";
    idArtista.disabled = true;
    modalArtista.show();
    opcion = 'crear'
})
btnCerrar.addEventListener('click', () => {
    modalArtista.hide();
})
btnX.addEventListener('click', () => {
    modalArtista.hide();
})

const mostrar = (Artista) => {
    Artista.forEach(Artista => {
        resultados += `<tr><td >${Artista.id_artista}</td><td >${Artista.nombre_artista}</td><td >${Artista.año_artista}</td><td >${Artista.nacionalidad.id_nacionalidad}</td>
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
    alertify.confirm("Desea eliminar el Artista " + id, function () {
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
    const año = fila.children[2].innerHTML;
    const nacionalidad = fila.children[3].innerHTML;
    idArtista.value = idForm;
    nombreArtista.value = nombre;
    añoArtista.value = año;
    idnacionalidad.value = nacionalidad;
    opcion = 'editar';
    modalArtista.show()
});
formArtista.addEventListener('submit', (e) => {
    e.preventDefault()
    if (opcion == 'crear') {
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id_artista: idArtista.value,
                nombre_artista: nombreArtista.value,
                año_artista: añoArtista.value,
                nacionalidad: { id_nacionalidad: idnacionalidad.value }
            })
        })
            .then(response => response.json())
            .then(data => {
                const nuevaArtista = []
                nuevaArtista.push(data)
                mostrar(nuevaArtista)
            })
    }
    if (opcion == 'editar') {
        fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id_artista: idForm,
                nombre_artista: nombreArtista.value,
                año_artista: añoArtista.value,
                nacionalidad: { id_nacionalidad: idnacionalidad.value }
            })
        })
            .then(response => location.reload())
    }
    modalArtista.hide();

})
