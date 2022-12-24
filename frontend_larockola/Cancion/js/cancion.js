const url = "http://localhost:8084/cancion/";
const url1 = "http://localhost:8084/cancion/list";

const contenedor = document.querySelector('tbody');
let resultados = '';

const modalCancion = new
    bootstrap.Modal(document.getElementById('modalCancion'));
const formCancion = document.querySelector('form');
const idCancion = document.getElementById('id');
const nombreCancion = document.getElementById('nombre');
const idGenero = document.getElementById('id-genero');
const idAlbum = document.getElementById('id-album');
const btnCrear = document.getElementById('btnCrear');
const btnCerrar = document.getElementById('btn-close');
const btnX = document.getElementById('btn-x');

let opcion = '';

btnCrear.addEventListener('click', () => {
    idCancion.value = '';
    nombreCancion.value = '';
    idGenero.value = "";
    idAlbum.value = "";
    idCancion.disabled = true;
    modalCancion.show();
    opcion = 'crear'
})
btnCerrar.addEventListener('click', () => {
    modalCancion.hide();
})
btnX.addEventListener('click', () => {
    modalCancion.hide();
})

const mostrar = (Cancion) => {
    Cancion.forEach(Cancion => {
        resultados += `<tr><td >${Cancion.id_cancion}</td><td >${Cancion.nombre_cancion}</td><td >${Cancion.genero.id_genero}</td><td >${Cancion.album.id_album}</td>
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
    const genero = fila.children[2].innerHTML;
    const album = fila.children[3].innerHTML;
    idCancion.value = idForm;
    nombreCancion.value = nombre;
    idGenero.value = genero;
    idAlbum.value = album;
    opcion = 'editar';
    modalCancion.show()
});
formCancion.addEventListener('submit', (e) => {
    e.preventDefault()
    if (opcion == 'crear') {
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id_cancion: idCancion.value,
                nombre_cancion: nombreCancion.value,
                genero: { id_genero: idGenero.value },
                album: { id_album: idAlbum.value }
            })
        })
            .then(response => response.json())
            .then(data => {
                const nuevaCancion = []
                nuevaCancion.push(data)
                mostrar(nuevaCancion)
            })
    }
    if (opcion == 'editar') {
        fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id_cancion: idForm,
                nombre_cancion: nombreCancion.value,
                genero: { id_genero: idGenero.value },
                album: { id_album: idAlbum.value }
            })
        })
            .then(response => location.reload())
    }
    modalCancion.hide();

})

