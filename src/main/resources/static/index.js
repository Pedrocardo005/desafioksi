var deleteButtons = document.querySelectorAll(".deletar");
var confirmDelete = document.getElementById("apagar");

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