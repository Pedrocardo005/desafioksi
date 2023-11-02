var form = document.getElementById("send-film");
var deleteButtons = document.querySelectorAll(".deletar");
var confirmDelete = document.getElementById("apagar");

form.addEventListener("submit", function (ev) {
    ev.preventDefault();

    var formData = new FormData(form);

    var filme = {};

    formData.forEach(function (valor, atributo) {
        filme[atributo] = valor;
    });

    const options = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(filme),
    }

    fetch("http://localhost:8080/filmes", options)
        .then(response => {
            if(response.ok) {
                location.reload();
            }
        });
});

deleteButtons.forEach(function (element) {
    element.addEventListener("click", function () {
        let id = element.getAttribute("data-id");

        window.localStorage.setItem("registro", id);
    });
});

confirmDelete.addEventListener("click", function (ev) {
    const id = window.localStorage.getItem("registro");
    const options = {
        method: "DELETE",
    };

    fetch("http://localhost:8080/filmes/" + id, options)
        .then(() => {
            window.localStorage.removeItem("registro");
            location.reload();
        });
});