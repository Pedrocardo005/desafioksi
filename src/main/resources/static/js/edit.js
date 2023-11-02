var form = document.querySelector("form");

form.addEventListener("submit", function (ev) {
    ev.preventDefault();
    
    var formData = new FormData(form);

    var filme = {};

    formData.forEach(function (valor, atributo) {
        filme[atributo] = valor;
    });

    const options = {
        method: "PATCH",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(filme),
    }

    fetch("http://localhost:8080/filmes/filme", options)
        .then(response => {
            if(response.ok) {
                console.log("A reposta", response.text());
            }
        });
});