const url = "http://localhost:8084/album/"
const url1 = "http://localhost:8084/album/list"
const contenedor = document.querySelector('tbody')
let resultados = ''

const modalAlbum = new bootstrap.Modal(document.getElementById('modalAlbum'))
const formAlbums = document.querySelector('form')
const tipoCliente = document.getElementById('tipdoc')
const idAlbum = document.getElementById('id')
const nombreAlbum = document.getElementById('nombre')
const AñoPublicacion = document.getElementById('año');
const btnCrear = document.getElementById('btnCrear');
const btnCerrar = document.getElementById('btn-close');
const btnX = document.getElementById('btn-x');
let opcion = ''

btnCrear.addEventListener('click', () => {
    idAlbum.value = ''
    nombreAlbum.value = ''
    idAlbum.disabled = false
    modalAlbum.show()
    opcion = 'crear'
})

btnCerrar.addEventListener('click', () => {
    modalAlbum.hide();
})
btnX.addEventListener('click', () => {
    modalAlbum.hide();
})

//funcion para mostrar resultados

const mostrar = (Albums) => {
    Albums.forEach(Album => {
        resultados += `<tr>
                        <td >${Album.id_album}</td>
                        <td >${Album.nombre_album}</td>
                        <td >${Album.año_publicacion}</td>
                        <td class="text-center" width="20%"><a class="btnEditar btn btn-primary">Editar</a><a class="btnBorrar btn btn-danger">Borrar</a></td>
                    </tr>`
    })

    contenedor.innerHTML = resultados
}

//procedimiento mostrar registros
fetch(url1)
    .then(response => response.json())
    .then(data => mostrar(data))
    .catch(error => console.log(error))

const on = (element, event, selector, handler) => {
    element.addEventListener(event, e => {
        if (e.target.closest(selector))
            handler(e)
    })
}

on(document, 'click', '.btnBorrar', e => {
    const fila = e.target.parentNode.parentNode
    const id = fila.firstElementChild.innerHTML
    console.log(id)

    alertify.confirm("Desea eliminar el Album " + id,
        function () {
            fetch(url + id, {
                method: 'DELETE'
            })
                .then(() => location.reload())
        },
        function () {
            alertify.error('Cancel')
        });
})

let idForm = 0
on(document, 'click', '.btnEditar', e => {

    const fila = e.target.parentNode.parentNode

    idForm = fila.children[0].innerHTML
    const nombre = fila.children[1].innerHTML
    const año = fila.children[2].innerHTML
    idAlbum.value = idForm
    idAlbum.disabled = true
    nombreAlbum.value = nombre
    AñoPublicacion.value = año

    opcion = 'editar'
    modalAlbum.show()
})

formAlbums.addEventListener('submit', (e) => {
    e.preventDefault()

    if (opcion == 'crear') {
        fetch(url, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id_album: idAlbum.value,
                nombre_album: nombreAlbum.value,
                año_publicacion: AñoPublicacion.value
            })
        })
            .then(response => response.json())
            .then(data => {
                const nuevoAlbum = []
                nuevoAlbum.push(data)
                mostrar(nuevoAlbum)
            })
    }
    if (opcion == 'editar') {

        fetch(url, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                id_album: idAlbum.value,
                nombre_album: nombreAlbum.value,
                año_publicacion: AñoPublicacion.value
            })
        })
            .then(response => location.reload())

    }
    modalAlbum.hide()

})
